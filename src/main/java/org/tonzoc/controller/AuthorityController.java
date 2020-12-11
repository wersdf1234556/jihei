package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.AuthorityQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AuthorityModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IAuthorityService;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "authority")
public class AuthorityController extends BaseController {

    @Autowired
    private IAuthorityService authorityService;

    @Autowired
    private IRedisAuthService redisAuthService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AuthorityQueryParams authorityQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<AuthorityModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(authorityQueryParams);

        List list = authorityService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @GetMapping(value = "withLevel")
    public List<AuthorityModel> listWithLevel() throws Exception {
        return authorityService.listWithLevel("");
    }

    @GetMapping(value = "withUser")
    public List<AuthorityModel> listWithUser() throws Exception {
        UserModel userModel = redisAuthService.getCurrentUser();
        return authorityService.listWithLevel(userModel.getGuid());
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "list_default")
    public void add(@RequestBody @Valid AuthorityModel authorityModel) {
        this.authorityService.save(authorityModel);

        String cacheKey = "authority_list_default";
    }

    @PutMapping(value = "{guid}")
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "list_default")
    public void update(@RequestBody @Valid AuthorityModel authorityModel) {
        this.authorityService.update(authorityModel);

        String cacheKey = "authority_list_default";
    }

    @DeleteMapping(value = "{guid}")
    @CacheEvict(value = "list_default")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.authorityService.remove(guid);

        String cacheKey = "authority_list_default";
    }

    @GetMapping(value = "check")
    public Boolean check(@RequestParam(value = "authorityGuid") String authorityGuid) throws Exception {

        UserModel userModel = redisAuthService.getCurrentUser();

        List<AuthorityModel> authorityModels = authorityService.listByUser(userModel.getGuid());

        for (AuthorityModel authorityModel : authorityModels) {
            if (authorityGuid.equals(authorityModel.getGuid())) {
                return true;
            }
        }

        return false;
    }

    @DeleteMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        authorityService.removeMany(guids);
    }
}
