package org.tonzoc.service;

import org.tonzoc.model.LabUniversalRebarModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabUniversalRebarService extends IBaseService<LabUniversalRebarModel> {

    List<LabStatModel> listStatistics();
}
