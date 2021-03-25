package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabPmsCbrMapper;
import org.tonzoc.model.LabPmsCbrModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabPmsCbrService;

import java.util.List;

@Service(value = "labPmsCbrService")
public class LabPmsCbrService extends BaseService<LabPmsCbrModel> implements ILabPmsCbrService {
    @Autowired
    private LabPmsCbrMapper labPmsCbrMapper;

    public List<LabStatModel> listStatistics() {
        return labPmsCbrMapper.listStatistics();
    }
}
