package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabMarshallStabilityMapper;
import org.tonzoc.model.LabMarshallStabilityModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabMarshallStabilityService;

import java.util.List;

@Service(value = "labMarshallStabilityService")
public class LabMarshallStabilityService extends BaseService<LabMarshallStabilityModel> implements ILabMarshallStabilityService {
    @Autowired
    private LabMarshallStabilityMapper labMarshallStabilityMapper;

    public List<LabStatModel> listStatistics() {
        return labMarshallStabilityMapper.listStatistics();
    }
}
