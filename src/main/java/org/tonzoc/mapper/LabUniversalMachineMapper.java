package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.LabUniversalMachineModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface LabUniversalMachineMapper extends BaseMapper<LabUniversalMachineModel> {
    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labUniversalMachines.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from labUniversalMachines\n" +
            "      group by sectionId) as labUniversalMachines\n" +
            "     on labTenders.mappingTenderGuid = labUniversalMachines.sectionId\n" +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics ();
}
