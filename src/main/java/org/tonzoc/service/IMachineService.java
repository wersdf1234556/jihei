package org.tonzoc.service;

import org.tonzoc.model.MachineGpsRecordModel;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.ReturnModel;

import java.util.List;
import java.util.Map;

public interface IMachineService extends IBaseService<MachineModel> {

    // 机械概况
    List<ReturnModel> machineSurvey(String tenderGuid);

    // 重点机械
    List<ReturnModel> importantMachine(String tenderGuid);

    // 全标段的重点机械
    Map<String, List<ReturnModel>> allImportantMachine();

    // 机械GPS位置
    List<MachineGpsRecordModel> mechanicalPosition(String tenderGuid);
}
