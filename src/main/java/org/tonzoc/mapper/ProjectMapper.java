package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.ReturnModel;

import java.math.BigDecimal;
import java.util.List;


public interface ProjectMapper extends BaseMapper<ProjectModel> {

    @Select("select count(guid) from projects")
    Integer count();

    @Select("select * from projects")
    List<ProjectModel> list();

    @Select("select * from projects where industryCategoryGuid = #{industryCategoryGuid}")
    List<ProjectModel> getIndustryCategoryGuid(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select count(guid) from projects where industryCategoryGuid = #{industryCategoryGuid}")
    Integer industryCategoryCount(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}")
    List<ProjectModel> getIndustryAndManage(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                            @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select count(guid) from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}")
    Integer industryAndManageCount(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                   @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select projectStates.name name, count(projects.guid) number from projectStates " +
            "LEFT JOIN projects on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnModel> status();

    @Select("select projectStates.name name, count(projects.guid) number from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnModel> statusIndustry(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select projectStates.name name, count(projects.guid) number from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnModel> statusIndustryAndManage(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                              @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select projectStates.name name, sum(projects.winningAmount) number from projectStates " +
            "LEFT JOIN projects on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnModel> winning();

    @Select("select projectStates.name name, sum(projects.winningAmount) number from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnModel> winningIndustry(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select projectStates.name name, sum(projects.winningAmount) number from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnModel> winningIndustryAndManage(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                               @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select projectStates.name name, sum(projects.completeAmount) number from projectStates " +
            "LEFT JOIN projects on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnModel> complete();

    @Select("select projectStates.name name, sum(projects.completeAmount) number from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnModel> completeIndustry(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    @Select("select projectStates.name name, sum(projects.completeAmount) number from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}) projects " +
            "on projects.projectStateGuid = projectStates.guid GROUP BY projectStates.name")
    List<ReturnModel> completeIndustryAndManage(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                                @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select sum(projects.winningAmount) from projects")
    Integer sum();

    @Select("select sum(projects.winningAmount) from projects where industryCategoryGuid = #{industryCategoryGuid}")
    Integer sumIndustry(@Param(value = "industryCategoryGuid")String industryCategoryGuid);

    @Select("select sum(projects.winningAmount) from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}")
    Integer sumIndustryAndManage(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                 @Param(value = "managementPowerGuid") String managementPowerGuid);

    @Select("select projectStates.name, sum(projects.winningAmount) number, sum(projects.completeAmount) proportion from projectStates " +
            "LEFT JOIN projects on projectStates.guid = projects.projectStateGuid GROUP BY projectStates.name")
    List<ReturnModel> sumProjectStates();

    @Select("select projectStates.name, sum(projects.winningAmount) number, sum(projects.completeAmount) proportion from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid}) projects on projectStates.guid = projects.projectStateGuid GROUP BY projectStates.name")
    List<ReturnModel> sumProjectStatesIndustry(@Param("industryCategoryGuid") String industryCategoryGuid);

    @Select("select projectStates.name, sum(projects.winningAmount) number, sum(projects.completeAmount) proportion from projectStates " +
            "LEFT JOIN (select * from projects where industryCategoryGuid = #{industryCategoryGuid} and managementPowerGuid = #{managementPowerGuid}) projects " +
            "on projectStates.guid = projects.projectStateGuid GROUP BY projectStates.name")
    List<ReturnModel> sumProjectStatesIndustryAndManage(@Param("industryCategoryGuid") String industryCategoryGuid,
                                                        @Param("managementPowerGuid") String managementPowerGuid);
}
