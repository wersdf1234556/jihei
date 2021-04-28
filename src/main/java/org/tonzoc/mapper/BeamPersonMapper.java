package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.BeamPersonModel;

import java.util.List;

public interface BeamPersonMapper extends BaseMapper<BeamPersonModel>{

    @Delete("delete from beamPersons where beamGuid = #{beamGuid}")
    void remove(@Param(value = "beamGuid") String beamGuid);

    @Delete("delete from beamPersons where personGuid = #{personGuid}")
    void deleteByPerson(@Param(value = "personGuid") String personGuid);

    @Select("select personGuid from beamPersons where tenderGuid = #{tenderGuid}")
    List<String> personByTender(@Param(value = "tenderGuid") String tenderGuid);
}
