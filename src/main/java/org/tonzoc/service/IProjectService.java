package org.tonzoc.service;

import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.ReturnProjectModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IProjectService extends IBaseService<ProjectModel> {

    // 公用总投资额
    List<ReturnProjectModel> publicTypeThree(List<ReturnProjectModel> list, String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant);

    // 总投资额
    List<ReturnProjectModel> typeThree(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant);

    // 数量
    List<ReturnProjectModel> typeFour(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant);

    // 投资完成率
    List<ReturnProjectModel> typeFive(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant);

    // 开工率
    List<ReturnProjectModel> typeSix(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant);

    // 项目投资情况
    List<ReturnProjectModel> typeSeven(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant);

    // 百大项目
    List<ReturnProjectModel> hundredOne(String projectStateGuid);

    // 将万元转化成亿元
    String company (BigDecimal money);

    // 全部项目的数据
    List<ReturnProjectModel> dateAll(Integer isImportant);

    // 条件查询
    Map<String ,List<ReturnProjectModel>> conditionSelect(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant);

    // 百大查询
    Map<String, List<ReturnProjectModel>> hundredSelect();
}
