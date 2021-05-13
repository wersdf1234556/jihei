package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.BeamPrefabricationModel;

import javax.validation.Valid;

public interface BeamPrefabricationMapper extends BaseMapper<BeamPrefabricationModel>{

    @Select("select count(guid) from beamPrefabrications where status = #{status} and tenderGuid = #{tenderGuid}")
    Integer selectByStatus(@Param(value = "status") String status,
                           @Param(value = "tenderGuid") String tenderGuid);

    @Select("select count(guid) from beamPrefabrications where tenderGuid = #{tenderGuid}")
    Integer count(@Param(value = "tenderGuid") String tenderGuid);
}
