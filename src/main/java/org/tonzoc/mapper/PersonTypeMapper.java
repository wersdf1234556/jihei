package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.PersonTypeModel;

import java.util.List;

public interface PersonTypeMapper extends BaseMapper<PersonTypeModel>  {

    @Select("select * from personTypes where name = #{name}")
    PersonTypeModel guidByName(@Param(value = "name") String name);

    @Select("select personTypes.guid, personTypes.name, count(DISTINCT attendances.personGuid) number from personTypes" +
            " LEFT JOIN (select * from persons where persons.tenderGuid = #{tenderGuid})persons on persons.personTypeGuid = personTypes.guid" +
            " LEFT JOIN attendances on attendances.personGuid = persons.guid" +
            " where personTypes.categoryGuid = #{categoryGuid}" +
            " GROUP BY personTypes.guid, personTypes.name")
    List<PersonTypeModel> selectByCategory(@Param(value = "categoryGuid") String categoryGuid,
                                           @Param(value = "tenderGuid") String tenderGuid);
}
