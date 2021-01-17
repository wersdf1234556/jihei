package org.tonzoc.service;

import org.tonzoc.model.LabStressMachineModel;
import org.tonzoc.model.support.LabStressMachineStatModel;

import java.util.List;

public interface ILabStressMachineService extends IBaseService<LabStressMachineModel> {

    List<LabStressMachineStatModel> listStatistics();
}
