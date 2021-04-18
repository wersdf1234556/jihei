package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.BeamModel;

import java.util.List;

public interface BeamMapper extends BaseMapper<BeamModel>{

    @Select("select beams.*, tenders.name tenderName, beamPedestals.name beamPedestalName, beamPedestals.status beamPedestalStatus, beamPrefabrications.name beamPrefabricationName, beamPrefabrications.status beamPrefabricationStatus from beams" +
            " LEFT JOIN beamPedestals on beams.beamPedestalGuid = beamPedestals.guid" +
            " LEFT JOIN beamPrefabrications on beams.beamPrefabricationGuid = beamPrefabrications.guid" +
            " LEFT JOIN tenders on beams.tenderGuid = tenders.guid" +
            " where beamPedestalGuid = #{beamPedestalGuid}")
    List<BeamModel> listByPedestal(@Param(value = "beamPedestalGuid") String beamPedestalGuid);

    @Select("select count(beams.guid) from beams" +
            " LEFT JOIN beamPedestals on beams.beamPedestalGuid = beamPedestals.guid" +
            " LEFT JOIN beamPrefabrications on beams.beamPrefabricationGuid = beamPrefabrications.guid" +
            " where beams.beamPedestalGuid = #{beamPedestalGuid} and beamPrefabrications.status != 'finish'")
    Integer selectByBeamPedestal(@Param(value = "beamPedestalGuid") String beamPedestalGuid);

    @Select("select count(beams.guid) from beams" +
            " LEFT JOIN beamPrefabrications on beams.beamPrefabricationGuid = beamPrefabrications.guid" +
            " where beams.beamPrefabricationGuid = #{beamPrefabricationGuid} and beamPrefabrications.status = 'unSubmit'")
    Integer selectByBeamPrefabrication(@Param(value = "beamPrefabricationGuid") String beamPrefabricationGuid);
}
