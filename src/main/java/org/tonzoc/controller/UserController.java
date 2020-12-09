package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.UserQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.RoleModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.model.UserRoleModel;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.IUserRoleService;
import org.tonzoc.service.IUserService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private IRedisAuthService redisAuthService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, UserQueryParams userQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<UserModel> page = parsePage(pageQueryParams);
        UserQueryParams sqlQueryParamList = new UserQueryParams();
        if (userQueryParams.getName() != null && !userQueryParams.getName().equals("")) {
            sqlQueryParamList.setName(userQueryParams.getName());
        }

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(sqlQueryParamList);

        List<UserModel> list = userService.list(sqlQueryParams);

        for (UserModel userModel : list) {

            List<UserRoleModel> userRoleModels = userRoleService.listByUser(userModel.getGuid());

            userModel.setRoleModels(userRoleModels
                    .stream()
                    .map(userRoleModel -> {
                        RoleModel roleModel = new RoleModel();
                        roleModel.setGuid(userRoleModel.getRoleGuid());

                        return roleModel;
                    })
                    .collect(Collectors.toList()));
        }

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid UserModel userModel) {

        // TODO 添加事务支持

        userModel.setPassword(passwordEncoder.encode(intelliSiteProperties.getDefaultUserPassword()));

        this.userService.save(userModel);

        saveRoleModels(userModel);
    }

    @PutMapping(value = "{guid}")
    @CacheEvict(value = "list_by_user", key = "#userModel.guid")
    public void update(@RequestBody @Valid UserModel userModel) {

        // 不修改密码
        userModel.setPassword(null);

        this.userService.update(userModel);

        // 首先删除所有权限分配
        userRoleService.deleteByUser(userModel.getGuid());
        saveRoleModels(userModel);
    }

    @DeleteMapping(value = "{guid}")
    @CacheEvict(value = "list_by_user", key = "#guid")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.userService.remove(guid);
    }

    @GetMapping(value = "current")
    public UserModel getCurrentUser() throws Exception {
        return redisAuthService.getCurrentUser();
    }

    private void saveRoleModels(UserModel userModel) {
        if (userModel.getRoleModels() != null && userModel.getRoleModels().size() > 0) {
            for (RoleModel roleModel : userModel.getRoleModels()) {
                UserRoleModel userRoleModel = new UserRoleModel();
                userRoleModel.setUserGuid(userModel.getGuid());
                userRoleModel.setRoleGuid(roleModel.getGuid());

                userRoleService.save(userRoleModel);
            }
        }
    }

    @PatchMapping(value = "password")
    public void setPassword(String userGuid, String oldPassword, String newPassword) throws Exception {

        UserModel userModel = userService.get(userGuid);

        // TODO 添加usermodel不存在的自定义异常

        if (newPassword.isEmpty()) {
            userModel.setPassword(passwordEncoder.encode(intelliSiteProperties.getDefaultUserPassword()));
        }

        if (!newPassword.isEmpty()) {

            String password = userModel.getPassword();

            if (!passwordEncoder.matches(oldPassword, password)) {
                // TODO 添加自定义异常
                throw new Exception("输入的原密码（Password: " + oldPassword + "）不正确");
            }

            userModel.setPassword(passwordEncoder.encode(newPassword));
        }

        userService.update(userModel);
    }
}