package org.tonzoc.service;

import org.tonzoc.model.BeamPersonModel;

public interface IBeamPersonService extends IBaseService<BeamPersonModel>{

    // 添加人员
    void add(BeamPersonModel beamPersonModel);
}
