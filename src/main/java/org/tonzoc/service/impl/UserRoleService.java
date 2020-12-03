package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.UserRoleModel;
import org.tonzoc.service.IUserRoleService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userRoleService")
public class UserRoleService extends BaseService<UserRoleModel> implements IUserRoleService {

    public List<UserRoleModel> listByUser(String userGuid) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("userGuid", userGuid, "eq"));

        List<UserRoleModel> userRoleModels = this.list(sqlQueryParams);

        return userRoleModels;
    }

    public void deleteByUser(String userGuid) {
        List<UserRoleModel> userRoleModels = listByUser(userGuid);

        for (UserRoleModel userRoleModel : userRoleModels) {
            remove(userRoleModel.getGuid());
        }
    }

}
