package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachineTypesQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineTypesModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.service.IMachineTypesService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("MechanicsType")
public class MachineTypesController extends BaseController {

    @Autowired
    private IMachineTypesService machineTypesService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachineTypesQueryParams machineTypesQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machineTypesQueryParams);

        List list = machineTypesService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(MachineTypesModel mechanicsTypeModel) {
        this.machineTypesService.save(mechanicsTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update( MachineTypesModel mechanicsTypeModel) {
        this.machineTypesService.update(mechanicsTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineTypesService.remove(guid);
    }
}
