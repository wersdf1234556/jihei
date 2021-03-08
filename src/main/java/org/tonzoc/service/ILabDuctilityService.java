package org.tonzoc.service;

import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.support.LabStatModel;

import java.util.List;

public interface ILabDuctilityService extends IBaseService<LabDuctilityModel> {

    List<LabStatModel> listStatistics();
}
