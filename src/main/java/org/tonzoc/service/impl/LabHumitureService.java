package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabHumitureMapper;
import org.tonzoc.model.LabHumitureModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabHumitureService;

import java.util.List;

@Service(value = "labHumitureService")
public class LabHumitureService extends BaseService<LabHumitureModel> implements ILabHumitureService {
    @Autowired
    private LabHumitureMapper labHumitureMapper;

    public List<LabStatModel> listStatistics() {
        return labHumitureMapper.listStatistics();
    }
}
