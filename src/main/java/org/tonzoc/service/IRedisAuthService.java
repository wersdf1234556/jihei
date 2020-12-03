package org.tonzoc.service;

import org.tonzoc.model.UserModel;

public interface IRedisAuthService {
    UserModel getCurrentUser() throws Exception;

    void logout() throws Exception;

    void logout(String username) throws Exception;
}
