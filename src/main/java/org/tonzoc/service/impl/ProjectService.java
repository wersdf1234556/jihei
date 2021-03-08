package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.ProjectMapper;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.service.IProjectService;
import org.tonzoc.support.param.SqlQueryParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("projectService")
public class ProjectService extends BaseService<ProjectModel> implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    // 数量
    public Integer count() {

        return projectMapper.count();
    }

    // 全部项目的数据
    public List<ReturnModel> dateAll() {
        List<ReturnModel> list = new ArrayList<>();
        ReturnModel returnModel = new ReturnModel();
        returnModel.setName("项目总数");
        returnModel.setProportion(this.count() + "个");

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<ProjectModel> list1 = this.list(sqlQueryParams);
        BigDecimal winningAmount = new BigDecimal(0);
        BigDecimal completeAmount = new BigDecimal(0);
        for (ProjectModel li : list1) {
            winningAmount = winningAmount.add(li.getWinningAmount()); // 批复总投资额
            completeAmount = completeAmount.add(li.getCompleteAmount()); // 完成投资额
        }
        ReturnModel returnModel1 = new ReturnModel();
        returnModel1.setName("项目完成投资");
        returnModel1.setProportion(completeAmount + "万元");

        ReturnModel returnModel2 = new ReturnModel();
        returnModel2.setName("总投资额");
        returnModel2.setProportion(winningAmount + "万元");

        ReturnModel returnModel3 = new ReturnModel();
        returnModel3.setName("完成投资额");
        if (winningAmount.compareTo(BigDecimal.ZERO) > 0) {
            String s = (completeAmount.divide(winningAmount, 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).toString();
            returnModel3.setProportion(s.substring(0, s.length() - 2) + "%");
        } else {
            returnModel3.setProportion("0%");
        }

        list.add(returnModel);
        list.add(returnModel1);
        list.add(returnModel2);
        list.add(returnModel3);

        return list;
    }

    // 项目情况
    public List<ReturnModel> typeOne(String industryCategoryGuid, String managementPowerGuid){
        if ((industryCategoryGuid == null && managementPowerGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid))) {

            return this.dateAll(); // 查询全部
        }
        Integer count = 0;

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        if (managementPowerGuid == null || "".equals(managementPowerGuid)) {

            count = projectMapper.industryCategoryCount(industryCategoryGuid);
            sqlQueryParams.add(new SqlQueryParam("industryCategoryGuid", industryCategoryGuid, "eq")); // 按照行业查询
        }else{

            count = projectMapper.industryAndManageCount(industryCategoryGuid, managementPowerGuid);
            sqlQueryParams.add(new SqlQueryParam("industryCategoryGuid", industryCategoryGuid, "eq")); // 按照行业和管理查询
            sqlQueryParams.add(new SqlQueryParam("managementPowerGuid", managementPowerGuid, "eq"));
        }

        List<ProjectModel> list1 = this.list(sqlQueryParams);
        List<ReturnModel> list2 = new ArrayList<>();
        ReturnModel returnModel = new ReturnModel();
        returnModel.setName("项目总数");
        returnModel.setProportion(count + "个");

        BigDecimal winningAmount = new BigDecimal(0);
        BigDecimal completeAmount = new BigDecimal(0);
        for (ProjectModel li : list1) {
            winningAmount = winningAmount.add(li.getWinningAmount()); // 批复总投资额
            completeAmount = completeAmount.add(li.getCompleteAmount()); // 完成投资额
        }
        ReturnModel returnModel1 = new ReturnModel();
        returnModel1.setName("项目完成投资");
        returnModel1.setProportion(completeAmount + "万元");

        ReturnModel returnModel2 = new ReturnModel();
        returnModel2.setName("总投资额");
        returnModel2.setProportion(winningAmount + "万元");

        ReturnModel returnModel3 = new ReturnModel();
        returnModel3.setName("完成投资额");
        if (winningAmount.compareTo(BigDecimal.ZERO) > 0) {
            String s = (completeAmount.divide(winningAmount, 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).toString();
            returnModel3.setProportion(s.substring(0, s.length() - 2) + "%");
        } else {
            returnModel3.setProportion("0%");
        }

        list2.add(returnModel);
        list2.add(returnModel1);
        list2.add(returnModel2);
        list2.add(returnModel3);

        return list2;
    }

    // 项目数
    public List<ReturnModel> typeTwo(String industryCategoryGuid, String managementPowerGuid){
        if ((industryCategoryGuid == null && managementPowerGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid))) {

            return projectMapper.status();

        }
        if (managementPowerGuid == null || "".equals(managementPowerGuid)) {

            return projectMapper.statusIndustry(industryCategoryGuid);
        }

        return projectMapper.statusIndustryAndManage(industryCategoryGuid, managementPowerGuid);
    }

    // 总投资额
    public List<ReturnModel> typeThree(String industryCategoryGuid, String managementPowerGuid){

        if ((industryCategoryGuid == null && managementPowerGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid))) {

            List<ReturnModel> list = projectMapper.winning();
            int n = 0;
            BigDecimal bSum = new BigDecimal(0);
            for (ReturnModel returnModel: list) {
                if (returnModel.getNumber() != null) {
                    n = n++;
                    BigDecimal bigDecimal = new BigDecimal(returnModel.getNumber());
                    BigDecimal bigDecimal1 = bigDecimal.divide(new BigDecimal(projectMapper.sum()), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
                    bSum = bSum.add(bigDecimal1);
                    String s = bigDecimal1.toString();
                    if (n == list.size()) {
                        returnModel.setProportion(new BigDecimal(1).subtract(bSum) + "%");
                    }else{
                        returnModel.setProportion(s.substring(0, s.length() - 2) + "%");
                    }
                }else{
                    returnModel.setProportion("0%");
                }
            }

            return list;
        }
        if (managementPowerGuid == null || "".equals(managementPowerGuid)) {

            List<ReturnModel> list = projectMapper.winningIndustry(industryCategoryGuid);
            int n = 0;
            BigDecimal bSum = new BigDecimal(0);
            for (ReturnModel returnModel: list) {
                if (returnModel.getNumber() != null) {
                    n = n++;
                    BigDecimal bigDecimal = new BigDecimal(returnModel.getNumber());
                    BigDecimal bigDecimal1 = bigDecimal.divide(new BigDecimal(projectMapper.sumIndustry(industryCategoryGuid)), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
                    bSum = bSum.add(bigDecimal1);
                    String s = bigDecimal1.toString();
                    if (n == list.size()) {
                        returnModel.setProportion(new BigDecimal(1).subtract(bSum) + "%");
                    }else{
                        returnModel.setProportion(s.substring(0, s.length() - 2) + "%");
                    }
                }else{
                    returnModel.setProportion("0%");
                }
            }

            return list;
        }

        List<ReturnModel> list = projectMapper.winningIndustryAndManage(industryCategoryGuid, managementPowerGuid);
        int n = 0;
        BigDecimal bSum = new BigDecimal(0);
        for (ReturnModel returnModel: list) {
            if (returnModel.getNumber() != null) {
                n = n++;
                BigDecimal bigDecimal = new BigDecimal(returnModel.getNumber());
                BigDecimal bigDecimal1 = bigDecimal.divide(new BigDecimal(projectMapper.sumIndustryAndManage(industryCategoryGuid, managementPowerGuid)), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
                bSum = bSum.add(bigDecimal1);
                String s = bigDecimal1.toString();
                if (n == list.size()) {
                    returnModel.setProportion(new BigDecimal(1).subtract(bSum) + "%");
                }else{
                    returnModel.setProportion(s.substring(0, s.length() - 2) + "%");
                }
            }else{
                returnModel.setProportion("0%");
            }
        }

        return list;
    }

    // 已完成投资额
    public List<ReturnModel> typeFour(String industryCategoryGuid, String managementPowerGuid){

        if ((industryCategoryGuid == null && managementPowerGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid))) {

            return projectMapper.complete();

        }
        if (managementPowerGuid == null || "".equals(managementPowerGuid)) {

            return projectMapper.completeIndustry(industryCategoryGuid);
        }

        return projectMapper.completeIndustryAndManage(industryCategoryGuid, managementPowerGuid);
    }

    // 投资完成率
    public List<ReturnModel> typeFive(String industryCategoryGuid, String managementPowerGuid){

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<ReturnModel> list1 = new ArrayList<>();

        if ((industryCategoryGuid == null && managementPowerGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid))) {
        }

        if ((managementPowerGuid == null || "".equals(managementPowerGuid)) && (industryCategoryGuid != null && !"".equals(industryCategoryGuid))) {
            sqlQueryParams.add(new SqlQueryParam("industryCategoryGuid", industryCategoryGuid, "eq")); // 按照行业查询
        }

        if (industryCategoryGuid != null && !"".equals(industryCategoryGuid) && managementPowerGuid != null && !"".equals(managementPowerGuid)) {
            sqlQueryParams.add(new SqlQueryParam("industryCategoryGuid", industryCategoryGuid, "eq")); // 按照行业和管理查询
            sqlQueryParams.add(new SqlQueryParam("managementPowerGuid", managementPowerGuid, "eq"));
        }

        List<ProjectModel> list = this.list(sqlQueryParams);
        ReturnModel returnModel = new ReturnModel();
        BigDecimal winningAmount = new BigDecimal(0); // 批复总投资额
        BigDecimal completeAmount = new BigDecimal(0); // 完成投资额

        for (ProjectModel li: list) {
            winningAmount = winningAmount.add(li.getWinningAmount());
            completeAmount = completeAmount.add(li.getCompleteAmount());
        }
        System.out.println("winningAmount" + winningAmount);
        if (winningAmount.compareTo(BigDecimal.ZERO) > 0) {
            String s = (completeAmount.divide(winningAmount, 4, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).toString();
            returnModel.setName("投资完成率");
            returnModel.setProportion(s.substring(0, s.length() - 2) + "%");

        } else {
            returnModel.setName("投资完成率");
            returnModel.setProportion("0%");
        }
        list1.add(returnModel);

        return list1;
    }


    // 开工率
    public List<ReturnModel> typeSix(String industryCategoryGuid, String managementPowerGuid){

        return null;
    }

    // 项目投资情况
    public List<ReturnModel> typeSeven(String industryCategoryGuid, String managementPowerGuid){
        if ((industryCategoryGuid == null && managementPowerGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid))) {

            return projectMapper.sumProjectStates();

        }
        if (managementPowerGuid == null || "".equals(managementPowerGuid)) {

            return projectMapper.sumProjectStatesIndustry(industryCategoryGuid);
        }

        return projectMapper.sumProjectStatesIndustryAndManage(industryCategoryGuid, managementPowerGuid);
    }

    // 条件查询
    public List<ReturnModel> conditionSelect(Integer typeId, String industryCategoryGuid, String managementPowerGuid){
        if (typeId == 1) {

           return this.typeOne(industryCategoryGuid, managementPowerGuid);
        }
        if (typeId == 2) {

           return this.typeTwo(industryCategoryGuid, managementPowerGuid);
        }
        if (typeId == 3) {

            return this.typeThree(industryCategoryGuid, managementPowerGuid);
        }
        if (typeId == 4) {

            return this.typeFour(industryCategoryGuid, managementPowerGuid);
        }
        if (typeId == 5) {

            return this.typeFive(industryCategoryGuid, managementPowerGuid);
        }
        if (typeId == 6) {
            return this.typeSix(industryCategoryGuid, managementPowerGuid);
        }
        if (typeId == 7) {
            return this.typeSeven(industryCategoryGuid, managementPowerGuid);
        }

        return null;
    }

}
