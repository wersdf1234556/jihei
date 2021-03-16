package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.support.ReturnProjectModel;
import org.tonzoc.provider.ProjectProvider;

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

    // 项目数量
    @SelectProvider(type = ProjectProvider.class, method = "count")
    Integer count (@Param("industryCategoryGuid") String industryCategoryGuid,
                   @Param("managementPowerGuid") String managementPowerGuid,
                   @Param("buildLevelGuid") String buildLevelGuid,
                   @Param("isImportant") Integer isImportant);

    // 项目开工数量
    @SelectProvider(type = ProjectProvider.class, method = "countStart")
    Integer countStart(@Param("industryCategoryGuid") String industryCategoryGuid,
                       @Param("managementPowerGuid") String managementPowerGuid,
                       @Param("buildLevelGuid") String buildLevelGuid,
                       @Param("isImportant") Integer isImportant);

    // 总额的和
    @SelectProvider(type = ProjectProvider.class, method = "sumWinning")
    List<ReturnProjectModel> sumWinning(@Param("industryCategoryGuid") String industryCategoryGuid,
                                        @Param("managementPowerGuid") String managementPowerGuid,
                                        @Param("buildLevelGuid") String buildLevelGuid,
                                        @Param("isImportant") Integer isImportant);

    // 项目总额的和
    @SelectProvider(type = ProjectProvider.class, method = "sum")
    Integer sum(@Param("industryCategoryGuid") String industryCategoryGuid,
                @Param("managementPowerGuid") String managementPowerGuid,
                @Param("buildLevelGuid") String buildLevelGuid,
                @Param("isImportant") Integer isImportant);

    // 按照项目求和
    @SelectProvider(type = ProjectProvider.class, method = "sumProject")
    List<ReturnProjectModel> sumProject(@Param("industryCategoryGuid") String industryCategoryGuid,
                                        @Param("managementPowerGuid") String managementPowerGuid,
                                        @Param("buildLevelGuid") String buildLevelGuid,
                                        @Param("isImportant") Integer isImportant);

    // 按照状态求和
    @SelectProvider(type = ProjectProvider.class, method = "sumProjectStates")
    List<ReturnProjectModel> sumProjectStates(@Param("industryCategoryGuid") String industryCategoryGuid,
                                              @Param("managementPowerGuid") String managementPowerGuid,
                                              @Param("buildLevelGuid") String buildLevelGuid,
                                              @Param("isImportant") Integer isImportant);

    // 按照状态数量
    @SelectProvider(type = ProjectProvider.class, method = "countStatus")
    List<ReturnProjectModel> countStatus(@Param("industryCategoryGuid") String industryCategoryGuid,
                                         @Param("managementPowerGuid") String managementPowerGuid,
                                         @Param("buildLevelGuid") String buildLevelGuid,
                                         @Param("isImportant") Integer isImportant);
}
