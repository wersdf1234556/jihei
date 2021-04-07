package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

public class ProjectProvider {

    // 项目数量
    public String count(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                        @Param(value = "managementPowerGuid") String managementPowerGuid,
                        @Param(value = "buildLevelGuid") String buildLevelGuid,
                        @Param(value = "isImportant") Integer isImportant) {

        StringBuilder stringBuilder = new StringBuilder("select count(guid) from projects where ((projectStateGuid = 'C5E03584-9AAC-4C0D-965A-0FD33AAC9A3F'\n" +
                "    and currentYearPlanAmount > 0) or projectStateGuid = '054FB779-0A4C-4D5C-81E6-82264297E4F1')");
        if (isImportant != null && isImportant == 1) {
            stringBuilder.append(" and isImportant = " + isImportant + " and isImportantCount = 0");
        }

        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "'");
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        } else {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 项目开工数量
    public String countStart(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                             @Param(value = "managementPowerGuid") String managementPowerGuid,
                             @Param(value = "buildLevelGuid") String buildLevelGuid,
                             @Param(value = "isImportant") Integer isImportant) {

        StringBuilder stringBuilder = new StringBuilder("select count(guid) from projects where projectStateGuid = '054FB779-0A4C-4D5C-81E6-82264297E4F1'");
        if (isImportant != null && isImportant == 1) {
            stringBuilder.append(" and projects.isImportant = 1 and projects.isImportantCount = 0");
        }

        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "'");
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        } else {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 项目复工数量
    public String countRecover(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                             @Param(value = "managementPowerGuid") String managementPowerGuid,
                             @Param(value = "buildLevelGuid") String buildLevelGuid,
                             @Param(value = "isImportant") Integer isImportant) {

        StringBuilder stringBuilder = new StringBuilder("select count(guid) from projects where projectStateGuid = '7B271B73-06F6-413D-A68C-C81DA54C004B' and currentYearStatAmount > 0");
        if (isImportant != null && isImportant == 1) {
            stringBuilder.append(" and projects.isImportant = 1 and projects.isImportantCount = 0");
        }

        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "'");
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        } else {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 续建项目数量
    public String countStarted(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                        @Param(value = "managementPowerGuid") String managementPowerGuid,
                        @Param(value = "buildLevelGuid") String buildLevelGuid,
                        @Param(value = "isImportant") Integer isImportant) {

        StringBuilder stringBuilder = new StringBuilder("select count(guid) from projects where projectStateGuid = '7B271B73-06F6-413D-A68C-C81DA54C004B'");
        if (isImportant != null && isImportant == 1) {
            stringBuilder.append(" and isImportant = " + isImportant + " and isImportantCount = 0");
        }

        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "'");
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        } else {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 按照状态计算总额的和
    public String sumWinning(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                             @Param(value = "managementPowerGuid") String managementPowerGuid,
                             @Param(value = "buildLevelGuid") String buildLevelGuid,
                             @Param(value = "isImportant") Integer isImportant) {

        StringBuilder stringBuilder = new StringBuilder("select projectStates.name name, ISNULL(sum(projects.winningAmount), 0) amount from projectStates");

        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1) projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN projects on projects.projectStateGuid = projectStates.guid ");
            }
        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1 and industryCategoryGuid = '" + industryCategoryGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            }
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1 and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            }
        } else {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1 and  industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            }
        }

        stringBuilder.append(" GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId");

        return stringBuilder.toString();
    }

    // 按照项目计算总额的和
    public String sum(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                      @Param(value = "managementPowerGuid") String managementPowerGuid,
                      @Param(value = "buildLevelGuid") String buildLevelGuid,
                      @Param(value = "isImportant") Integer isImportant) {

        StringBuilder stringBuilder = new StringBuilder("select ISNULL(sum(projects.winningAmount), 0) from projects");
        if (isImportant != null && isImportant == 1) {
            stringBuilder.append(" where isImportant = " + isImportant);
        } else {
            stringBuilder.append(" where 1 = 1");
        }

        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "'");
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        } else {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 按照项目求两个和
    public String sumProject(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                             @Param(value = "managementPowerGuid") String managementPowerGuid,
                             @Param(value = "buildLevelGuid") String buildLevelGuid,
                             @Param(value = "isImportant") Integer isImportant) {

        StringBuilder stringBuilder = new StringBuilder("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne, ISNULL(sum(projects.currentYearPlanAmount), 0) as currentYearPlanAmount, ISNULL(sum(projects.currentYearStatAmount), 0) currentYearStatAmount from projects");
        if (isImportant != null && isImportant == 1) {
            stringBuilder.append(" where isImportant = " + isImportant);
        } else {
            stringBuilder.append(" where 1 = 1");
        }

        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "'");
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "'");
        } else {

            stringBuilder.append(" and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 按照状态求和
    public String sumProjectStates(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                                   @Param(value = "managementPowerGuid") String managementPowerGuid,
                                   @Param(value = "buildLevelGuid") String buildLevelGuid,
                                   @Param(value = "isImportant") Integer isImportant) {

        StringBuilder stringBuilder = new StringBuilder("select ISNULL(sum(projects.winningAmount), 0) amount, ISNULL(sum(projects.completeAmount), 0) amountOne, ISNULL(sum(projects.currentYearPlanAmount), 0) as currentYearPlanAmount, ISNULL(sum(projects.currentYearStatAmount), 0) as currentYearStatAmount from projectStates");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1) projects on projectStates.guid = projects.projectStateGuid ");
            } else {
                stringBuilder.append(" LEFT JOIN projects on projectStates.guid = projects.projectStateGuid ");
            }
        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1 and industryCategoryGuid = '" + industryCategoryGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            }
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1 and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            }
        } else {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1 and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            }
        }

        stringBuilder.append(" GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId");

        return stringBuilder.toString();
    }

    // 按照状态求数量
    public String countStatus(@Param(value = "industryCategoryGuid") String industryCategoryGuid,
                              @Param(value = "managementPowerGuid") String managementPowerGuid,
                              @Param(value = "buildLevelGuid") String buildLevelGuid,
                              @Param(value = "isImportant") Integer isImportant) {

        StringBuilder stringBuilder = new StringBuilder("select projectStates.name, ISNULL(count(projects.guid), 0) proportion from projectStates");
        if ((industryCategoryGuid == null && managementPowerGuid == null && buildLevelGuid == null) || ("".equals(industryCategoryGuid) && "".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1) projects on projectStates.guid = projects.projectStateGuid ");
            } else {
                stringBuilder.append(" LEFT JOIN projects on projectStates.guid = projects.projectStateGuid ");
            }
        } else if ((managementPowerGuid == null && buildLevelGuid == null) || ("".equals(managementPowerGuid) && "".equals(buildLevelGuid))) {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1 and industryCategoryGuid = '" + industryCategoryGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            }
        } else if (buildLevelGuid == null || "".equals(buildLevelGuid)) {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1 and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            }
        } else {
            if (isImportant != null && isImportant == 1) {
                stringBuilder.append(" LEFT JOIN (select * from projects where projects.isImportant = 1 and industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            } else {
                stringBuilder.append(" LEFT JOIN (select * from projects where industryCategoryGuid = '" + industryCategoryGuid + "' and managementPowerGuid = '" + managementPowerGuid + "' and buildLevelGuid = '" + buildLevelGuid + "') projects on projects.projectStateGuid = projectStates.guid ");
            }
        }

        stringBuilder.append(" GROUP BY projectStates.name, projectStates.sortId ORDER BY projectStates.sortId");

        return stringBuilder.toString();
    }


}
