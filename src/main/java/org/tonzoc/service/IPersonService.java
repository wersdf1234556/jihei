package org.tonzoc.service;

import org.tonzoc.model.PersonModel;

import java.util.List;

public interface IPersonService extends IBaseService<PersonModel> {
    List<PersonModel> listByTenderName(String tenderName);

    PersonModel login(String sign,String password) throws Exception;

    void insertStack(PersonModel personModel) throws Exception;
    void updateStack(PersonModel personModel) throws Exception;
}
