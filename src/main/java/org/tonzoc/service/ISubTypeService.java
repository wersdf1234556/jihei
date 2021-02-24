package org.tonzoc.service;

import org.tonzoc.model.SubTypeModel;

public interface ISubTypeService extends IBaseService<SubTypeModel> {

    // 是否包含
    Boolean contain(String name);
}
