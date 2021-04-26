package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.tonzoc.model.BeamPersonModel;

public interface BeamPersonMapper extends BaseMapper<BeamPersonModel>{

    @Delete("delete from beamPersons where beamGuid = #{beamGuid}")
    void remove(@Param(value = "beamGuid") String beamGuid);

    @Delete("delete from beamPersons where personGuid = #{personGuid}")
    void deleteByPerson(@Param(value = "personGuid") String personGuid);
}
