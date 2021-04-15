package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamPersonMapper;
import org.tonzoc.model.BeamPersonModel;

@Service("BeamPersonService")
public class BeamPersonService extends BaseService<BeamPersonModel>{

    @Autowired
    private BeamPersonMapper beamPersonMapper;
}
