package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.LabPmsSpringbackModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface LabPmsSpringbackMapper extends BaseMapper<LabPmsSpringbackModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labPmsSpringback.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labPmsSpringback\n" +
            "      group by sectionId) as labPmsSpringback\n" +
            "     on labTenders.mappingTenderGuid = labPmsSpringback.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
