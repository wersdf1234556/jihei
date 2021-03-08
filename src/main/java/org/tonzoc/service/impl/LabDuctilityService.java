package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabDuctilityService;

import java.util.List;

@Service(value = "labDuctilityService")
public class LabDuctilityService extends BaseService<LabDuctilityModel> implements ILabDuctilityService {

    @Override
    public List<LabStatModel> listStatistics() {
        return null;
    }
}
