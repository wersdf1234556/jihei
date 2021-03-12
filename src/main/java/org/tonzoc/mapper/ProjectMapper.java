package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.support.ReturnProjectModel;

import java.util.List;

public interface ProjectMapper extends BaseMapper<ProjectModel> {

    @Select("select count(guid) from projects where isImportant = 1")
    Integer hundredCount();

    @Select("select count(guid) from projects where isImportant = 1 and industryCategoryGuid = #{industryCategoryGuid}")
    Integer hundredIndustryCount(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select count(guid) from projects where isImportant = 1 and isStart = 1")
    Integer hundredCountAndStart();

    @Select("select count(guid) from projects where isImportant = 1 and isStart = 1 and industryCategoryGuid = #{industryCategoryGuid}")
    Integer hundredIndustryCountAndStart(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select * from projects")
    List<ProjectModel> list();

    @Select("select count(guid) from projects")
    Integer count();

    @Select("select count(guid) from projects where industryCategoryGuid = #{industryCategoryGuid}")
    Integer industryCategoryCount(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select count(guid) from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}")
    Integer industryAndManageCount(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                   @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select count(guid) from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid} and buildLevelGuid = #{buildLevelGuid}")
    Integer industryAndManageAndBuildCount(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                           @Param(value = "managementPowerGuid") String managementPowerGuid,
                                           @Param(value = "buildLevelGuid") String buildLevelGuid);

    @Select("select projectStates.name name, count(projects.guid) proportion from projectStates " +
            "LEFT JOIN projects on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> status();

    @Select("select projectStates.name name, count(projects.guid) proportion from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> statusIndustry(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select projectStates.name name, count(projects.guid) proportion from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> statusIndustryAndManage(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                                     @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select projectStates.name name, count(projects.guid) proportion from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid} and buildLevelGuid = #{buildLevelGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> statusIndustryAndManageAndBuild(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                                             @Param(value = "managementPowerGuid") String managementPowerGuid,
                                                             @Param(value = "buildLevelGuid") String buildLevelGuid);

    @Select("select projectStates.name name, sum(projects.winningAmount) amount from projectStates " +
            "LEFT JOIN projects on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> winning();

    @Select("select projectStates.name name, sum(projects.winningAmount) amount from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> winningIndustry(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select projectStates.name name, sum(projects.winningAmount) amount from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> winningIndustryAndManage(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                                      @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select projectStates.name name, sum(projects.winningAmount) amount from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid} and buildLevelGuid = #{buildLevelGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> winningIndustryAndManageAndBuild(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                                              @Param(value = "managementPowerGuid") String managementPowerGuid,
                                                              @Param(value = "buildLevelGuid") String buildLevelGuid);

    @Select("select projectStates.name name, sum(projects.completeAmount) amount from projectStates " +
            "LEFT JOIN projects on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> complete();

    @Select("select projectStates.name name, sum(projects.completeAmount) amount from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> completeIndustry(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select projectStates.name name, sum(projects.completeAmount) amount from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnProjectModel> completeIndustryAndManage(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                                       @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select projectStates.name name, sum(projects.completeAmount) amount from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid} and buildLevelGuid = #{buildLevelGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnProjectModel> completeIndustryAndManageAndBuild(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                                               @Param(value = "managementPowerGuid") String managementPowerGuid,
                                                               @Param(value = "buildLevelGuid") String buildLevelGuid);

    @Select("select sum(projects.winningAmount) from projects")
    Integer sum();

    @Select("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projectStates " +
            "LEFT JOIN projects on projectStates.guid = projects.projectStateGuid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> sumProjectStates();

    @Select("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid}) projects on projectStates.guid = projects.projectStateGuid " +
            "GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> sumProjectStatesIndustry(@Param("industryCategoryGuid") String industryCategoryGuid);

    @Select("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}) projects " +
            "on projectStates.guid = projects.projectStateGuid GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> sumProjectStatesIndustryAndManage(@Param("industryCategoryGuid") String industryCategoryGuid,
                                                               @Param("managementPowerGuid") String managementPowerGuid);

    @Select("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid} and buildLevelGuid = #{buildLevelGuid}) projects " +
            "on projectStates.guid = projects.projectStateGuid GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId")
    List<ReturnProjectModel> sumProjectStatesIndustryAndManageAndBuild(@Param("industryCategoryGuid") String industryCategoryGuid,
                                                                       @Param("managementPowerGuid") String managementPowerGuid,
                                                                       @Param("buildLevelGuid") String buildLevelGuid);

    @Select("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projects")
    List<ReturnProjectModel> sumProject();

    @Select("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projects " +
            "where industryCategoryGuid = #{industryCategoryGuid}")
    List<ReturnProjectModel> sumProjectIndustry(@Param("industryCategoryGuid") String industryCategoryGuid);

    @Select("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projects " +
            "where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}")
    List<ReturnProjectModel> sumProjectIndustryAndManage(@Param("industryCategoryGuid") String industryCategoryGuid,
                                                         @Param("managementPowerGuid") String managementPowerGuid);

    @Select("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projects " +
            "where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid} and buildLevelGuid = #{buildLevelGuid}")
    List<ReturnProjectModel> sumProjectIndustryAndManageAndBuild(@Param("industryCategoryGuid") String industryCategoryGuid,
                                                                 @Param("managementPowerGuid") String managementPowerGuid,
                                                                 @Param("buildLevelGuid") String buildLevelGuid);

    @Select("select count(guid) from projects where isStart = 1")
    Integer countStart();

    @Select("select count(guid) from projects where isStart = 1 and industryCategoryGuid = #{industryCategoryGuid}")
    Integer countStartIndustry(@Param("industryCategoryGuid") String industryCategoryGuid);

    @Select("select count(guid) from projects where isStart = 1 and industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}")
    Integer countStartIndustryAndManage(@Param("industryCategoryGuid") String industryCategoryGuid,
                                        @Param("managementPowerGuid") String managementPowerGuid);

    @Select("select count(guid) from projects where isStart = 1 and industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid} and buildLevelGuid = #{buildLevelGuid}")
    Integer countStartIndustryAndManageAndBuild(@Param("industryCategoryGuid") String industryCategoryGuid,
                                                @Param("managementPowerGuid") String managementPowerGuid,
                                                @Param("buildLevelGuid") String buildLevelGuid);
}
