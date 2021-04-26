package org.tonzoc.service;

import org.tonzoc.model.BeamGroupModel;

public interface IBeamGroupService extends IBaseService<BeamGroupModel>{

    // 删除
    public void delete(String guid) throws Exception;
}
