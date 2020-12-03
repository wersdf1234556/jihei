package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.RoleAuthorityModel;
import org.tonzoc.service.IRoleAuthorityService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service(value = "roleAuthorityService")
public class RoleAuthorityService extends BaseService<RoleAuthorityModel> implements IRoleAuthorityService {

    public List<RoleAuthorityModel> listByRole(String roleGuid) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("roleGuid", roleGuid, "eq"));

        List<RoleAuthorityModel> roleAuthorityModels = this.list(sqlQueryParams);

        return roleAuthorityModels;
    }

    public void deleteByRole(String roleGuid) {
        List<RoleAuthorityModel> roleAuthorityModels = listByRole(roleGuid);

        for (RoleAuthorityModel roleAuthorityModel : roleAuthorityModels) {
            remove(roleAuthorityModel.getGuid());
        }
    }

}
