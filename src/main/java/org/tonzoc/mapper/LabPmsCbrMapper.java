package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.LabPmsCbrModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface LabPmsCbrMapper extends BaseMapper<LabPmsCbrModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labPmsCbrs.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labPmsCbrs\n" +
            "      group by sectionId) as labPmsCbrs\n" +
            "     on labTenders.mappingTenderGuid = labPmsCbrs.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
