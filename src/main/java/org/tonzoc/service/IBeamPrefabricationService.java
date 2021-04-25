package org.tonzoc.service;

import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.ReturnMachineModel;

import java.util.List;

public interface IBeamPrefabricationService extends IBaseService<BeamPrefabricationModel>{

    // 梁的数量信息
    List<ReturnModel> selectPrefabrication();

    // 删除一个梁
    void delete (String guid) throws Exception;

    // 批量删除梁
    void deletes (String guids) throws Exception;
}
