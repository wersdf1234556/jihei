package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tonzoc.common.FileHelper;
import org.tonzoc.mapper.BeamMapper;
import org.tonzoc.mapper.BeamOrderMapper;
import org.tonzoc.mapper.BeamPedestalMapper;
import org.tonzoc.mapper.BeamPersonMapper;
import org.tonzoc.model.*;
import org.tonzoc.model.support.ReturnBeamModel;
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
@Transactional
public class BeamService extends BaseService<BeamModel> implements IBeamService {

    @Autowired
    private BeamMapper beamMapper;

    @Autowired
    private BeamPedestalMapper beamPedestalMapper;

    @Autowired
    private BeamPersonMapper beamPersonMapper;

    @Autowired
    private IBeamPedestalService beamPedestalService;

    @Autowired
    private IBeamPrefabricationService beamPrefabricationService;

    @Autowired
    private IBeamOrderService beamOrderService;

    @Autowired
    private FileHelper fileHelper;

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("unSubmit", "rgba(255, 255, 255,0)");
        map.put("gjgj", "rgba(255, 168, 0,1)");
        map.put("hnt", "rgba(112, 194, 99,1)");
        map.put("ys", " rgba(93, 179, 251,1)");
        map.put("zl", "rgba(151, 111, 248,1)");
        map.put("yj", "rgba(151, 111, 248,1)");
        map.put("finish", "rgba(255, 255, 255,0)");
    }

    public void addTogether (BeamModel beamModel, String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception {
        BeamPedestalModel beamPedestalModel = beamPedestalService.get(beamModel.getBeamPedestalGuid());
        Integer countByBeamPedestal = beamMapper.selectByBeamPedestal(beamPedestalModel.getGuid());
        if (!"unSubmit".equals(beamPedestalModel.getStatus())) {

            throw new Exception("该台座不空闲");
        }

        BeamPrefabricationModel beamPrefabricationModel = beamPrefabricationService.get(beamModel.getBeamPrefabricationGuid());
        // Integer countByBeamPrefabrication = beamMapper.selectByBeamPrefabrication(beamPrefabricationModel.getGuid());
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

    public void updateTogether (BeamModel beamModel, String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception {

        BeamModel lodBeamModel = this.get(beamModel.getGuid());
        BeamPedestalModel beamPedestalModel = beamPedestalService.get(beamModel.getBeamPedestalGuid());
        // Integer countByBeamPedestal = beamMapper.selectByBeamPedestal(beamPedestalModel.getGuid());
        if (!"unSubmit".equals(beamPedestalModel.getStatus()) && !beamModel.getBeamPedestalGuid().equals(lodBeamModel.getBeamPedestalGuid())) {

            throw new Exception("该台座不空闲");
        } else {
            BeamPedestalModel lodBeamPedestalModel = beamPedestalService.get(lodBeamModel.getBeamPedestalGuid());
            BeamPedestalModel beamPedestalModel2 = new BeamPedestalModel();
            beamPedestalModel2.setGuid(beamModel.getBeamPedestalGuid());
            beamPedestalModel2.setStatus(lodBeamPedestalModel.getStatus());
            beamPedestalModel2.setColor(map.get(lodBeamPedestalModel.getStatus()));

            lodBeamPedestalModel.setStatus("unSubmit");
            lodBeamPedestalModel.setColor(map.get("unSubmit"));
            beamPedestalService.update(lodBeamPedestalModel);
            beamPedestalService.update(beamPedestalModel2);
        }

        BeamPrefabricationModel beamPrefabricationModel = beamPrefabricationService.get(beamModel.getBeamPrefabricationGuid());
        // Integer countByBeamPrefabrication = beamMapper.selectByBeamPrefabrication(beamPrefabricationModel.getGuid());
        if (!"unSubmit".equals(beamPrefabricationModel.getStatus()) && !beamModel.getBeamPrefabricationGuid().equals(lodBeamModel.getBeamPrefabricationGuid())) {

            throw new Exception("该梁已存在");
        } else {

            BeamPrefabricationModel lodBeamPrefabricationModel = beamPrefabricationService.get(lodBeamModel.getBeamPrefabricationGuid());
            BeamPrefabricationModel beamPrefabricationModel2 = new BeamPrefabricationModel();
            beamPrefabricationModel2.setGuid(beamModel.getBeamPrefabricationGuid());
            beamPrefabricationModel2.setStatus(lodBeamPrefabricationModel.getStatus());
            beamPrefabricationModel2.setColor(map.get(lodBeamPrefabricationModel.getStatus()));

            System.out.println("concreteStrengthOne" + concreteStrengthOne);
            if (concreteStrengthOne != null) {
                System.out.println(concreteStrengthOne + "");
                beamPrefabricationModel2.setConcreteStrengthOne(concreteStrengthOne);
                lodBeamPrefabricationModel.setConcreteStrengthOne("");

            }
            if (concreteStrengthTwo != null) {
                beamPrefabricationModel2.setConcreteStrengthTwo(concreteStrengthTwo);
                lodBeamPrefabricationModel.setConcreteStrengthTwo("");

            }
            if (concreteStrengthThree != null ) {
                beamPrefabricationModel2.setConcreteStrengthThree(concreteStrengthThree);
                lodBeamPrefabricationModel.setConcreteStrengthThree("");

            }
            if (remarks != null) {
                beamPrefabricationModel2.setRemarks(remarks);
                lodBeamPrefabricationModel.setRemarks("");

            }

            lodBeamPrefabricationModel.setStatus("unSubmit");
            lodBeamPrefabricationModel.setColor(map.get("unSubmit"));
            beamPrefabricationService.update(lodBeamPrefabricationModel);
            beamPrefabricationService.update(beamPrefabricationModel2);
        }
    }

    // 添加信息
    @Override
    public void add(BeamModel beamModel, String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception {

        String guid = fileHelper.newGUID();
        beamModel.setGuid(guid);
        this.addTogether(beamModel, concreteStrengthOne, concreteStrengthTwo, concreteStrengthThree, remarks);
        this.save(beamModel);

        BeamPedestalModel beamPedestalModel = new BeamPedestalModel();
        beamPedestalModel.setGuid(beamModel.getBeamPedestalGuid());
        beamPedestalModel.setStatus("gjgj");
        beamPedestalModel.setColor(map.get("gjgj"));
        beamPedestalService.update(beamPedestalModel);

        BeamPrefabricationModel beamPrefabricationModel = new BeamPrefabricationModel();
        beamPrefabricationModel.setGuid(beamModel.getBeamPrefabricationGuid());
        beamPrefabricationModel.setStatus("gjgj");
        beamPrefabricationModel.setColor(map.get("gjgj"));
        beamPrefabricationService.update(beamPrefabricationModel);

        BeamOrderModel beamOrderModel = new BeamOrderModel();
        beamOrderModel.setBeamGuid(beamModel.getGuid());
        beamOrderModel.setTenderGuid(beamModel.getTenderGuid());
        beamOrderModel.setOperator(beamModel.getOperator());
        beamOrderModel.setStatus("gjgj");
        beamOrderModel.setColor(map.get("gjgj"));
        beamOrderModel.setAttTime(beamModel.getAttTime());
        beamOrderModel.setSortId(beamModel.getSortId());
        beamOrderService.save(beamOrderModel);
    }

    //修改信息
    @Override
    public void modify(BeamModel beamModel, String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception {

        BeamModel beamModel1 = this.get(beamModel.getGuid());

        if (!beamModel1.getBeamPedestalGuid().equals(beamModel.getBeamPedestalGuid()) || !beamModel1.getBeamPrefabricationGuid().equals(beamModel.getBeamPrefabricationGuid())) {

            this.updateTogether(beamModel, concreteStrengthOne, concreteStrengthTwo, concreteStrengthThree, remarks);
        } else {

            BeamPrefabricationModel beamPrefabricationModel = beamPrefabricationService.get(beamModel.getBeamPrefabricationGuid());
            if (concreteStrengthOne != null) {

                beamPrefabricationModel.setConcreteStrengthOne(concreteStrengthOne);
            }
            if (concreteStrengthTwo != null) {

                beamPrefabricationModel.setConcreteStrengthTwo(concreteStrengthTwo);
            }
            if (concreteStrengthThree != null ) {

                beamPrefabricationModel.setConcreteStrengthThree(concreteStrengthThree);
            }
            if (remarks != null) {

                beamPrefabricationModel.setRemarks(remarks);
            }
            beamPrefabricationService.update(beamPrefabricationModel);
        }

        update(beamModel);
    }

    // 删除
    @Override
    public void delete(String guid) throws Exception {

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam( "beamGuid", guid, "eq"));
        List<BeamOrderModel> list = beamOrderService.list(sqlQueryParams);
        if (list.size() >= 2) {

            throw new Exception("该信息不可删除");
        } else if (list.size() == 1) {

            BeamModel beamModel = this.get(guid);
            BeamPedestalModel beamPedestalModel = new BeamPedestalModel();
            beamPedestalModel.setGuid(beamModel.getBeamPedestalGuid());
            beamPedestalModel.setStatus("unSubmit");
            beamPedestalModel.setColor(map.get("unSubmit"));
            beamPedestalService.update(beamPedestalModel);

            BeamPrefabricationModel beamPrefabricationModel = new BeamPrefabricationModel();
            beamPrefabricationModel.setGuid(beamModel.getBeamPrefabricationGuid());
            beamPrefabricationModel.setStatus("unSubmit");
            beamPrefabricationModel.setColor(map.get("unSubmit"));
            beamPrefabricationModel.setConcreteStrengthOne("");
            beamPrefabricationModel.setConcreteStrengthTwo("");
            beamPrefabricationModel.setConcreteStrengthThree("");
            beamPrefabricationModel.setRemarks("");
            beamPrefabricationService.update(beamPrefabricationModel);

            beamOrderService.remove(list.get(0).getGuid());
        }

        beamPersonMapper.remove(guid);
        this.remove(guid);
    }

    // 删除多条
    @Override
    public void deletes(String guids) throws Exception {

        String[] str = guids.split(",");
        for (String s : str) {

            this.delete(s);
        }
    }

    // 按照编号查询历史记录
    @Override
    public List<BeamModel> listHistory(String name, String num) {

        BeamPedestalModel beamPedestalModel = beamPedestalMapper.selectByNum(name, num);
        return beamMapper.listHistory(beamPedestalModel.getGuid());
    }

    // 查询一条或多条
    @Override
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

    // 查询名称加左右幅
    @Override
    public List<String> selectNameAndLeftAndRight(String tenderGuid) {

        return beamMapper.selectNameAndLeftAndRight(tenderGuid);
    }

    // 查询梁的编号
    @Override
    public List<BeamPrefabricationModel> selectPrefabricationNum(String nameAndLeftAndRight, String tenderGuid) {

        return beamMapper.selectPrefabricationNum(nameAndLeftAndRight, tenderGuid);
    }

    // 梁统计查询
    @Override
    public List<ReturnBeamCount> selectByTender(String tenderGuid, String name, String leftAndRight){

        return beamMapper.selectByTender(tenderGuid, name, leftAndRight);
    }

    // 筛选
    @Override
    public String screen(String tenderGuid, String num) throws Exception {
        List<BeamPedestalModel> list = beamMapper.numberByTender(tenderGuid, num);
        for (BeamPedestalModel li: list) {
            if ("1".equals(li.getPedestalNum())) {
                return "pedestalNum";

            }
            if ("1".equals(li.getModelNum())) {
                return "modelNum";

            }
            if ("1".equals(li.getTextNum())) {
                return "textNum";
            }
        }
        throw new Exception("点击位置不对，请重试");
    }

    // 按照编号查询历史记录 带分页
    @Override
    public List<ReturnBeamModel> listHistoryPage(String name, String num, String beamPrefabricationName, String leftAndRight) {

        return beamMapper.listHistoryPage(name, num, beamPrefabricationName, leftAndRight);
    }
}
