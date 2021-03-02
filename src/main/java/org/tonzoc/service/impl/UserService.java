package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IUserService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserService extends BaseService<UserModel> implements IUserService {

    public List<UserModel> listByUser(String guid){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("guid", guid, "eq"));
        List<UserModel> userModels = this.list(sqlQueryParams);
        return userModels;
    }

    public UserModel getByName(String name) throws NotOneResultFoundException {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("name", name, "eq"));

        List<UserModel> userModels = this.list(sqlQueryParams);

        if (userModels.size() != 1) {
            throw new NotOneResultFoundException(name);
        }

        return userModels.get(0);
    }

    public void insertStack(UserModel userModel){
        if (userModel.getTenderGuid()==null){
            userModel.setTenderGuid("");
        }
        save(userModel);
    }
    public void updateStack(UserModel userModel){
        if (userModel.getTenderGuid()==null){
            userModel.setTenderGuid("");
        }
        update(userModel);
    }
}
