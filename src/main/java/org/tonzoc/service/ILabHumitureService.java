package org.tonzoc.service;

import org.tonzoc.model.LabHumitureModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabHumitureService extends IBaseService<LabHumitureModel> {
    List<LabStatModel> listStatistics();
}
