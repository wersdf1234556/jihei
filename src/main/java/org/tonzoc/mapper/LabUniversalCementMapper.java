package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.LabUniversalCementModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface LabUniversalCementMapper extends BaseMapper<LabUniversalCementModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labUniversalCements.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labUniversalCements\n" +
            "      group by sectionId) as labUniversalCements\n" +
            "     on labTenders.mappingTenderGuid = labUniversalCements.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
