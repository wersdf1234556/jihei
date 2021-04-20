package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.BaidaModel;
import org.tonzoc.model.CameraModel;

import java.util.List;

@Component
public interface BaidaMapper extends BaseMapper<BaidaModel> {
    @Select("select categoryGuid,\n" +
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
            "group by CategoryGuid, industryCategorys.sortId  order by industryCategorys.sortId")
    List<BaidaModel> getStat();
}
