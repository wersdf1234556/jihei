package org.tonzoc.service;

import org.tonzoc.model.LabPmsTesterModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabPmsTesterService extends IBaseService<LabPmsTesterModel> {
    List<LabStatModel> listStatistics();
}
