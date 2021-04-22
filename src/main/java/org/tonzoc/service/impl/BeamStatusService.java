package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.BeamStatusModel;
import org.tonzoc.service.IBeamStatusService;

@Service("BeamStatusService")
public class BeamStatusService extends BaseService<BeamStatusModel> implements IBeamStatusService {
}
