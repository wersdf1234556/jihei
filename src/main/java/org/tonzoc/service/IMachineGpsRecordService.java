package org.tonzoc.service;

import org.tonzoc.model.MachineGpsRecordModel;

import java.util.List;

public interface IMachineGpsRecordService extends IBaseService<MachineGpsRecordModel> {

    // 添加GPS进数据中
    void add();

    // 查询轨迹
    List<MachineGpsRecordModel> trajectory(String hGPSID, String startDate, String endDate);
}