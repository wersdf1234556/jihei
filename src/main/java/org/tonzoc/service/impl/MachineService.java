package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.MachineMapper;
import org.tonzoc.mapper.TenderMapper;
import org.tonzoc.model.MachineGpsRecordModel;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.TenderModel;
import org.tonzoc.service.IMachineService;

import java.text.NumberFormat;
import java.util.*;

@Service
public class MachineService extends BaseService<MachineModel> implements IMachineService {

    @Autowired
    private MachineMapper machineMapper;

    @Autowired
    private TenderMapper tenderMapper;

    @Autowired
    private TenderService tenderService;

    // 机械公用方法
    public List<ReturnModel> machinePublic(Integer allNumber, List<ReturnModel> list) {
        List<ReturnModel> list1 = new ArrayList();
        double proportion = 0;

        if (allNumber > 0) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);   // 设置小数最多两位
            numberFormat.setMinimumFractionDigits(2);   // 设置小数最少两位

            for (int i = 0; i < list.size(); i++) {
                ReturnModel returnModel = new ReturnModel();
                returnModel.setName(list.get(i).getName());
                returnModel.setNumber(list.get(i).getNumber());

                if (i + 1 == list.size()) {
                    String result = numberFormat.format((1 - proportion) * 100);
                    returnModel.setProportion(result + "%");

                } else {
                    proportion += (double) list.get(i).getNumber() / (double) allNumber;
                    String result = numberFormat.format(((double) list.get(i).getNumber() / (double) allNumber) * 100);
                    returnModel.setProportion(result + "%");

                }
                list1.add(returnModel);
            }
        } else {
            return list;
        }
        return list1;
    }

    // 机械概况
    @Override
    public List<ReturnModel> machineSurvey(String tenderGuid) {

        List<ReturnModel> list = machineMapper.selectMachineCategoryNumber(tenderGuid);
        Integer allNumber = machineMapper.allNumber(tenderGuid);

        return this.machinePublic(allNumber, list);
    }

    // 重点机械
    @Override
    public List<ReturnModel> importantMachine(String tenderGuid) {

        List<ReturnModel> list = machineMapper.selectMachineTypeNumber(tenderGuid);
        Integer allNumber = machineMapper.allNumber(tenderGuid);

        return this.machinePublic(allNumber, list);
    }

    // 全标段的重点机械
    @Override
    public List<TenderModel> allImportantMachine(){

        List<TenderModel> list1 = tenderMapper.list();

        for (TenderModel li:list1) {

            li.setList(machineMapper.allImportantMachine(li.getGuid()));
        }
        return list1;
    }

    // 机械GPS位置
    @Override
    public List<MachineGpsRecordModel> mechanicalPosition(String tenderGuid) {

        return null;
    }

    // 按照机械类别查询机械类型
    @Override
    public List<ReturnModel> machineTypeAndNumber(String machineCategoryGuid){

        return machineMapper.machineTypeAndNumber(machineCategoryGuid);
    }
}
