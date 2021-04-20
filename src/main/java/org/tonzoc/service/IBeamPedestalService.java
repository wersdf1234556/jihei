package org.tonzoc.service;

import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.ReturnListModel;
import org.tonzoc.model.support.ReturnQtbModel;

import java.util.List;

public interface IBeamPedestalService extends IBaseService<BeamPedestalModel>{

    // 按类别统计台座数量和梁的数量
    List<ReturnQtbModel> listByStatus();

}
