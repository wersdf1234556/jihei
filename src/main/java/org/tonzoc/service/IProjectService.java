package org.tonzoc.service;

import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.ReturnModel;

import java.util.List;

public interface IProjectService extends IBaseService<ProjectModel> {

    // 数量
    Integer count();

    // 全部项目的数据
    List<ReturnModel> dateAll();

    // 项目情况
    List<ReturnModel> typeOne(String industryCategoryGuid, String managementPowerGuid);

    // 项目数
    List<ReturnModel> typeTwo(String industryCategoryGuid, String managementPowerGuid);

    // 总投资额
    List<ReturnModel> typeThree(String industryCategoryGuid, String managementPowerGuid);

    // 已完成投资额
    List<ReturnModel> typeFour(String industryCategoryGuid, String managementPowerGuid);

    // 投资完成率
    List<ReturnModel> typeFive(String industryCategoryGuid, String managementPowerGuid);

    // 开工率
    List<ReturnModel> typeSix(String industryCategoryGuid, String managementPowerGuid);

    // 项目投资情况
    List<ReturnModel> typeSeven(String industryCategoryGuid, String managementPowerGuid);

    // 条件查询
    List<ReturnModel> conditionSelect(Integer typeId, String industryCategoryGuid, String managementPowerGuid);
}
