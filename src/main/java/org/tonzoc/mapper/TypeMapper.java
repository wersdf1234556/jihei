package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.TypeModel;

import java.util.List;

public interface TypeMapper extends BaseMapper<TypeModel> {

    @Select("select * from types as MainTable where id in (1,2,3,4)")
    List<TypeModel> listById();
}
