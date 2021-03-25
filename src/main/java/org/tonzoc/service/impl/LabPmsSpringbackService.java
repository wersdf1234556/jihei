package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabPmsSpringbackMapper;
import org.tonzoc.model.LabPmsSpringbackModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabPmsSpringbackService;

import java.util.List;

@Service(value = "labPmsSpringbackService")
public class LabPmsSpringbackService extends BaseService<LabPmsSpringbackModel> implements ILabPmsSpringbackService {
    @Autowired
    private LabPmsSpringbackMapper labPmsSpringbackMapper;

    public List<LabStatModel> listStatistics() {
        return labPmsSpringbackMapper.listStatistics();
    }
}
