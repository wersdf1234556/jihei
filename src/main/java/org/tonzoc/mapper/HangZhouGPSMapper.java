package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.HangZhouGPSModel;

import java.util.List;

public interface HangZhouGPSMapper extends BaseMapper<HangZhouGPSModel> {

    @Select("select * from HangZhouGPS where HDate not like '%${hDate}%'")
    List<HangZhouGPSModel> history(@Param(value = "hDate") String hDate);

    // 查询轨迹
    @Select("select * from HangZhouGPS where hGPSID = #{hGPSID} and HDate >= #{startDate} and HDate <= #{endDate}")
    List<HangZhouGPSModel> trajectory(@Param(value = "hGPSID") String hGPSID,
                                      @Param(value = "startDate") String startDate,
                                      @Param(value = "endDate") String endDate);
}
