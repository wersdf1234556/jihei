package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamPrefabricationMapper;
import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.service.IBeamPrefabricationService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("BeamPrefabricationService")
public class BeamPrefabricationService extends BaseService<BeamPrefabricationModel> implements IBeamPrefabricationService {

    @Autowired
    private BeamPrefabricationMapper beamPrefabricationMapper;

    // 梁的数量信息
    public List<ReturnModel> selectPrefabrication(){

        List<ReturnModel> list = new ArrayList<>();
        ReturnModel returnModel = new ReturnModel();
        returnModel.setName("梁总数量");
        returnModel.setNumber(beamPrefabricationMapper.count());

        ReturnModel returnModel1 = new ReturnModel();
        returnModel1.setName("已完成数");
        returnModel1.setNumber(beamPrefabricationMapper.selectByStatus("finish"));

        ReturnModel returnModel2 = new ReturnModel();
        returnModel2.setName("比例");
        if (returnModel.getNumber() == 0 || returnModel1.getNumber() == 0) {
            returnModel2.setProportion("0");
        } else {
            returnModel2.setProportion(new BigDecimal(returnModel1.getNumber()).divide(new BigDecimal(returnModel.getNumber()), 4, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());

        }

        list.add(returnModel);
        list.add(returnModel1);
        list.add(returnModel2);

        return list;
    }
}
