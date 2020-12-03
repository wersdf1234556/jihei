package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachineQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.service.IMachineService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("machine")
public class MachineController extends BaseController {

    @Autowired
    private IMachineService machineService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachineQueryParams machineQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machineQueryParams);

        List list = machineService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add( MachineModel mechanicsModel) {
        this.machineService.save(mechanicsModel);
    }

    @PutMapping(value = "{guid}")
    public void update(MachineModel mechanicsModel) {
        this.machineService.update(mechanicsModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineService.remove(guid);
    }

    // 机械概况
    @GetMapping(value = "mechanicSurvey")
    public List<ReturnModel> machineSurvey(String tenderGuid){

        return machineService.machineSurvey(tenderGuid);
    }

    // 重点机械
    @GetMapping(value = "importantMachine")
    public List<ReturnModel> importantMachine (String tenderGuid) {
        return machineService.importantMachine(tenderGuid);
    }
}
