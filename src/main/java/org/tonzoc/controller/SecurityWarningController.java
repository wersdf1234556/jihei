package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SecurityWarningQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.SecurityWarningModel;
import org.tonzoc.service.ISecurityWarningService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "securityWarning")
public class SecurityWarningController extends BaseController {

    @Autowired
    private ISecurityWarningService securityWarningService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SecurityWarningQueryParams securityWarningQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SecurityWarningModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(securityWarningQueryParams);
        List<SecurityWarningModel> list = securityWarningService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid SecurityWarningModel securityWarningModel) {
        this.securityWarningService.save(securityWarningModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityWarningModel securityWarningModel) {
        this.securityWarningService.update(securityWarningModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.securityWarningService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        securityWarningService.removeMany(guids);
    }
}
