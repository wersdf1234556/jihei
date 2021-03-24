package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.LabUniversalRebarModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface LabUniversalRebarMapper extends BaseMapper<LabUniversalRebarModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labUniversalRebars.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labUniversalRebars\n" +
            "      group by sectionId) as labUniversalRebars\n" +
            "     on labTenders.mappingTenderGuid = labUniversalRebars.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
