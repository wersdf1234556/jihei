package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BeamMapper;
import org.tonzoc.mapper.BeamPedestalMapper;
import org.tonzoc.mapper.BeamPrefabricationMapper;
import org.tonzoc.model.BeamModel;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.ReturnQtbModel;
import org.tonzoc.service.IBeamPedestalService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeamPedestalService extends BaseService<BeamPedestalModel> implements IBeamPedestalService {

    @Autowired
    private BeamPedestalMapper beamPedestalMapper;

    @Autowired
    private BeamPrefabricationMapper beamPrefabricationMapper;

    @Autowired
    private BeamMapper beamMapper;

    // 按类别统计台座数量和梁的数量
    public List<ReturnQtbModel> listByStatus(String tenderGuid) {

        List<ReturnQtbModel> list1 = new ArrayList<>();
        ReturnQtbModel returnQtbModel = new ReturnQtbModel();
        returnQtbModel.setName("0");
        returnQtbModel.setYuan("0");
        returnQtbModel.setBan("0");
        returnQtbModel.setShi("0");
        returnQtbModel.setXian("0");
        returnQtbModel.setYin("0");
        List<ReturnModel> list = beamPedestalMapper.listByStatus(tenderGuid);
        for (ReturnModel li : list) {
            if ("unSubmit".equals(li.getName())) {
                returnQtbModel.setYuan(li.getNumber() + "");

            } else if ("gjgj".equals(li.getName())) {
                returnQtbModel.setBan(li.getNumber() + "");

            } else if ("hnt".equals(li.getName())) {
                returnQtbModel.setShi(li.getNumber() + "");

            } else if ("ys".equals(li.getName())) {
                returnQtbModel.setXian(li.getNumber() + "");

            } else if ("zl".equals(li.getName())) {
                returnQtbModel.setYin(li.getNumber() + "");

            } else if ("yj".equals(li.getName())) {
                returnQtbModel.setName(li.getNumber() + "");
            }
        }
        list1.add(returnQtbModel);

        ReturnQtbModel returnQtbModel1 = new ReturnQtbModel();
        returnQtbModel1.setName("梁");
        returnQtbModel1.setYuan(beamPrefabricationMapper.count(tenderGuid) + "");
        returnQtbModel1.setBan(beamPrefabricationMapper.selectByStatus("finish", tenderGuid) + "");
        if ("0".equals(returnQtbModel1.getYuan()) || "0".equals(returnQtbModel1.getBan())) {
            returnQtbModel1.setShi("0");

        } else {
            returnQtbModel1.setShi(new BigDecimal(returnQtbModel1.getBan()).divide(new BigDecimal(returnQtbModel1.getYuan()), 4, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());

        }

        list1.add(returnQtbModel1);

        return list1;
    }

    // 删除一个台座
    @Override
    public void delete (String guid) throws Exception{

        List<BeamModel> list = beamMapper.listByBeamPedestal(guid);
        if (list.size() > 0) {

            throw new Exception("该台座被使用过，不能删除");
        }

        this.remove(guid);
    }

    // 批量删除台座
    @Override
    public void deletes (String guids) throws Exception {

        String[] str = guids.split(",");
        for (String s: str) {

            this.delete(s);
        }
    }
}
