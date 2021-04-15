package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamPersonMapper;
import org.tonzoc.model.BeamPersonModel;
import org.tonzoc.service.IBeamPersonService;

@Service("BeamPersonService")
public class BeamPersonService extends BaseService<BeamPersonModel> implements IBeamPersonService {

    @Autowired
    private BeamPersonMapper beamPersonMapper;
}
