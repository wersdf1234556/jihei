package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.UnsafeModel;

import java.util.List;

public interface UnsafeMapper extends BaseMapper<UnsafeModel> {

    @Select("select unsafeTypes.uname name, count(unsafes.guid) number from unsafes LEFT JOIN unsafeTypes on unsafes.unsafeTypeGuid = unsafeTypes.guid GROUP BY unsafeTypes.uname")
    List<ReturnModel> count();
}
