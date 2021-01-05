package org.tonzoc.service;

import org.tonzoc.model.PersonModel;

public interface IPersonService extends IBaseService<PersonModel> {

    PersonModel login(String sign,String password) throws Exception;

    void insertStack(PersonModel personModel) throws Exception;
    void updateStack(PersonModel personModel) throws Exception;
}
