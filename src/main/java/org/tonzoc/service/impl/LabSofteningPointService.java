package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabSofteningPointMapper;
import org.tonzoc.model.LabSofteningPointModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabSofteningPointService;

import java.util.List;

@Service(value = "labSofteningPointService")
public class LabSofteningPointService extends BaseService<LabSofteningPointModel> implements ILabSofteningPointService {
    @Autowired
    private LabSofteningPointMapper labSofteningPointMapper;

    public List<LabStatModel> listStatistics() {
        return labSofteningPointMapper.listStatistics();
    }
}
