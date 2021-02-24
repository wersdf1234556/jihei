package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.SubTypeModel;

import java.util.List;

public interface SubTypeMapper extends BaseMapper<SubTypeModel> {

    @Select("select name from subTypes")
    List<String> listName();

}
