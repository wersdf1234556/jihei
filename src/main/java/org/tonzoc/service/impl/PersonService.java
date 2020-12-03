package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.PersonModel;
import org.tonzoc.service.IPersonService;

@Service("personService")
public class PersonService extends BaseService<PersonModel> implements IPersonService {

}
