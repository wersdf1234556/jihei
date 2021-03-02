package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.SubTypeModel;

import java.util.List;

public interface SubTypeMapper extends BaseMapper<SubTypeModel> {

    @Select("select name from subTypes where guid != #{guid}")
    List<String> listGuid(String guid);

    @Select("select name from subTypes where name != #{name}")
    List<String> listName(String guid);

}
