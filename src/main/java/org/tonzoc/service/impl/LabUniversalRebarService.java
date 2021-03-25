package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabUniversalRebarMapper;
import org.tonzoc.model.LabUniversalRebarModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabUniversalRebarService;

import java.util.List;

@Service(value = "labUniversalRebarService")
public class LabUniversalRebarService extends BaseService<LabUniversalRebarModel> implements ILabUniversalRebarService {

    @Autowired
    private LabUniversalRebarMapper labUniversalRebarMapper;

    public List<LabStatModel> listStatistics() {
        return labUniversalRebarMapper.listStatistics();
    }
}
