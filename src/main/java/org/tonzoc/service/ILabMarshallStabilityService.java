package org.tonzoc.service;

import org.tonzoc.model.LabMarshallStabilityModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabMarshallStabilityService extends IBaseService<LabMarshallStabilityModel> {
    List<LabStatModel> listStatistics();
}
