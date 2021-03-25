package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabUniversalMachineMapper;
import org.tonzoc.model.LabUniversalMachineModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabUniversalMachineService;

import java.util.List;

@Service(value = "labUniversalMachineService")
public class LabUniversalMachineService extends BaseService<LabUniversalMachineModel> implements ILabUniversalMachineService {
    @Autowired
    private LabUniversalMachineMapper labUniversalMachineMapper;

    public List<LabStatModel> listStatistics() {
        return labUniversalMachineMapper.listStatistics();
    }
}
