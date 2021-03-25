package org.tonzoc.service;

import org.tonzoc.model.LabPmsSpringbackModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabPmsSpringbackService extends IBaseService<LabPmsSpringbackModel> {
    List<LabStatModel> listStatistics();
}
