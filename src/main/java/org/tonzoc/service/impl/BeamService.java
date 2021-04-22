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

import java.util.List;

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

    public void together (BeamModel beamModel, String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception {
        BeamPedestalModel beamPedestalModel = beamPedestalService.get(beamModel.getBeamPedestalGuid());
        Integer countByBeamPedestal = beamMapper.selectByBeamPedestal(beamPedestalModel.getGuid());
        if (!"unSubmit".equals(beamPedestalModel.getStatus())) {

            throw new Exception("该台座不空闲");
        }

        BeamPrefabricationModel beamPrefabricationModel = beamPrefabricationService.get(beamModel.getBeamPrefabricationGuid());
        Integer countByBeamPrefabrication = beamMapper.selectByBeamPrefabrication(beamPrefabricationModel.getGuid());
        if (!"unSubmit".equals(beamPrefabricationModel.getStatus())) {

            throw new Exception("该梁已存在");
        }

        BeamPrefabricationModel beamPrefabricationModel1 = new BeamPrefabricationModel();
        beamPrefabricationModel1.setGuid(beamModel.getBeamPrefabricationGuid());
        beamPrefabricationModel1.setSpan("");
        if (concreteStrengthOne != null) {
            beamPrefabricationModel1.setConcreteStrengthOne(concreteStrengthOne);

        }
        if (concreteStrengthTwo != null) {
            beamPrefabricationModel1.setConcreteStrengthTwo(concreteStrengthTwo);

        }
        if (concreteStrengthThree != null ) {
            beamPrefabricationModel1.setConcreteStrengthThree(concreteStrengthThree);

        }
        if (remarks != null) {
            beamPrefabricationModel1.setRemarks(remarks);

        }
        beamPrefabricationService.update(beamPrefabricationModel1);
    }

    // 添加信息
    public void add(BeamModel beamModel, String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception {

        this.together(beamModel, concreteStrengthOne, concreteStrengthTwo, concreteStrengthThree, remarks);
        this.save(beamModel);
    }

    //修改信息
    public void modify(BeamModel beamModel, String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception {

        this.together(beamModel, concreteStrengthOne, concreteStrengthTwo, concreteStrengthThree, remarks);
        update(beamModel);
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
