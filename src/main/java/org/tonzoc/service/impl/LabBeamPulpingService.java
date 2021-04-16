package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.LabBeamPulpingModel;
import org.tonzoc.model.LabBeamTensionModel;
import org.tonzoc.service.ILabBeamPulpingService;
import org.tonzoc.service.ILabBeamTensionService;

@Service(value = "labBeamPulpingService")
public class LabBeamPulpingService extends BaseService<LabBeamPulpingModel> implements ILabBeamPulpingService {

}
