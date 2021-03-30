package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.PersonTypeModel;

public interface PersonTypeMapper extends BaseMapper<PersonTypeModel>  {

    @Select("select * from personTypes where name = #{name}")
    PersonTypeModel guidByName(@Param(value = "name") String name);
}
