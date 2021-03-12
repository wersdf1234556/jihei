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

    // 公用项目建设情况
    public List<ReturnProjectModel> publicTypeThree(List<ReturnProjectModel> list, String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        int n = 0;
        BigDecimal bSum = new BigDecimal(0);
        Integer sum = projectMapper.sum(industryCategoryGuid, managementPowerGuid, buildLevelGuid); // 总和

        for (ReturnProjectModel li: list) {
            if (sum > 0) {
                n = n + 1;
                BigDecimal bigDecimal = new BigDecimal(li.getAmount());
                BigDecimal bigDecimal1 = (bigDecimal.divide(new BigDecimal(sum), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
                if (n == list.size()) {

                    if (bSum.compareTo(new BigDecimal(0 )) == 0) {
                        li.setProportion("0");
                    }else{
                        String str = new BigDecimal(100).subtract(bSum).toString();
                        li.setProportion(str.substring(0, str.length() - 2));
                    }
                }else{
                    bSum = bSum.add(bigDecimal1);
                    String s = bigDecimal1.toString();
                    li.setProportion(s.substring(0, s.length() - 2));
                }
            }else {

                li.setProportion("0");
            }

        }

        return list;
    }

    // 项目建设情况
    public List<ReturnProjectModel> typeThree(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        List<ReturnProjectModel> list = projectMapper.sumWinning(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
        for (ReturnProjectModel li: list) {
            if (li.getAmount() != null && !"".equals(li.getAmount()) ) {

                li.setAmount(new BigDecimal(li.getAmount()).setScale(0, BigDecimal.ROUND_HALF_UP) + "");
                li.setAmounts(this.company(new BigDecimal(li.getAmount())));
            }else{

                li.setAmount("0");
                li.setAmounts("0");
            }
        }

        return this.publicTypeThree(list, industryCategoryGuid, managementPowerGuid, buildLevelGuid);
    }

    // 项目投资情况
    public List<ReturnProjectModel> typeSeven(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        List<ReturnProjectModel> list = projectMapper.sumProjectStates(industryCategoryGuid, managementPowerGuid, buildLevelGuid);

        for (ReturnProjectModel li: list) {

            li.setName("项目投资情况");

            li.setAmount(new BigDecimal(li.getAmount() ).setScale(0, BigDecimal.ROUND_HALF_UP) + "");
            li.setAmounts(this.company(new BigDecimal(li.getAmount())));

            li.setAmountOne(new BigDecimal(li.getAmountOne()).setScale(0, BigDecimal.ROUND_HALF_UP) + "");
            li.setAmountOnes(this.company(new BigDecimal(li.getAmountOne())));
        }

        return list;
    }

    // 投资完成率
    public List<ReturnProjectModel> typeFive(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        List<ReturnProjectModel> list = projectMapper.sumProject(industryCategoryGuid, managementPowerGuid, buildLevelGuid);

        for (ReturnProjectModel li: list) {
            li.setName("投资完成率");

            li.setAmount(new BigDecimal(li.getAmount() ).setScale(0, BigDecimal.ROUND_HALF_UP) + ""); //总
            li.setAmounts(this.company(new BigDecimal(li.getAmount())));

            li.setAmountOne(new BigDecimal(li.getAmountOne()).setScale(0, BigDecimal.ROUND_HALF_UP) + ""); // 完
            li.setAmountOnes(this.company(new BigDecimal(li.getAmountOne())));

            if (new BigDecimal(li.getAmount()).compareTo(new BigDecimal(0)) == 1) {
                String s = (new BigDecimal(li.getAmountOne()).divide(new BigDecimal(li.getAmount()), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).toString();

                li.setProportion(s.substring(0, s.length() - 2));
            }else {

                li.setProportion("0");
            }
        }

        return list;
    }


    // 开工率
    public List<ReturnProjectModel> typeSix(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        List<ReturnProjectModel> list = new ArrayList<>();
        Integer count = projectMapper.countStart(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
        Integer count1 = projectMapper.count(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
        ReturnProjectModel returnProjectModel = new ReturnProjectModel();
        returnProjectModel.setName("开工率");
        returnProjectModel.setAmount(count + "");
        returnProjectModel.setAmountOne((count1 - count) + "");
        if (count1 > 0) {
            BigDecimal str = (new BigDecimal(count).divide(new BigDecimal(count1), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
            returnProjectModel.setProportion(str.setScale(1, BigDecimal.ROUND_HALF_UP) + "");
        }else {

            returnProjectModel.setProportion("0");
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
        if (new BigDecimal(returnProjectModel.getProportion()).compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal str = (new BigDecimal(returnProjectModel4.getProportion()).divide(new BigDecimal(returnProjectModel.getProportion()), 3, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
            returnProjectModel5.setProportion(str.setScale(1, BigDecimal.ROUND_HALF_UP) + "");
        } else {
            returnProjectModel5.setProportions("0");
        }


        list.add(returnProjectModel);
        list.add(returnProjectModel1);
        list.add(returnProjectModel2);
        list.add(returnProjectModel3);
        list.add(returnProjectModel4);
        list.add(returnProjectModel5);

        return list;
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

    // 全部项目的数据
    public List<ReturnProjectModel> dateAll() {
        List<ReturnProjectModel> list = new ArrayList<>();
        ReturnProjectModel returnProjectModel = new ReturnProjectModel();
        returnProjectModel.setName("项目总数");
        returnProjectModel.setProportion(projectMapper.count("", "", "") + "");

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
