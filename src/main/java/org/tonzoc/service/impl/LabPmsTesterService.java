package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabPmsTesterMapper;
import org.tonzoc.model.LabPmsTesterModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabPmsTesterService;

import java.util.List;

@Service(value = "labPmsTesterService")
public class LabPmsTesterService extends BaseService<LabPmsTesterModel> implements ILabPmsTesterService {
    @Autowired
    private LabPmsTesterMapper labPmsTesterMapper;

    public List<LabStatModel> listStatistics() {
        return labPmsTesterMapper.listStatistics();
    }
}
