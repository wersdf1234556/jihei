package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.ManagementPowerQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ManagementPowerModel;
import org.tonzoc.service.IManagementPowerService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("managementPower")
public class ManagementPowerController extends BaseController{

    @Autowired
    private IManagementPowerService managementPowerService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ManagementPowerQueryParams managementPowerQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ManagementPowerModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(managementPowerQueryParams);
        List<ManagementPowerModel> list = managementPowerService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid ManagementPowerModel managementPowerModel) {

        this.managementPowerService.save(managementPowerModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ManagementPowerModel managementPowerModel) {

        this.managementPowerService.update(managementPowerModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.managementPowerService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        managementPowerService.removeMany(guids);
    }
}
