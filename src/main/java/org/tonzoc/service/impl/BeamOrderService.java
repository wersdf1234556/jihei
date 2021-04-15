package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamOrderMapper;
import org.tonzoc.model.BeamOrderModel;
import org.tonzoc.service.IBeamOrderService;

@Service
public class BeamOrderService extends BaseService<BeamOrderModel> implements IBeamOrderService {

    @Autowired
    private BeamOrderMapper beamOrderMapper;
}
