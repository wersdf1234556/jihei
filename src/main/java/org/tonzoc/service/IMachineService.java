package org.tonzoc.service;

import org.tonzoc.model.MachineGpsRecordModel;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.TenderModel;
import org.tonzoc.model.support.ReturnListModel;
import org.tonzoc.model.support.ReturnMachineModel;

import java.util.List;
import java.util.Map;

public interface IMachineService extends IBaseService<MachineModel> {

    // 机械公用方法
    List<ReturnModel> machinePublic(Integer allNumber, List<ReturnModel> list);

    // 机械概况
    List<ReturnModel> machineSurvey(String tenderGuid);

    // 主界面机械概况
    List<ReturnModel> machineMainSurvey(String tenderGuid);

    // 重点机械
    List<ReturnMachineModel> importantMachine(String tenderGuid);

    // 全标段的重点机械
    List<TenderModel> allImportantMachine();

    // 机械GPS位置
    List<MachineGpsRecordModel> mechanicalPosition(String tenderGuid);

    // 按照机械类别查询机械类型
    List<ReturnListModel> machineTypeAndNumber(String machineCategoryGuid);

    // 查询重点机械
    List<MachineModel> importantByMachineType(String machineTypeGuid);
}
