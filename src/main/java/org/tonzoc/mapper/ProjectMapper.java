package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.support.ReturnProjectModel;
import org.tonzoc.provider.ProjectProvider;

import java.util.List;

public interface ProjectMapper extends BaseMapper<ProjectModel> {

    // 百大总数
    @Select("select count(guid) from projects where isImportant = 1 and isImportantCount = 0 ")
    Integer hundredCount();

    // 百大（铁路、公路、机场、水运）总数
    @Select("select count(guid) from projects where isImportant = 1 and isImportantCount = 0 and industryCategoryGuid = #{industryCategoryGuid}")
    Integer hundredIndustryCount(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    // 百大开工数
    @Select("select count(guid) from projects where isImportant = 1 and isImportantCount = 0 and isStart = 1")
    Integer hundredCountAndStart();

    // 百大（铁路、公路、机场、水运） 开工数
    @Select("select count(guid) from projects where isImportant = 1 and isImportantCount = 0 and isStart = 1 and industryCategoryGuid = #{industryCategoryGuid}")
    Integer hundredIndustryCountAndStart(@Param(value = "industryCategoryGuid") String industryCategoryGuid);

    // 项目数量
    @SelectProvider(type = ProjectProvider.class, method = "countTotal")
    Integer countTotal (@Param("industryCategoryGuid") String industryCategoryGuid,
                        @Param("managementPowerGuid") String managementPowerGuid,
                        @Param("buildLevelGuid") String buildLevelGuid,
                        @Param("isImportant") Integer isImportant);

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

    // 项目数量
    @SelectProvider(type = ProjectProvider.class, method = "countRecover")
    Integer countRecover (@Param("industryCategoryGuid") String industryCategoryGuid,
                   @Param("managementPowerGuid") String managementPowerGuid,
                   @Param("buildLevelGuid") String buildLevelGuid,
                   @Param("isImportant") Integer isImportant);

    // 续建项目数量
    @SelectProvider(type = ProjectProvider.class, method = "countStarted")
    Integer countStarted(@Param("industryCategoryGuid") String industryCategoryGuid,
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
