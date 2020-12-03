package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachinesQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachinesModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.service.IMachinesService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("Mechanics")
public class MachinesController extends BaseController {

    @Autowired
    private IMachinesService machinesService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachinesQueryParams machinesQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machinesQueryParams);

        List list = machinesService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add( MachinesModel mechanicsModel) {
        this.machinesService.save(mechanicsModel);
    }

    @PutMapping(value = "{guid}")
    public void update(MachinesModel mechanicsModel) {
        this.machinesService.update(mechanicsModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machinesService.remove(guid);
    }
}
