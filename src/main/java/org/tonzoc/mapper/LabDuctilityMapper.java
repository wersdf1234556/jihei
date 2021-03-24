package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface LabDuctilityMapper extends BaseMapper<LabDuctilityModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labDuctilities.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labDuctilities\n" +
            "      group by sectionId) as labDuctilities\n" +
            "     on labTenders.mappingTenderGuid = labDuctilities.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
