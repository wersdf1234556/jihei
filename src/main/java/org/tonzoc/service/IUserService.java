package org.tonzoc.service;

import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.model.UserModel;

public interface IUserService extends IBaseService<UserModel> {

    UserModel getByName(String name) throws NotOneResultFoundException;
}
