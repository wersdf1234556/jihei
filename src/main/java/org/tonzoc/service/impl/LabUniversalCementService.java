package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.LabUniversalCementModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabUniversalCementService;

import java.util.List;

@Service(value = "labUniversalCementService")
public class LabUniversalCementService extends BaseService<LabUniversalCementModel> implements ILabUniversalCementService {

    @Override
    public List<LabStatModel> listStatistics() {
        return null;
    }
}
