package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachineCategoryQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineCategoryModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.service.IMachineCategoryService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("MachineCategory")
public class MachineCategoryController extends BaseController {

    @Autowired
    private IMachineCategoryService machineCategoryService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachineCategoryQueryParams machineCategoryQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machineCategoryQueryParams);

        List list = machineCategoryService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add( MachineCategoryModel mechanicsCategoryModel) {
        this.machineCategoryService.save(mechanicsCategoryModel);
    }

    @PutMapping(value = "{guid}")
    public void update(MachineCategoryModel mechanicsCategoryModel) {
        this.machineCategoryService.update(mechanicsCategoryModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineCategoryService.remove(guid);
    }
}
