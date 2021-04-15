package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamSecurityMapper;
import org.tonzoc.model.BeamSecurityModel;

@Service("BeamSecurityService")
public class BeamSecurityService extends BaseService<BeamSecurityModel>{

    @Autowired
    private BeamSecurityMapper beamSecurityMapper;
}
