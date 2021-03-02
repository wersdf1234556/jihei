package org.tonzoc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.tonzoc.model.AuthorityModel;
import org.tonzoc.model.RoleAuthorityModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IAuthorityService;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.IRoleAuthorityService;
import org.tonzoc.service.IUserService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.*;
import java.util.stream.Collectors;

@Service(value = "authorityService")
public class AuthorityService extends BaseService<AuthorityModel> implements IAuthorityService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleAuthorityService roleAuthorityService;
    @Autowired
    private IRedisAuthService redisAuthService;

    @Cacheable(value = "list_by_user", key = "#userGuid")
    public List<AuthorityModel> listByUser(String userGuid) {

        // TODO 完成该功能
        // 获取用户角色
        List<UserModel> userModels = userService.listByUser(userGuid);

        // 获取用户所有的权限
        List<AuthorityModel> authorityModels = new ArrayList<>();

        for (UserModel userModel : userModels) {
            // 获取当前role对应的权限
            List<RoleAuthorityModel> roleAuthorityModels = roleAuthorityService.listByRole(userModel.getRoleGuid());

            for (RoleAuthorityModel roleAuthorityModel : roleAuthorityModels) {
                authorityModels.add(get(roleAuthorityModel.getAuthorityGuid()));
            }
        }

        return authorityModels;
    }

    @Cacheable(value = "list_default")
    public List<AuthorityModel> listDefault() {

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

        sqlQueryParams.add(new SqlQueryParam("isDefault", "1", "eq"));

        List<AuthorityModel> list = list(sqlQueryParams);

        return list;
    }

    public List<AuthorityModel> listWithLevel(String userGuid) throws Exception {
        List<AuthorityModel> authorityModels = new ArrayList<>();

        List<AuthorityModel> allAuthorityModels = null;
        if (StringUtils.isEmpty(userGuid)) {

            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            UserModel userModel = redisAuthService.getCurrentUser();
            if (userModel.getFlag()==0){
                sqlQueryParams.add(new SqlQueryParam("flag", "0", "eq"));
            }
            Page page = PageHelper.startPage(1, 0, "mainTable.sortId asc");
            page.setOrderByOnly(true);
            allAuthorityModels = this.list(sqlQueryParams);
        } else {

            allAuthorityModels = this.listByUser(userGuid).stream().sorted(Comparator.comparing(AuthorityModel::getSortId)).collect(Collectors.toList());
        }

        HashMap<String, AuthorityModel> authorityModelMap = new HashMap<>();

        while (allAuthorityModels.size() != 0) {
            int count = allAuthorityModels.size();
            Iterator<AuthorityModel> iterator = allAuthorityModels.iterator();

            while (iterator.hasNext()) {
                AuthorityModel authorityModel = iterator.next();

                System.out.println(authorityModel);

                if (authorityModel.getParentId().equals("")) {
                    authorityModelMap.put(authorityModel.getGuid(), authorityModel);
                    iterator.remove();
                } else if (authorityModelMap.containsKey(authorityModel.getParentId())) {
                    AuthorityModel parentAuthorityModel = authorityModelMap.get(authorityModel.getParentId());
                    if (parentAuthorityModel.getChildren() == null) {
                        parentAuthorityModel.setChildren(new ArrayList<>());
                    }
                    parentAuthorityModel.getChildren().add(authorityModel);
                    authorityModelMap.put(authorityModel.getGuid(), authorityModel);
                    iterator.remove();
                }
            }
            if (count == allAuthorityModels.size()) {
                // TODO 需要自定义异常类型
                throw new Exception("进入循环");
            }
        }

        for (AuthorityModel authorityModel : authorityModelMap.values()) {
            if (authorityModel.getParentId().equals("")) {
                authorityModels.add(authorityModel);
            }
        }

        return authorityModels
                .stream()
                .sorted(Comparator.comparing(AuthorityModel::getSortId))
                .collect(Collectors.toList());
    }

}
