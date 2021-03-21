package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SecurityQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.DocumentModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityRuleModel;
import org.tonzoc.service.ISecurityRuleService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "securityRule")
public class SecurityRuleController extends BaseController {

    @Autowired
    private ISecurityRuleService securityRuleService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SecurityQueryParams securityQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SecurityRuleModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(securityQueryParams);

        List<SecurityRuleModel> list = securityRuleService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid SecurityRuleModel securityRuleModel) {
        this.securityRuleService.save(securityRuleModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityRuleModel securityRuleModel) {
        this.securityRuleService.update(securityRuleModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.securityRuleService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        securityRuleService.removeMany(guids);
    }
}
