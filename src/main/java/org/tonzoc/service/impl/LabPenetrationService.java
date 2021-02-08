package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabPenetrationMapper;
import org.tonzoc.model.LabPenetrationModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabPenetrationService;

import java.util.List;

@Service(value = "labPenetrationService")
public class LabPenetrationService extends BaseService<LabPenetrationModel> implements ILabPenetrationService {
    @Autowired
    private LabPenetrationMapper labPenetrationMapper;

    public List<LabStatModel> listStatistics() {
        return labPenetrationMapper.listStatistics();
    }
}
