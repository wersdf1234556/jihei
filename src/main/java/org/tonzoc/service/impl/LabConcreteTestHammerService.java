package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabConcreteTestHammerMapper;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabConcreteTestHammerService;

import java.util.List;

@Service(value = "labConcreteTestHammerService")
public class LabConcreteTestHammerService extends BaseService<LabConcreteTestHammerModel> implements ILabConcreteTestHammerService {

    @Autowired
    private LabConcreteTestHammerMapper labConcreteTestHammerMapper;

    public List<LabStatModel> listStatistics() {
        return labConcreteTestHammerMapper.listStatistics();
    }
}
