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
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        map.put("zl", "rgba(151, 111, 248,1)");
        map.put("yj", "rgba(255, 255, 0,0)");
        map.put("finish", "rgba(255, 255, 255,0)");
    }

    @Override
    public void add(BeamOrderModel beamOrderModel) {
        beamOrderModel.setColor(map.get(beamOrderModel.getStatus()));

        BeamModel beamModel = beamService.get(beamOrderModel.getBeamGuid());

        BeamPedestalModel beamPedestalModel = new BeamPedestalModel();
        beamPedestalModel.setGuid(beamModel.getBeamPedestalGuid());
        if ("finish".equals(beamOrderModel.getStatus())) {
            beamPedestalModel.setStatus("unSubmit");
            beamPedestalModel.setColor(map.get("unSubmit"));

        } else {
            beamPedestalModel.setStatus(beamOrderModel.getStatus());
            beamPedestalModel.setColor(map.get(beamOrderModel.getStatus()));

        }
        beamPedestalService.update(beamPedestalModel);

        BeamPrefabricationModel beamPrefabricationModel = new BeamPrefabricationModel();
        beamPrefabricationModel.setGuid(beamModel.getBeamPrefabricationGuid());
        beamPrefabricationModel.setStatus(beamOrderModel.getStatus());
        beamPrefabricationModel.setColor(map.get(beamOrderModel.getStatus()));
        beamPrefabricationService.update(beamPrefabricationModel);

        this.save(beamOrderModel);
    }


    @Override
    public void delete(String guid) {

        BeamOrderModel beamOrderModel = this.get(guid);
        System.out.println("beamOrderModel" + beamOrderModel.getCreatedAt());
        BeamModel beamModel = beamService.get(beamOrderModel.getBeamGuid());

        List<SqlQueryParam> sqlQueryParam = new ArrayList<>();
        sqlQueryParam.add(new SqlQueryParam("beamGuid", beamOrderModel.getBeamGuid(), "eq"));
        List<BeamOrderModel> list = list(sqlQueryParam);

        BeamOrderModel beamOrderModel1 = beamOrderMapper.selectByTimeDesc(beamOrderModel.getBeamGuid(), beamOrderModel.getCreatedAt());
        BeamPedestalModel beamPedestalModel = new BeamPedestalModel();
        beamPedestalModel.setGuid(beamModel.getBeamPedestalGuid());

        BeamPrefabricationModel beamPrefabricationModel = new BeamPrefabricationModel();
        beamPrefabricationModel.setGuid(beamModel.getBeamPrefabricationGuid());
        if (list.size() > 1) {

            beamPedestalModel.setStatus(beamOrderModel1.getStatus());
            beamPedestalModel.setColor(beamOrderModel1.getColor());

            beamPrefabricationModel.setStatus(beamOrderModel1.getStatus());
            beamPrefabricationModel.setColor(beamOrderModel1.getColor());

        } else {

            beamPedestalModel.setStatus("unSubmit");
            beamPedestalModel.setColor(map.get("unSubmit"));

            beamPrefabricationModel.setStatus("unSubmit");
            beamPrefabricationModel.setConcreteStrengthOne("");
            beamPrefabricationModel.setConcreteStrengthTwo("");
            beamPrefabricationModel.setConcreteStrengthThree("");
            beamPrefabricationModel.setRemarks("");
            beamPrefabricationModel.setColor(map.get("unSubmit"));

            beamService.remove(beamModel.getGuid());
        }

        beamPedestalService.update(beamPedestalModel);
        beamPrefabricationService.update(beamPrefabricationModel);
        this.remove(guid);
    }
}
