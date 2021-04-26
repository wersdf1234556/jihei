package org.tonzoc.service;

import org.tonzoc.model.BeamPersonGroupModel;

public interface IBeamPersonGroupService extends IBaseService<BeamPersonGroupModel>{

    // 添加
    void add(BeamPersonGroupModel beamPersonGroupModel);

    // 删除
    void delete(String guid);

    // 批量删除
    void deletes(String guids);
}
