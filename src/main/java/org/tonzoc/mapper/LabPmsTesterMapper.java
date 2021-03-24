package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.LabPmsTesterModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface LabPmsTesterMapper extends BaseMapper<LabPmsTesterModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labPmsTesters.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labPmsTesters\n" +
            "      group by sectionId) as labPmsTesters\n" +
            "     on labTenders.mappingTenderGuid = labPmsTesters.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
