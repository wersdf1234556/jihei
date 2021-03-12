package org.tonzoc.service;

import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.ReturnProjectModel;

import java.math.BigDecimal;
import java.util.List;

public interface IProjectService extends IBaseService<ProjectModel> {

    // 数量
    Integer count();

    // 全部项目的数据
    List<ReturnProjectModel> dateAll();

    // 项目情况
    List<ReturnProjectModel> typeOne(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid);

    // 项目数
    List<ReturnProjectModel> typeTwo(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid);

    // 公用总投资额
    List<ReturnProjectModel> publicTypeThree(List<ReturnProjectModel> list);

    // 总投资额
    List<ReturnProjectModel> typeThree(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid);

    // 已完成投资额
    List<ReturnProjectModel> typeFour(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid);

    // 投资完成率
    List<ReturnProjectModel> typeFive(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid);

    // 开工率
    List<ReturnProjectModel> typeSix(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid);

    // 项目投资情况
    List<ReturnProjectModel> typeSeven(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid);

    // 条件查询
    List<ReturnProjectModel> conditionSelect(Integer typeId, String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid);

    // 百大项目
    List<ReturnProjectModel> hundredOne(String projectStateGuid);

    // 百大铁路
    List<ReturnProjectModel> hundredTwo();

    // 百大公路
    List<ReturnProjectModel> hundredThree();

    // 百大机场
    List<ReturnProjectModel> hundredFour();

    // 百大水运
    List<ReturnProjectModel> hundredFive();

    // 百大查询
    List<ReturnProjectModel> hundredSelect(Integer typeId);

    // 将万元转化成亿元
    String company (BigDecimal money);
}
