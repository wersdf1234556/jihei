package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamPedestalMapper;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.service.IBeamPedestalService;

@Service
public class BeamPedestalService extends BaseService<BeamPedestalModel> implements IBeamPedestalService {

    @Autowired
    private BeamPedestalMapper beamPedestalMapper;
}
