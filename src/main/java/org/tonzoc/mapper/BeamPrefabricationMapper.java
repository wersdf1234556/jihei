package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.BeamPrefabricationModel;

import javax.validation.Valid;

public interface BeamPrefabricationMapper extends BaseMapper<BeamPrefabricationModel>{

    @Select("select count(guid) from beamPrefabrications where status = #{status}")
    Integer selectByStatus(@Param(value = "status") String status);

    @Select("select count(guid) from beamPrefabrications")
    Integer count();
}
