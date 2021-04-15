package org.tonzoc.service;


import org.tonzoc.model.PersonTypeModel;

import java.util.List;

public interface IPersonTypeService extends IBaseService<PersonTypeModel> {

    List<PersonTypeModel> listByCategoryGuid(String categoryGuid);

    // 按照类型查询数量
    List<PersonTypeModel> selectByCategory(String personCategoryGuid, String tenderGuid);
}
