package org.tonzoc.service;

import org.tonzoc.model.LabUniversalCementModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabUniversalCementService extends IBaseService<LabUniversalCementModel> {

    List<LabStatModel> listStatistics();
}
