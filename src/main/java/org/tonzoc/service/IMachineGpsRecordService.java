package org.tonzoc.service;

import org.tonzoc.model.HangZhouGPSModel;
import org.tonzoc.model.MachineGpsRecordModel;

public interface IMachineGpsRecordService extends IBaseService<MachineGpsRecordModel> {

    // 添加GPS进数据中
    void add(HangZhouGPSModel hangZhouGPSModel);
}