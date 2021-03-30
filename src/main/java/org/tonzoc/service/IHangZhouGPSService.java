package org.tonzoc.service;

import org.tonzoc.model.HangZhouGPSModel;

import java.util.List;

public interface IHangZhouGPSService extends IBaseService<HangZhouGPSModel> {

    // 查询轨迹
    List<HangZhouGPSModel> trajectory(String hGPSID, String startDate, String endDate);
}
