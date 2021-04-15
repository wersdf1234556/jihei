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
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.RoleModel;
import org.tonzoc.model.TenderModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.IUserService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

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

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(userQueryParams);

        List<UserModel> list = userService.list(sqlQueryParams);


        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid UserModel userModel) {
        if (userModel.getFlag() == null){
            userModel.setFlag(0);
        }

        // TODO 添加事务支持

        userModel.setPassword(passwordEncoder.encode(intelliSiteProperties.getDefaultUserPassword()));

        this.userService.insertStack(userModel);

    }

    @PutMapping(value = "{guid}")
    @CacheEvict(value = "list_by_user", key = "#userModel.guid")
    public void update(@RequestBody @Valid UserModel userModel) {
        // 不修改密码
        userModel.setPassword(null);

        this.userService.updateStack(userModel);

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

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        userService.removeMany(guids);
    }

    @PutMapping(value = "resetPassword")
    public void resetPassword(String guid) throws Exception {
        UserModel userModel = userService.get(guid);
        if (userModel==null){
            throw new NotFoundException("不存在此用户，无法重置密码");
        }
        userModel.setPassword(passwordEncoder.encode(intelliSiteProperties.getDefaultUserPassword()));
        userService.update(userModel);

    }

    //查询管理标段信息list
    @GetMapping(value = "listTendersByUserId")
    public List<TenderModel> listTendersByUserId(String userGuid) throws Exception{
        return userService.listTendersByUserId(userGuid);
    }

    // 查询上一级
    @GetMapping(value = "getNextSupervisor")
    public String getNextSupervisor(String tenderGuid, String accounType){

        return userService.getNextSupervisor(tenderGuid, accounType);
    }
}