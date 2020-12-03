package org.tonzoc.service;

import org.tonzoc.model.AuthorityModel;

import java.util.List;

public interface IAuthorityService extends IBaseService<AuthorityModel> {
    List<AuthorityModel> listByUser(String userGuid);

    List<AuthorityModel> listDefault();

    List<AuthorityModel> listWithLevel(String userGuid) throws Exception;
}
