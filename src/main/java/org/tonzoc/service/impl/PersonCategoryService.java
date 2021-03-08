package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.PersonCategoryModel;
import org.tonzoc.service.IPersonCategoryService;

@Service(value = "personCategoryService")
public class PersonCategoryService extends BaseService<PersonCategoryModel> implements IPersonCategoryService {
}
