package org.tonzoc.service;

import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabConcreteTestHammerService extends IBaseService<LabConcreteTestHammerModel> {
    List<LabStatModel> listStatistics();

}
