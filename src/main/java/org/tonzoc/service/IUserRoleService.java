package org.tonzoc.service;

import org.tonzoc.model.UserRoleModel;

import java.util.List;

public interface IUserRoleService extends IBaseService<UserRoleModel> {
    List<UserRoleModel> listByUser(String userGuid);

    void deleteByUser(String userGuid);
}
