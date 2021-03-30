package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.HangZhouGPSMapper;
import org.tonzoc.model.HangZhouGPSModel;
import org.tonzoc.service.IHangZhouGPSService;

import java.util.List;

@Service
public class HangZhouGPSService extends BaseService<HangZhouGPSModel> implements IHangZhouGPSService {

    @Autowired
    private HangZhouGPSMapper hangZhouGPSMapper;

    // 查询轨迹
    @Override
    public List<HangZhouGPSModel> trajectory(String hDate){

        return hangZhouGPSMapper.trajectory(hDate);
    }
}
