package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.ProjectMapper;
import org.tonzoc.model.IndustryCategoryModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.support.ReturnProjectModel;
import org.tonzoc.service.IProjectService;
import org.tonzoc.support.param.SqlQueryParam;

import java.math.BigDecimal;
import java.util.*;

@Service("projectService")
public class ProjectService extends BaseService<ProjectModel> implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private IndustryCategoryService industryCategoryService;

    // 数量
    public Integer count() {

        return projectMapper.count();
    }

    // 全部项目的数据
    public List<ReturnProjectModel> dateAll() {
        List<ReturnProjectModel> list = new ArrayList<>();
        ReturnProjectModel returnProjectModel = new ReturnProjectModel();
        returnProjectModel.setName("项目总数");
        returnProjectModel.setProportion(this.count() + "");

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<ProjectModel> list1 = this.list(sqlQueryParams);
        BigDecimal winningAmount = new BigDecimal(0);
        BigDecimal completeAmount = new BigDecimal(0);
        for (ProjectModel li : list1) {
            winningAmount = winningAmount.add(li.getWinningAmount()); // 批复总投资额
            completeAmount = completeAmount.add(li.getCompleteAmount()); // 完成投资额
        }
        ReturnProjectModel returnProjectModel1 = new ReturnProjectModel();
        returnProjectModel1.setName("项目完成投资");
        returnProjectModel1.setProportion(completeAmount.setScale(0, BigDecimal.ROUND_HALF_UP) + "");
        returnProjectModel1.setProportions(this.company(completeAmount));


        ReturnProjectModel returnProjectModel2 = new ReturnProjectModel();
        returnProjectModel2.setName("总投资额");
        returnProjectModel2.setProportion(winningAmount.setScale(0, BigDecimal.ROUND_HALF_UP) + "");
        returnProjectModel2.setProportions(this.company(winningAmount));

        ReturnProjectModel returnProjectModel3 = new ReturnProjectModel();
        returnProjectModel3.setName("完成投资额");
        if (winningAmount.compareTo(BigDecimal.ZERO) > 0) {
            String s = (completeAmount.divide(winningAmount, 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).toString();
            returnProjectModel3.setProportion(s.substring(0, s.length() - 2));
        } else {
            returnProjectModel3.setProportion("0");
        }

        list.add(returnProjectModel);
        list.add(returnProjectModel1);
        list.add(returnProjectModel2);
        list.add(returnProjectModel3);

        return list;
    }

    // 项目数
    public List<ReturnProjectModel> typeTwo(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            return projectMapper.status();

        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            return projectMapper.statusIndustry(industryCategoryGuid);
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            return projectMapper.statusIndustryAndManage(industryCategoryGuid, managementPowerGuid);
        }else {

            return projectMapper.statusIndustryAndManageAndBuild(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
        }
    }

    // 已完成投资额
    public List<ReturnProjectModel> typeFour(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        List<ReturnProjectModel> list = null;
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            list = projectMapper.complete();
        }else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            list = projectMapper.completeIndustry(industryCategoryGuid);
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            list = projectMapper.completeIndustryAndManage(industryCategoryGuid, managementPowerGuid);
        }else {

            list = projectMapper.completeIndustryAndManageAndBuild(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
        }

        for (ReturnProjectModel li: list) {
            if (li.getAmount() != null && !"".equals(li.getAmount()) ) {

                li.setAmount(new BigDecimal(li.getAmount()).setScale(0, BigDecimal.ROUND_HALF_UP) + "");
                li.setAmounts(this.company(new BigDecimal(li.getAmount())));
            }else{

                li.setAmount("0");
                li.setAmounts("0");
            }
        }

        return list;
    }

    // 公用项目建设情况
    public List<ReturnProjectModel> publicTypeThree(List<ReturnProjectModel> list){

        int n = 0;
        BigDecimal bSum = new BigDecimal(0);
        for (ReturnProjectModel li: list) {
            if (!"".equals(li.getAmount()) && li.getAmount() != null) {
                n = n + 1;
                BigDecimal bigDecimal = new BigDecimal(li.getAmount());
                BigDecimal bigDecimal1 = bigDecimal.divide(new BigDecimal(projectMapper.sum()), 3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
                if (n == list.size()) {

                    String str = new BigDecimal(100).subtract(bSum).toString();
                    li.setProportion(str.substring(0, str.length() - 2));
                }else{

                    bSum = bSum.add(bigDecimal1);
                    String s = bigDecimal1.toString();
                    li.setProportion(s.substring(0, s.length() - 2));
                }
            }else{
                li.setProportion("0");
            }
        }

        return list;
    }

    // 项目建设情况
    public List<ReturnProjectModel> typeThree(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        List<ReturnProjectModel> list = null;
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            list = this.publicTypeThree(projectMapper.winning());
        }else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            list = this.publicTypeThree(projectMapper.winningIndustry(industryCategoryGuid));
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            list = this.publicTypeThree(projectMapper.winningIndustryAndManage(industryCategoryGuid, managementPowerGuid));
        }else {

            list = this.publicTypeThree(projectMapper.winningIndustryAndManageAndBuild(industryCategoryGuid, managementPowerGuid, buildLevelGuid));
        }

        for (ReturnProjectModel li: list) {
            if (li.getAmount() != null && !"".equals(li.getAmount()) ) {

                li.setAmount(new BigDecimal(li.getAmount()).setScale(0, BigDecimal.ROUND_HALF_UP) + "");
                li.setAmounts(this.company(new BigDecimal(li.getAmount())));
            }else{

                li.setAmount("0");
                li.setAmounts("0");
            }
        }

        return list;
    }

    // 项目投资情况
    public List<ReturnProjectModel> typeSeven(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        List<ReturnProjectModel> list = null;
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            list = projectMapper.sumProjectStates();
        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            list = projectMapper.sumProjectStatesIndustry(industryCategoryGuid);
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            list = projectMapper.sumProjectStatesIndustryAndManage(industryCategoryGuid, managementPowerGuid);
        } else {

            list = projectMapper.sumProjectStatesIndustryAndManageAndBuild(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
        }
        for (ReturnProjectModel li: list) {
            if (li.getAmount() != null && !"".equals(li.getAmount())) {

                li.setAmount(new BigDecimal(li.getAmount() ).setScale(0, BigDecimal.ROUND_HALF_UP) + "");
                li.setAmounts(this.company(new BigDecimal(li.getAmount())));
            }else{

                li.setAmount("0");  // 总
                li.setAmounts("0");
            }

            if (li.getAmountOne() != null && !"".equals(li.getAmountOne())) {

                li.setAmountOne(new BigDecimal(li.getAmountOne()).setScale(0, BigDecimal.ROUND_HALF_UP) + "");
                li.setAmountOnes(this.company(new BigDecimal(li.getAmountOne())));
            }else{

                li.setAmountOne("0");  // 完
                li.setAmountOnes("0");
            }
        }

        return list;
    }

    // 投资完成率
    public List<ReturnProjectModel> typeFive(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        List<ReturnProjectModel> list = null;
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            list = projectMapper.sumProject();
        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            list = projectMapper.sumProjectIndustry(industryCategoryGuid);
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            list = projectMapper.sumProjectIndustryAndManage(industryCategoryGuid, managementPowerGuid);
        } else {

            list = projectMapper.sumProjectIndustryAndManageAndBuild(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
        }
        for (ReturnProjectModel li: list) {
            li.setName("投资完成率");
            if (li.getAmount() != null && !"".equals(li.getAmount())) { // 总

                li.setAmount(new BigDecimal(li.getAmount() ).setScale(0, BigDecimal.ROUND_HALF_UP) + "");
                li.setAmounts(this.company(new BigDecimal(li.getAmount())));
            }else{

                li.setAmount("0");
                li.setAmounts("0");
            }

            if (li.getAmountOne() != null && !"".equals(li.getAmountOne())) { // 完

                li.setAmountOne(new BigDecimal(li.getAmountOne()).setScale(0, BigDecimal.ROUND_HALF_UP) + "");
                li.setAmountOnes(this.company(new BigDecimal(li.getAmountOne())));
            }else{

                li.setAmountOne("0");
                li.setAmountOnes("0");
            }

            if (new BigDecimal(li.getAmountOne()).compareTo(BigDecimal.ZERO) > 0) {

                String s = (new BigDecimal(li.getAmount()).divide(new BigDecimal(li.getAmountOne()), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).toString();

                li.setProportion(s.substring(0, s.length() - 2));
            } else {

                li.setProportion("0");
            }
        }

        return list;
    }


    // 开工率
    public List<ReturnProjectModel> typeSix(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        Integer count = 0; // 开工
        Integer count1 = 0; // 全部
        List<ReturnProjectModel> list = new ArrayList<>();
        ReturnProjectModel returnProjectModel = new ReturnProjectModel();
        returnProjectModel.setName("开工率");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {
            count = projectMapper.countStart();
            count1 = projectMapper.count();
            returnProjectModel.setAmount(count + "");
            returnProjectModel.setAmountOne((count1 - count) + "");
            if (count1 > 0) {
                BigDecimal str = (new BigDecimal(count).divide(new BigDecimal(count1), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
                returnProjectModel.setProportion(str.setScale(1, BigDecimal.ROUND_HALF_UP) + "");
            }else {
                returnProjectModel.setProportion("0");
            }
        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {
            count = projectMapper.countStartIndustry(industryCategoryGuid);
            count1 = projectMapper.industryCategoryCount(industryCategoryGuid);
            returnProjectModel.setAmount(count + "");
            returnProjectModel.setAmountOne((count1 - count) + "");
            if (count1 > 0) {
                BigDecimal str = (new BigDecimal(count).divide(new BigDecimal(count1), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
                returnProjectModel.setProportion(str.setScale(1, BigDecimal.ROUND_HALF_UP) + "");
            }else {
                returnProjectModel.setProportion("0");
            }
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {
            count = projectMapper.countStartIndustryAndManage(industryCategoryGuid, managementPowerGuid);
            count1 = projectMapper.industryAndManageCount(industryCategoryGuid, managementPowerGuid);
            returnProjectModel.setAmount(count + "");
            returnProjectModel.setAmountOne((count1 - count) + "");
            if (count1 > 0) {
                BigDecimal str = (new BigDecimal(count).divide(new BigDecimal(count1), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
                returnProjectModel.setProportion(str.setScale(1, BigDecimal.ROUND_HALF_UP) + "");
            }else {
                returnProjectModel.setProportion("0");
            }
        } else {
            count = projectMapper.countStartIndustryAndManageAndBuild(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
            count1 = projectMapper.industryAndManageAndBuildCount(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
            returnProjectModel.setAmount(count + "");
            returnProjectModel.setAmountOne((count1 - count) + "");
            if (count1 > 0) {
                BigDecimal str = (new BigDecimal(count).divide(new BigDecimal(count1), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
                returnProjectModel.setProportion(str.setScale(1, BigDecimal.ROUND_HALF_UP) + "");
            }else{
                returnProjectModel.setProportion("0");
            }
        }

        list.add(returnProjectModel);
        return list;
    }

    // 百大项目
    public List<ReturnProjectModel> hundredOne(String industryCategoryGuid){
        List<ReturnProjectModel> list = new ArrayList<>();

        ReturnProjectModel returnProjectModel = new ReturnProjectModel();
        returnProjectModel.setName("项目总数");
        returnProjectModel.setProportion(projectMapper.hundredCount() + "");

        ReturnProjectModel returnProjectModel4 = new ReturnProjectModel();
        returnProjectModel4.setName("开复工");
        returnProjectModel4.setProportion(projectMapper.hundredCountAndStart() + "");

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("isImportant", "1", "eq"));

        if (industryCategoryGuid != null && !"".equals(industryCategoryGuid)) {

            sqlQueryParams.add(new SqlQueryParam("industryCategoryGuid", industryCategoryGuid, "eq"));
            returnProjectModel.setProportion(projectMapper.hundredIndustryCount(industryCategoryGuid) + "");
            returnProjectModel4.setProportion(projectMapper.hundredIndustryCountAndStart(industryCategoryGuid) + "");
        }
        List<ProjectModel> list1 = this.list(sqlQueryParams);
        BigDecimal winningAmount = new BigDecimal(0);
        BigDecimal completeAmount = new BigDecimal(0);
        for (ProjectModel li : list1) {
            winningAmount = winningAmount.add(li.getWinningAmount()); // 批复总投资额
            completeAmount = completeAmount.add(li.getCompleteAmount()); // 完成投资额
        }
        ReturnProjectModel returnProjectModel1 = new ReturnProjectModel();
        returnProjectModel1.setName("项目完成投资");
        returnProjectModel1.setProportion(completeAmount.setScale(0, BigDecimal.ROUND_HALF_UP) + "");
        returnProjectModel1.setProportions(this.company(completeAmount));

        ReturnProjectModel returnProjectModel2 = new ReturnProjectModel();
        returnProjectModel2.setName("总投资额");
        returnProjectModel2.setProportion(winningAmount.setScale(0, BigDecimal.ROUND_HALF_UP) + "");
        returnProjectModel2.setProportions(this.company(winningAmount));

        ReturnProjectModel returnProjectModel3 = new ReturnProjectModel();
        returnProjectModel3.setName("完成投资额");
        if (winningAmount.compareTo(BigDecimal.ZERO) > 0) {
            String s = (completeAmount.divide(winningAmount, 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).toString();
            returnProjectModel3.setProportion(s.substring(0, s.length() - 2));
        } else {
            returnProjectModel3.setProportion("0");
        }

        ReturnProjectModel returnProjectModel5 = new ReturnProjectModel();
        returnProjectModel5.setName("开复工率");
        BigDecimal str = (new BigDecimal(returnProjectModel4.getProportion()).divide(new BigDecimal(returnProjectModel.getProportion()), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
        returnProjectModel5.setProportion(str.setScale(1, BigDecimal.ROUND_HALF_UP) + "");

        list.add(returnProjectModel);
        list.add(returnProjectModel1);
        list.add(returnProjectModel2);
        list.add(returnProjectModel3);
        list.add(returnProjectModel4);
        list.add(returnProjectModel5);

        return list;
    }

    // 百大铁路
    public List<ReturnProjectModel> hundredTwo(){

        return this.hundredOne("A5338EFD-C3E3-42CB-A07D-F18110555264");
    }

    // 百大公路
    public List<ReturnProjectModel> hundredThree(){

        return this.hundredOne("3C9953CE-11F1-44CB-A105-EA21612A9FC4");
    }

    // 百大机场
    public List<ReturnProjectModel> hundredFour(){

        return this.hundredOne("CC06DE57-98A6-4A35-8E31-C754F36D2F4A");
    }

    // 百大水运
    public List<ReturnProjectModel> hundredFive(){

        return this.hundredOne("2DCCE189-CF0A-4C65-9B38-06F1498C57AA");
    }

    // 将万元转化成亿元
    public String company (BigDecimal money){

        String str = "";
        if (money != null && !"".equals(money) && money.compareTo(BigDecimal.ZERO) != 0) {

            str = (money.divide(new BigDecimal(10000))).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        }else{

            str = "0";
        }

        return str;
    }

    // 项目情况
    public List<ReturnProjectModel> typeOne(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            return this.dateAll(); // 查询全部
        }
        Integer count = 0;

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            count = projectMapper.industryCategoryCount(industryCategoryGuid);
            sqlQueryParams.add(new SqlQueryParam("industryCategoryGuid", industryCategoryGuid, "eq")); // 按照行业查询
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            count = projectMapper.industryAndManageCount(industryCategoryGuid, managementPowerGuid);
            sqlQueryParams.add(new SqlQueryParam("industryCategoryGuid", industryCategoryGuid, "eq")); // 按照行业
            sqlQueryParams.add(new SqlQueryParam("managementPowerGuid", managementPowerGuid, "eq"));  // 和管理查询
        }else {

            count = projectMapper.industryAndManageAndBuildCount(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
            sqlQueryParams.add(new SqlQueryParam("industryCategoryGuid", industryCategoryGuid, "eq")); // 按照行业
            sqlQueryParams.add(new SqlQueryParam("managementPowerGuid", managementPowerGuid, "eq"));  // 和管理查询
            sqlQueryParams.add(new SqlQueryParam("buildLevelGuid", buildLevelGuid, "eq"));  // 和等级
        }

        List<ProjectModel> list1 = this.list(sqlQueryParams);
        List<ReturnProjectModel> list2 = new ArrayList<>();
        ReturnProjectModel returnProjectModel = new ReturnProjectModel();
        returnProjectModel.setName("项目总数");
        returnProjectModel.setProportion(count + "");

        BigDecimal winningAmount = new BigDecimal(0);
        BigDecimal completeAmount = new BigDecimal(0);
        for (ProjectModel li : list1) {
            winningAmount = winningAmount.add(li.getWinningAmount()); // 批复总投资额
            completeAmount = completeAmount.add(li.getCompleteAmount()); // 完成投资额
        }
        ReturnProjectModel returnProjectModel1 = new ReturnProjectModel();
        returnProjectModel1.setName("项目完成投资");
        returnProjectModel1.setProportion(completeAmount.setScale(0, BigDecimal.ROUND_HALF_UP) + "");
        returnProjectModel1.setProportions(this.company(completeAmount));

        ReturnProjectModel returnProjectModel2 = new ReturnProjectModel();
        returnProjectModel2.setName("总投资额");
        returnProjectModel2.setProportion(winningAmount.setScale(0, BigDecimal.ROUND_HALF_UP) + "");
        returnProjectModel2.setProportions(this.company(winningAmount));

        ReturnProjectModel returnProjectModel3 = new ReturnProjectModel();
        returnProjectModel3.setName("完成投资额");
        if (winningAmount.compareTo(BigDecimal.ZERO) > 0) {
            String s = (completeAmount.divide(winningAmount, 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).toString();
            returnProjectModel3.setProportion(s.substring(0, s.length() - 2));
        } else {
            returnProjectModel3.setProportion("0");
        }

        list2.add(returnProjectModel);
        list2.add(returnProjectModel1);
        list2.add(returnProjectModel2);
        list2.add(returnProjectModel3);

        return list2;
    }

    // 条件查询
    public Map<String, List<ReturnProjectModel>> conditionSelect(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        Map<String, List<ReturnProjectModel>> map = new LinkedHashMap<>();
        map.put("项目建设情况", this.typeThree(industryCategoryGuid, managementPowerGuid, buildLevelGuid));
        map.put("项目投资情况", this.typeSeven(industryCategoryGuid, managementPowerGuid, buildLevelGuid));
        map.put("投资完成率", this.typeFive(industryCategoryGuid, managementPowerGuid, buildLevelGuid));
        map.put("开工率", this.typeSix(industryCategoryGuid, managementPowerGuid, buildLevelGuid));

        return map;
    }

    // 百大查询
    public Map<String, List<ReturnProjectModel>> hundredSelect(){
        Map<String, List<ReturnProjectModel>> map = new LinkedHashMap<>();
        map.put("全部", this.hundredOne(""));
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<IndustryCategoryModel> list1 = industryCategoryService.list(sqlQueryParams);
        for (IndustryCategoryModel li: list1) {

            map.put(li.getName(), this.hundredOne(li.getGuid()));
        }

        return map;
    }
}
