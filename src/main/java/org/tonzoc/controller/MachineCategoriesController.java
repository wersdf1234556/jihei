package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachineCategoriesQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineCategoriesModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.service.IMachineCategoriesService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("MachineCategories")
public class MachineCategoriesController extends BaseController {

    @Autowired
    private IMachineCategoriesService machineCategoriesService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachineCategoriesQueryParams machineCategoriesQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machineCategoriesQueryParams);

        List list = machineCategoriesService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add( MachineCategoriesModel mechanicsCategoryModel) {
        this.machineCategoriesService.save(mechanicsCategoryModel);
    }

    @PutMapping(value = "{guid}")
    public void update(MachineCategoriesModel mechanicsCategoryModel) {
        this.machineCategoriesService.update(mechanicsCategoryModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineCategoriesService.remove(guid);
    }
}
