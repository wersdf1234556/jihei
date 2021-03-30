package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.MachineGpsRecordModel;

import java.util.List;

public interface MachineGpsRecordMapper extends BaseMapper<MachineGpsRecordModel> {

    // 查询最新的GPS
    @Select("select max(latest) from machineGpsRecords")
    Integer latestGps();

    @Select("select * from machineGpsRecords where hGPSID = #{hGPSID} and HDate >= #{startDate} and HDate <= #{endDate}")
    List<MachineGpsRecordModel> trajectory(@Param(value = "hGPSID") String hGPSID,
                                           @Param(value = "startDate") String startDate,
                                           @Param(value = "endDate") String endDate);
}
