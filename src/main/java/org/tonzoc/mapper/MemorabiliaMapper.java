package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.MemorabiliaModel;

import java.util.Date;

public interface MemorabiliaMapper extends BaseMapper<MemorabiliaModel> {

    @Update("update memorabilias set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(Date currentTime, String guid);
}
