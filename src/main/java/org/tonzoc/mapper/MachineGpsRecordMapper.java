package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.MachineGpsRecordModel;

public interface MachineGpsRecordMapper extends BaseMapper<MachineGpsRecordModel> {

    // 查询最新的GPS
    @Select("select max(latest) from machineGpsRecords")
    Integer latestGps();
}
