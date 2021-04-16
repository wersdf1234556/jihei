package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.CameraMapper;
import org.tonzoc.model.CameraModel;
import org.tonzoc.model.LabBeamTensionModel;
import org.tonzoc.service.ICameraService;
import org.tonzoc.service.ILabBeamTensionService;

@Service(value = "labBeamTensionService")
public class LabBeamTensionService extends BaseService<LabBeamTensionModel> implements ILabBeamTensionService {

}
