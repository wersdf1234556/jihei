package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamMapper;
import org.tonzoc.model.BeamModel;

@Service
public class BeamService extends BaseService<BeamModel> {

    @Autowired
    private BeamMapper beamMapper;
}
