package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.LabStressMachineModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

@Component
public interface LabStressMachineMapper extends BaseMapper<LabStressMachineModel> {

    @Select("select tenders.guid                     as tenderGuid,\n" +
            "       tenders.name                     as tenderName,\n" +
            "       isnull(labStressMachines.num, 0) as num\n" +
            "from labTenders\n" +
            "         left join tenders\n" +
            "                   on tenders.guid = labTenders.tenderGuid\n" +
            "         left join\n" +
            "     (select sectionId, count(1) as num\n" +
            "      from (select sectionId from labStressMachines where equipmentType = '${equipmentType}') as labStressMachines\n" +
            "      group by sectionId) as labStressMachines\n" +
            "     on labTenders.mappingTenderGuid = labStressMachines.sectionId\n" +
            "     " +
            "order by tenders.sortId")
    List<LabStatModel> listStatistics (@Param("equipmentType") String equipmentType);
}
