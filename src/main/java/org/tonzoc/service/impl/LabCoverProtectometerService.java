package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabCoverProtectometerMapper;
import org.tonzoc.model.LabCoverProtectometerModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabCoverProtectometerService;

import java.util.List;

@Service(value = "labCoverProtectometerService")
public class LabCoverProtectometerService extends BaseService<LabCoverProtectometerModel> implements ILabCoverProtectometerService {
    @Autowired
    private LabCoverProtectometerMapper labCoverProtectometerMapper;

    public List<LabStatModel> listStatistics() {
        return labCoverProtectometerMapper.listStatistics();
    }
}
