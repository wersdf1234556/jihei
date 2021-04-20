package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

public class BaidaProvider {

    // 获取所有项目数量
    public String getStat(@Param(value = "categoryGuid") String categoryGuid,
                        @Param(value = "projectTypeGuid") String projectTypeGuid) {

        StringBuilder stringBuilder = new StringBuilder("select categoryGuid,\n" +
                "       industryCategorys.name                           as categoryName,\n" +
                "       ''                           as projectTypeName,\n" +
                "       ''                           as ProjectName,\n" +
                "       ''                           as ConstructionContent,\n" +
                "       ''                           as ProjectTypeGuid,\n" +
                "       ''                           as PlanStartTime,\n" +
                "       ''                           as PlanCompleteTime,\n" +
                "       sum(TotalInvestment)         as totalInvestment,\n" +
                "       sum(currentYearPlan)         as currentYearPlan,\n" +
                "       sum(complete3)               as complete3,\n" +
                "       sum(complete4)               as complete4,\n" +
                "       sum(complete5)               as complete5,\n" +
                "       sum(complete6)               as complete6,\n" +
                "       sum(complete7)               as complete7,\n" +
                "       sum(complete8)               as complete8,\n" +
                "       sum(complete9)               as complete9,\n" +
                "       sum(complete10)              as complete10,\n" +
                "       sum(complete11)              as complete11,\n" +
                "       sum(complete12)              as complete12,\n" +
                "       sum(currentYearComplete)     as currentYearComplete,\n" +
                "       sum(totalCompleteInvestment) as totalCompleteInvestment,\n" +
                "       ''                           as ProjectProgress,\n" +
                "       ''                           as Question,\n" +
                "       ''                           as Address,\n" +
                "       ''                           as UserGuid,\n" +
                "       categoryGuid                 as guid\n" +
                "from BaiDa\n" +
                "         right join industryCategorys on BaiDa.CategoryGuid = industryCategorys.guid\n" +
                "         inner join projectstates on BaiDa.ProjectTypeGuid = projectstates.guid\n" +
                "         inner join users on BaiDa.UserGuid = users.guid\n" +
                "         where 1 = 1 ");

        if (categoryGuid != null && !"".equals(categoryGuid)) {
            stringBuilder.append(" and categoryGuid = '").append(categoryGuid).append("'\n");
        }
        if (projectTypeGuid != null && !"".equals(projectTypeGuid)) {
            stringBuilder.append(" and projectTypeGuid = '").append(projectTypeGuid).append("'\n");
        }
        stringBuilder.append(" group by CategoryGuid, industryCategorys.name, industryCategorys.sortId  order by industryCategorys.sortId");

        return stringBuilder.toString();
    }
}
