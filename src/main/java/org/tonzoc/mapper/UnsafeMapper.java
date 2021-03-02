package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.UnsafeModel;

import java.util.List;

public interface UnsafeMapper extends BaseMapper<UnsafeModel> {

    @Select("select count(guid) number, grade name from unsafes GROUP BY grade")
    List<ReturnModel> count();
}
