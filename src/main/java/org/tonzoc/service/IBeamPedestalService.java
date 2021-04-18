package org.tonzoc.service;

import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.support.ReturnListModel;

import java.util.List;

public interface IBeamPedestalService extends IBaseService<BeamPedestalModel>{

    // 按类别统计台座数量
    List<ReturnListModel> listByStatus();

}
