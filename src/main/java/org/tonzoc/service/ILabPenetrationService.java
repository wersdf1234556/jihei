package org.tonzoc.service;

import org.tonzoc.model.LabPenetrationModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabPenetrationService extends IBaseService<LabPenetrationModel> {
    List<LabStatModel> listStatistics();
}
