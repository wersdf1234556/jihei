package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tonzoc.mapper.BeamMapper;
import org.tonzoc.mapper.BeamPedestalMapper;
import org.tonzoc.model.*;
import org.tonzoc.service.IBeamOrderService;
import org.tonzoc.service.IBeamPedestalService;
import org.tonzoc.service.IBeamPrefabricationService;
import org.tonzoc.service.IBeamService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BeamService extends BaseService<BeamModel> implements IBeamService {

    @Autowired
    private BeamMapper beamMapper;

    @Autowired
    private BeamPedestalMapper beamPedestalMapper;

    @Autowired
    private IBeamPedestalService beamPedestalService;

    @Autowired
    private IBeamPrefabricationService beamPrefabricationService;

    @Autowired
    private IBeamOrderService beamOrderService;

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("unSubmit", "rgba(255, 255, 255,0)");
        map.put("gjgj", "rgba(255, 168, 0,1)");
        map.put("hnt", "rgba(112, 194, 99,1)");
        map.put("ys", " rgba(93, 179, 251,1)");
        map.put("zlyj", "rgba(151, 111, 248,1)");
        map.put("finish", "rgba(255, 255, 255,0)");
    }

    // 添加信息
    public void add(BeamModel beamModel) throws Exception {

        BeamPedestalModel beamPedestalModel = beamPedestalService.get(beamModel.getBeamPedestalGuid());
        Integer countByBeamPedestal = beamMapper.selectByBeamPedestal(beamPedestalModel.getGuid());
        if (!"unSubmit".equals(beamPedestalModel.getStatus()) || countByBeamPedestal >= 1) {

            throw new Exception("该台座不空闲");
        }

        BeamPrefabricationModel beamPrefabricationModel = beamPrefabricationService.get(beamModel.getBeamPrefabricationGuid());
        Integer countByBeamPrefabrication = beamMapper.selectByBeamPrefabrication(beamPrefabricationModel.getGuid());
        if (!"unSubmit".equals(beamPrefabricationModel.getStatus()) || countByBeamPrefabrication >= 1) {

            throw new Exception("该梁已存在");
        }

        this.save(beamModel);
    }

    //修改信息
    public void modify(BeamModel beamModel, String remarks) throws Exception {

        BeamModel beamModel1 = this.get(beamModel.getGuid());
        BeamPrefabricationModel beamPrefabricationModel1 = beamPrefabricationService.get(beamModel1.getBeamPrefabricationGuid());

        if (beamModel.getStatus().equals(beamPrefabricationModel1.getStatus())) {
            throw new Exception("该工序不需要重复修改");

        }

        BeamOrderModel beamOrderModel = new BeamOrderModel();
        beamOrderModel.setBeamGuid(beamModel1.getGuid());
        beamOrderModel.setAttTime(beamModel1.getAttTime());
        beamOrderModel.setOperator(beamModel.getOperator());
        beamOrderModel.setTenderGuid(beamModel.getTenderGuid());
        beamOrderModel.setStatus(beamPrefabricationModel1.getStatus());
        beamOrderModel.setColor(map.get(beamPrefabricationModel1.getStatus()));
        beamOrderService.save(beamOrderModel);

        BeamPedestalModel beamPedestalModel1 = new BeamPedestalModel();
        beamPedestalModel1.setGuid(beamModel1.getBeamPedestalGuid());
        beamPedestalModel1.setStatus(beamModel.getStatus());
        beamPedestalModel1.setColor(map.get(beamModel.getStatus()));
        beamPedestalService.update(beamPedestalModel1);

        BeamPrefabricationModel beamPrefabricationModel = new BeamPrefabricationModel();
        beamPrefabricationModel.setGuid(beamModel1.getBeamPrefabricationGuid());
        beamPrefabricationModel.setStatus(beamModel.getStatus());
        beamPrefabricationModel.setColor(map.get(beamModel.getStatus()));
        beamPrefabricationModel.setRemarks(remarks);
        beamPrefabricationService.update(beamPrefabricationModel);

        if ("finish".equals(beamModel.getStatus())) {
            BeamOrderModel beamOrderModel1 = new BeamOrderModel();
            beamOrderModel1.setBeamGuid(beamModel.getGuid());
            beamOrderModel1.setStatus("finish");
            beamOrderModel1.setColor(map.get("finish"));
            beamOrderModel1.setAttTime(beamModel.getAttTime());
            beamOrderModel1.setOperator(beamModel.getOperator());
            beamOrderModel1.setTenderGuid(beamModel.getTenderGuid());
            beamOrderService.save(beamOrderModel1);

            beamPedestalModel1.setStatus("unSubmit");
            beamPedestalModel1.setColor(map.get("unSubmit"));
            beamPedestalService.update(beamPedestalModel1);

        } else {
            this.update(beamModel);

        }
    }

    // 删除
    public void delete(String guid) throws Exception {

        BeamModel beamModel = this.get(guid);
        BeamPrefabricationModel beamPrefabricationModel = beamPrefabricationService.get(beamModel.getBeamPrefabricationGuid());
        if ("unSubmit".equals(beamPrefabricationModel.getStatus())) {
            this.remove(guid);

        } else {
            throw new Exception("该信息不可删除");

        }
    }

    // 删除多条
    public void deletes(String guids) throws Exception {

        String[] str = guids.split(",");
        for (String s : str) {

            this.delete(s);
        }
    }

    // 按照编号查询历史记录
    public List<BeamModel> listHistory(String name, String num) {

        BeamPedestalModel beamPedestalModel = beamPedestalMapper.selectByNum(name, num);
        return beamMapper.listHistory(beamPedestalModel.getGuid());
    }

    // 查询一条或多条
    public List selectOneOrAll(String tenderGuid, String num) throws Exception {

        Integer countTender = beamMapper.countByTender(tenderGuid);
        if (countTender == 0) {
            throw new Exception("请先添加台座");

        }

        List<BeamPedestalModel> list = beamMapper.numberByTender(tenderGuid, num);
        for (BeamPedestalModel li: list) {
            if ("1".equals(li.getPedestalNum())) {
                return this.listHistory("pedestalNum", num);

            }
            if ("1".equals(li.getModelNum())) {
                return beamMapper.selectByNum(num);

            }
            if ("1".equals(li.getTextNum())) {
                return this.listHistory("textNum", num);

            }
        }

        throw new Exception("点击位置不对，请重试");
    }
}
