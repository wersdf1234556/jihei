package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.mapper.HangZhouGPSMapper;
import org.tonzoc.mapper.MachineCategoryMapper;
import org.tonzoc.mapper.MachineGpsRecordMapper;
import org.tonzoc.model.HangZhouGPSModel;
import org.tonzoc.model.MachineGpsRecordModel;
import org.tonzoc.service.IHangZhouGPSService;
import org.tonzoc.service.IMachineGpsRecordService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MachineGpsRecordService extends BaseService<MachineGpsRecordModel> implements IMachineGpsRecordService {

    @Autowired
    private MachineGpsRecordMapper machineGpsRecordMapper;

    @Autowired
    private HangZhouGPSMapper hangZhouGPSMapper;

    @Autowired
    private IHangZhouGPSService hangZhouGPSService;

    // 添加GPS进数据中
    @Override
    public void add(){

        List<MachineGpsRecordModel> list1 = new ArrayList<>();
        String hDate = TimeHelper.dateToString(new Date());
        List<HangZhouGPSModel> list = hangZhouGPSMapper.history(hDate);
        for (HangZhouGPSModel li:list) {
            MachineGpsRecordModel machineGpsRecordModel = new MachineGpsRecordModel();
            machineGpsRecordModel.setHType(li.getHType());
            machineGpsRecordModel.setHGPSID(li.getHGPSID());
            machineGpsRecordModel.setHGPSE(li.getHGPSE());
            machineGpsRecordModel.setHGPSN(li.getHGPSN());
            machineGpsRecordModel.setHSpeed(li.getHSpeed());
            machineGpsRecordModel.setHDate(li.getHDate());
            machineGpsRecordModel.setIsParsed(li.getIsParsed());
            machineGpsRecordModel.setRefinedLng(li.getRefinedLng());
            machineGpsRecordModel.setRefinedLat(li.getRefinedLat());
            machineGpsRecordModel.setBaiduLng(li.getBaiduLng());
            machineGpsRecordModel.setBaiduLat(li.getBaiduLat());

            if (list1.size() == 1000) {

                this.saveMany(list1);
                list1.clear();
            }else{

                list1.add(machineGpsRecordModel);
                // hangZhouGPSService.remove(li.getGuid());
            }
        }

        this.saveMany(list1);
    }


    // 查询轨迹
    @Override
    public List<MachineGpsRecordModel> trajectory(String hGPSID, String startDate, String endDate){

        return machineGpsRecordMapper.trajectory(hGPSID, startDate, endDate);
    }
}
