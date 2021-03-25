package org.tonzoc.service;

import org.tonzoc.model.LabPmsCbrModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabPmsCbrService extends IBaseService<LabPmsCbrModel> {
    List<LabStatModel> listStatistics();
}
