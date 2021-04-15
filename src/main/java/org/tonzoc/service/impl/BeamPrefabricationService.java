package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamPrefabricationMapper;
import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.service.IBeamPrefabricationService;

@Service("BeamPrefabricationService")
public class BeamPrefabricationService extends BaseService<BeamPrefabricationModel> implements IBeamPrefabricationService {

    @Autowired
    private BeamPrefabricationMapper beamPrefabricationMapper;
}
