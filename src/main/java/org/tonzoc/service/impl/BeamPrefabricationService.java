package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.tonzoc.mapper.BeamPrefabricationMapper;
import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.service.IBeamPrefabricationService;

public class BeamPrefabricationService extends BaseService<BeamPrefabricationModel> implements IBeamPrefabricationService {

    @Autowired
    private BeamPrefabricationMapper beamPrefabricationMapper;
}
