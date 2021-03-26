package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.HangZhouGPSModel;

import java.util.List;

public interface HangZhouGPSMapper extends BaseMapper<HangZhouGPSModel> {

    @Select("select * from HangZhouGPS where HDate not like '%${hDate}%'")
    List<HangZhouGPSModel> history(@Param(value = "hDate") String hDate);
}
