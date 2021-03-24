package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.LabHumitureModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface LabHumitureMapper extends BaseMapper<LabHumitureModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labHumitures.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labHumitures\n" +
            "      group by sectionId) as labHumitures\n" +
            "     on labTenders.mappingTenderGuid = labHumitures.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
