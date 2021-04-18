package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamPedestalMapper;
import org.tonzoc.model.BeamModel;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.support.ReturnListModel;
import org.tonzoc.service.IBeamPedestalService;

import java.util.List;

@Service
public class BeamPedestalService extends BaseService<BeamPedestalModel> implements IBeamPedestalService {

    @Autowired
    private BeamPedestalMapper beamPedestalMapper;

    // 按类别统计台座数量
    public List<ReturnListModel> listByStatus() {

        return beamPedestalMapper.listByStatus();
    }

}
