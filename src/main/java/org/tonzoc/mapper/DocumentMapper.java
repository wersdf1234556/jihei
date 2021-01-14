package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.DocumentModel;

import java.util.Date;

public interface DocumentMapper extends BaseMapper<DocumentModel> {

    // 修改开始时间
    @Update("update documents set startTime = #{startTime} where guid = #{guid}")
    void updateStartTime(Date startTime, String guid);

    // 修改结束时间
    @Update("update documents set endTime = #{endTime} where guid = #{guid}")
    void updateEndTime(Date endTime, String guid);
}