package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabUniversalCementMapper;
import org.tonzoc.model.LabUniversalCementModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabUniversalCementService;

import java.util.List;

@Service(value = "labUniversalCementService")
public class LabUniversalCementService extends BaseService<LabUniversalCementModel> implements ILabUniversalCementService {

    @Autowired
    private LabUniversalCementMapper labUniversalCementMapper;

    public List<LabStatModel> listStatistics() {
        return labUniversalCementMapper.listStatistics();
    }
}
