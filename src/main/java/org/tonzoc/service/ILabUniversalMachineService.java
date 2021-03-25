package org.tonzoc.service;

import org.tonzoc.model.LabUniversalMachineModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabUniversalMachineService extends IBaseService<LabUniversalMachineModel> {
    List<LabStatModel> listStatistics();
}
