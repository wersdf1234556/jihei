package org.tonzoc.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.common.ApprovalHelper;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.model.TenderModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.ITenderService;
import org.tonzoc.service.IUserService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserService extends BaseService<UserModel> implements IUserService {
    @Autowired
    private ITenderService tenderService;
    @Autowired
    private IRedisAuthService redisAuthService;

    @Autowired
    private ApprovalHelper approvalHelper;

    public List<UserModel> listByUser(String guid){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("guid", guid, "eq"));
        List<UserModel> userModels = this.list(sqlQueryParams);
        return userModels;
    }
    public List<UserModel> listByTenderGuid(String tenderGuid){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("tenderGuid", tenderGuid, "eq"));
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
        if (userModel.getProjectGuid()==null){
            userModel.setProjectGuid("");
        }
        save(userModel);
    }
    public void updateStack(UserModel userModel){
        if (userModel.getTenderGuid()==null){
            userModel.setTenderGuid("");
        }
        update(userModel);
    }

    public List<TenderModel> listTendersByUserId(String userGuid) throws Exception{
        if (userGuid==null||userGuid.isEmpty()){
            userGuid=redisAuthService.getCurrentUser().getGuid();
        }
        UserModel userModel = get(userGuid);
        String tenderManage = userModel.getTenderManage();
        List<String> result = Arrays.asList(StringUtils.split(tenderManage,","));
        List<TenderModel> tenderModels = new ArrayList<>();
        for (String tenderGuid:result){
            tenderModels.add(tenderService.get(tenderGuid));
        }
        return tenderModels;
    }

    // 查询上一级
    public String getNextSupervisor(String tenderGuid, String accounType){

       return approvalHelper.getNextSupervisor(tenderGuid, accounType);
    }
}
