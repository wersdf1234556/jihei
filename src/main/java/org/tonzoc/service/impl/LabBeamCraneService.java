package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.LabBeamCraneModel;
import org.tonzoc.model.LabBeamTensionModel;
import org.tonzoc.service.ILabBeamCraneService;
import org.tonzoc.service.ILabBeamTensionService;

@Service(value = "labBeamCraneService")
public class LabBeamCraneService extends BaseService<LabBeamCraneModel> implements ILabBeamCraneService {

}
