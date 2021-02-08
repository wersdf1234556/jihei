package org.tonzoc.service;

import org.tonzoc.model.LabCoverProtectometerModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabCoverProtectometerService extends IBaseService<LabCoverProtectometerModel> {
    List<LabStatModel> listStatistics();
}
