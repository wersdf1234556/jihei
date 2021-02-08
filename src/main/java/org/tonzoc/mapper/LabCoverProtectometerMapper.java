package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.LabCoverProtectometerModel;
import org.tonzoc.model.LabMarshallStabilityModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

@Component
public interface LabCoverProtectometerMapper extends BaseMapper<LabCoverProtectometerModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name as tenderName,\n" +
            "       isnull(LabCoverProtectometers.num, 0) as num\n" +
            "from tenders\n" +
            "         left join labTenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from LabCoverProtectometers\n" +
            "      group by sectionId) as LabCoverProtectometers\n" +
            "     on labTenders.mappingTenderGuid = LabCoverProtectometers.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
