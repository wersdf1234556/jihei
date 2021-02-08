package org.tonzoc.service;

import org.tonzoc.model.LabStressMachineModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabStressMachineService extends IBaseService<LabStressMachineModel> {

    List<LabStatModel> listStatistics();
}
