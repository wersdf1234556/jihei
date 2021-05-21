package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.LabBeamPulpingMapper;
import org.tonzoc.model.LabBeamPulpingModel;
import org.tonzoc.service.ILabBeamPulpingService;

import java.util.List;

@Service(value = "labBeamPulpingService")
public class LabBeamPulpingService extends BaseService<LabBeamPulpingModel> implements ILabBeamPulpingService {
    @Autowired
    private LabBeamPulpingMapper labBeamPulpingMapper;

    @Override
    public List<LabBeamPulpingModel> getGroupData(String componentParts, String startDate, String endDate, String tenderGuid) {
        return labBeamPulpingMapper.getGroupData(componentParts, startDate, endDate, tenderGuid);
    }
}
