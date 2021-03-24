package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.LabMarshallStabilityModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

@Component
public interface LabMarshallStabilityMapper extends BaseMapper<LabMarshallStabilityModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labMarshallStabilities.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labMarshallStabilities\n" +
            "      group by sectionId) as labMarshallStabilities\n" +
            "     on labTenders.mappingTenderGuid = labMarshallStabilities.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
