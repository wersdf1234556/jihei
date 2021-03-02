package org.tonzoc.service;

import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.model.UserModel;

import java.util.List;

public interface IUserService extends IBaseService<UserModel> {
    List<UserModel> listByUser(String guid);

    UserModel getByName(String name) throws NotOneResultFoundException;
    void insertStack(UserModel userModel);
    void updateStack(UserModel userModel);
}
