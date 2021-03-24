package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface LabConcreteTestHammerMapper extends BaseMapper<LabConcreteTestHammerModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labConcreteTestHammers.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labConcreteTestHammers\n" +
            "      group by sectionId) as labConcreteTestHammers\n" +
            "     on labTenders.mappingTenderGuid = labConcreteTestHammers.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
