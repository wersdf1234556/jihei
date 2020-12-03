package org.tonzoc.service;

import org.tonzoc.model.MachinesModel;
import org.tonzoc.model.ReturnModel;

public interface IMachinesService extends IBaseService<MachinesModel> {

    // 机械概况
    ReturnModel mechanicsSurvey(String tenderGuid);

    // 重点机械
    ReturnModel importantMechanics(String tenderGuid);
}
