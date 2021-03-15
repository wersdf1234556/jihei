package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

public class ProjectProvider {

    // 项目数量
    public String count(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                        @Param(value = "managementPowerGuid") String managementPowerGuid,
                        @Param(value = "buildLevelGuid") String buildLevelGuid) {

        StringBuilder stringBuilder = new StringBuilder("select count(guid) from projects");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        }else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" where industryCategoryGuid = '" + industryCategoryGuid + "'");
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        }else {

            stringBuilder.append(" where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 项目开工数量
    public String countStart(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                             @Param(value = "managementPowerGuid") String managementPowerGuid,
                             @Param(value = "buildLevelGuid") String buildLevelGuid) {

        StringBuilder stringBuilder = new StringBuilder("select count(guid) from projects where isStart = 1");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        }else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "'");
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        }else {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 按照状态计算总额的和
    public String sumWinning(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                             @Param(value = "managementPowerGuid") String managementPowerGuid,
                             @Param(value = "buildLevelGuid") String buildLevelGuid) {

        StringBuilder stringBuilder = new StringBuilder("select projectStates.name name, ISNULL(sum(projects.winningAmount), 0) amount from projectStates");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" LEFT JOIN projects on projects.projectStateGuid = projectStates.guid ");
        }else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
        }else {

            stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
        }

        stringBuilder.append(" GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId");

        return stringBuilder.toString();
    }

    // 按照项目计算总额的和
    public String sum(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                      @Param(value = "managementPowerGuid") String managementPowerGuid,
                      @Param(value = "buildLevelGuid") String buildLevelGuid) {

        StringBuilder stringBuilder = new StringBuilder("select ISNULL(sum(projects.winningAmount), 0) from projects");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        }else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" where industryCategoryGuid = '" + industryCategoryGuid + "'");
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        }else {

            stringBuilder.append(" where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 按照项目求两个和
    public String sumProject(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                             @Param(value = "managementPowerGuid") String managementPowerGuid,
                             @Param(value = "buildLevelGuid") String buildLevelGuid) {

        StringBuilder stringBuilder = new StringBuilder("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projects");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        }else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" where industryCategoryGuid = '" + industryCategoryGuid + "'");
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        }else {

            stringBuilder.append(" where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 按照状态求和
    public String sumProjectStates(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                   @Param(value = "managementPowerGuid") String managementPowerGuid,
                                   @Param(value = "buildLevelGuid") String buildLevelGuid) {

        StringBuilder stringBuilder = new StringBuilder("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne from projectStates");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" LEFT JOIN projects on projectStates.guid = projects.projectStateGuid ");
        }else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
        }else {

            stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
        }

        stringBuilder.append(" GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId");

        return stringBuilder.toString();
    }

    // 按照状态求数量
    public String countStatus(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                              @Param(value = "managementPowerGuid") String managementPowerGuid,
                              @Param(value = "buildLevelGuid") String buildLevelGuid) {

        StringBuilder stringBuilder = new StringBuilder("select projectStates.name, ISNULL(count(projects.guid), 0) proportion from projectStates");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" LEFT JOIN projects on projectStates.guid = projects.projectStateGuid ");
        }else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
        }else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
        }else {

            stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
        }

        stringBuilder.append(" GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId");

        return stringBuilder.toString();
    }


}
