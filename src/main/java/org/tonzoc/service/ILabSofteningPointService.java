package org.tonzoc.service;

import org.tonzoc.model.LabSofteningPointModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabSofteningPointService extends IBaseService<LabSofteningPointModel> {
    List<LabStatModel> listStatistics();
}
