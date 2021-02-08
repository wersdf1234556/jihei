package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabStressMachineMapper;
import org.tonzoc.model.LabStressMachineModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabStressMachineService;

import java.util.List;

@Service(value = "labStressMachineService")
public class LabStressMachineService extends BaseService<LabStressMachineModel> implements ILabStressMachineService {

    @Autowired
    private LabStressMachineMapper labStressMachineMapper;

    public List<LabStatModel> listStatistics() {
        return labStressMachineMapper.listStatistics();
    }
}
