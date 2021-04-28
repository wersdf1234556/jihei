package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.CameraMapper;
import org.tonzoc.mapper.LabBeamTensionMapper;
import org.tonzoc.model.CameraModel;
import org.tonzoc.model.LabBeamTensionModel;
import org.tonzoc.service.ICameraService;
import org.tonzoc.service.ILabBeamTensionService;

import java.util.List;

@Service(value = "labBeamTensionService")
public class LabBeamTensionService extends BaseService<LabBeamTensionModel> implements ILabBeamTensionService {

    @Autowired
    private LabBeamTensionMapper labBeamTensionMapper;

    @Override
    public List<LabBeamTensionModel> getGroupData(String componentParts, String startDate, String endDate) {
        return labBeamTensionMapper.getGroupData(componentParts, startDate, endDate);
    }
}
