package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.RoleQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AuthorityModel;
import org.tonzoc.model.RoleAuthorityModel;
import org.tonzoc.model.RoleModel;
import org.tonzoc.service.IRoleAuthorityService;
import org.tonzoc.service.IRoleService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "role")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleAuthorityService roleAuthorityService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, RoleQueryParams roleQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<RoleModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(roleQueryParams);

        List<RoleModel> list = roleService.list(sqlQueryParams);

        for (RoleModel roleModel : list) {
            List<AuthorityModel> authorityModels = new ArrayList<>();

            List<RoleAuthorityModel> roleAuthorityModels = roleAuthorityService.listByRole(roleModel.getGuid());

            roleModel.setAuthorityModels(roleAuthorityModels
                    .stream()
                    .map(roleAuthorityModel -> {
                        AuthorityModel authorityModel = new AuthorityModel();
                        authorityModel.setGuid(roleAuthorityModel.getAuthorityGuid());

                        return authorityModel;
                    })
                    .collect(Collectors.toList()));
        }

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid RoleModel roleModel) {
        if (roleModel.getFlag()==null){
            roleModel.setFlag(0);
        }
        this.roleService.save(roleModel);
        System.out.println(roleModel);

        saveAuthorityModels(roleModel);
    }

    @PutMapping(value = "{guid}")
    @CacheEvict(value = "list_by_user", allEntries = true)
    public void update(@RequestBody @Valid RoleModel roleModel) {
        System.out.println(roleModel);
        this.roleService.update(roleModel);

        // 首先删除所有权限分配
        roleAuthorityService.deleteByRole(roleModel.getGuid());

        saveAuthorityModels(roleModel);
    }

    @DeleteMapping(value = "{guid}")
    @CacheEvict(value = "list_by_user", allEntries = true)
    public void remove(@PathVariable(value = "guid") String guid) {
        this.roleService.remove(guid);

        roleAuthorityService.deleteByRole(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        roleService.removeMany(guids);
    }

    private void saveAuthorityModels(RoleModel roleModel) {
        if (roleModel.getAuthorityModels() != null && roleModel.getAuthorityModels().size() > 0) {
            for (AuthorityModel authorityModel : roleModel.getAuthorityModels()) {
                RoleAuthorityModel roleAuthorityModel = new RoleAuthorityModel();
                roleAuthorityModel.setRoleGuid(roleModel.getGuid());
                roleAuthorityModel.setAuthorityGuid(authorityModel.getGuid());

                roleAuthorityService.save(roleAuthorityModel);
            }
        }
    }
}
