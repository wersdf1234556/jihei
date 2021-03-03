package org.tonzoc.service;


import org.tonzoc.model.PersonTypeModel;

import java.util.List;

public interface IPersonTypeService extends IBaseService<PersonTypeModel> {
    List<PersonTypeModel> listByFlag(Integer flag);

    List<PersonTypeModel> listWithLevel(String parentId) throws Exception;

    
}
