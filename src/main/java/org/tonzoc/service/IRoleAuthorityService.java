package org.tonzoc.service;

import org.tonzoc.model.RoleAuthorityModel;

import java.util.List;

public interface IRoleAuthorityService extends IBaseService<RoleAuthorityModel> {
    List<RoleAuthorityModel> listByRole(String roleGuid);

    void deleteByRole(String roleGuid);
}
