package org.tonzoc.service;

import org.tonzoc.model.BeamModel;
import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.model.ReturnBeamCount;

import java.util.List;

public interface IBeamService extends IBaseService<BeamModel> {

    // 添加信息
    void add(BeamModel beamModel, String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception;

    // 修改信息
    void modify(BeamModel beamModel, String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception;

    // 删除
    void delete(String guid) throws Exception;

    // 删除多条
    void deletes(String guids) throws Exception;

    // 按照编号查询历史记录
    List<BeamModel> listHistory(String name, String num);

    // 查询一条或多条
    List selectOneOrAll(String tenderGuid, String num) throws Exception;

    // 查询名称加左右幅
    List<String> selectNameAndLeftAndRight(String tenderGuid);

    // 查询梁的编号
    List<BeamPrefabricationModel> selectPrefabricationNum(String nameAndLeftAndRight, String tenderGuid);

    // 梁统计查询
    List<ReturnBeamCount> selectByTender(String tenderGuid, String name, String leftAndRight);
}
