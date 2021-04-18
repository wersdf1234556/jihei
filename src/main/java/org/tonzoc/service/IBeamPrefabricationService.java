package org.tonzoc.service;

import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.ReturnMachineModel;

import java.util.List;

public interface IBeamPrefabricationService extends IBaseService<BeamPrefabricationModel>{

    // 梁的数量信息
    List<ReturnModel> selectPrefabrication();
}
