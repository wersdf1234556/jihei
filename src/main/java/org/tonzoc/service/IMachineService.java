package org.tonzoc.service;

import org.tonzoc.model.MachineModel;
import org.tonzoc.model.ReturnModel;

import java.util.List;

public interface IMachineService extends IBaseService<MachineModel> {

    // 机械概况
    List<ReturnModel> machineSurvey(String tenderGuid);

    // 重点机械
    List<ReturnModel> importantMachine(String tenderGuid);
}
