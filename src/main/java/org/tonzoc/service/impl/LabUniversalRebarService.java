package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.LabUniversalRebarModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabUniversalRebarService;

import java.util.List;

@Service(value = "labUniversalRebarService")
public class LabUniversalRebarService extends BaseService<LabUniversalRebarModel> implements ILabUniversalRebarService {

    @Override
    public List<LabStatModel> listStatistics() {
        return null;
    }
}
