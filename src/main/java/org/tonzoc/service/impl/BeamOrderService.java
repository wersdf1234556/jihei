package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamOrderMapper;
import org.tonzoc.model.BeamModel;
import org.tonzoc.model.BeamOrderModel;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.service.IBeamOrderService;
import org.tonzoc.service.IBeamPedestalService;
import org.tonzoc.service.IBeamPrefabricationService;
import org.tonzoc.service.IBeamService;

import java.util.HashMap;
import java.util.Map;

@Service
public class BeamOrderService extends BaseService<BeamOrderModel> implements IBeamOrderService {

    @Autowired
    private BeamOrderMapper beamOrderMapper;

    @Autowired
    private IBeamPedestalService beamPedestalService;

    @Autowired
    private IBeamPrefabricationService beamPrefabricationService;

    @Autowired
    private IBeamService beamService;

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("unSubmit", "rgba(255, 255, 255,0)");
        map.put("gjgj", "rgba(255, 168, 0,1)");
        map.put("hnt", "rgba(112, 194, 99,1)");
        map.put("ys", " rgba(93, 179, 251,1)");
        map.put("zlyj", "rgba(151, 111, 248,1)");
        map.put("finish", "rgba(255, 255, 255,0)");
    }

    @Override
    public void add (BeamOrderModel beamOrderModel) {

        BeamModel beamModel = beamService.get(beamOrderModel.getBeamGuid());

        BeamPedestalModel beamPedestalModel = new BeamPedestalModel();
        beamPedestalModel.setGuid(beamModel.getBeamPedestalGuid());
        beamPedestalModel.setStatus(beamOrderModel.getStatus());
        beamPedestalModel.setColor(map.get(beamModel.getStatus()));
        beamPedestalService.update(beamPedestalModel);

        BeamPrefabricationModel beamPrefabricationModel = new BeamPrefabricationModel();
        beamPrefabricationModel.setGuid(beamModel.getBeamPrefabricationGuid());
        beamPrefabricationModel.setStatus(beamModel.getStatus());
        beamPrefabricationModel.setColor(map.get(beamModel.getStatus()));
        beamPrefabricationService.update(beamPrefabricationModel);

        this.save(beamOrderModel);
    }
}
