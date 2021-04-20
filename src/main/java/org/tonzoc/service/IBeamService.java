package org.tonzoc.service;

import org.tonzoc.model.BeamModel;

import java.util.List;

public interface IBeamService extends IBaseService<BeamModel> {

    // 添加信息
    void add(BeamModel beamModel) throws Exception;

    // 修改信息
    void modify(BeamModel beamModel, String remarks) throws Exception;

    // 删除
    void delete(String guid) throws Exception;

    // 删除多条
    void deletes(String guids) throws Exception;

    // 按照编号查询历史记录
    List<BeamModel> listHistory(String name, String num);

    // 查询一条或多条
    List selectOneOrAll(String tenderGuid, String num) throws Exception;
}
