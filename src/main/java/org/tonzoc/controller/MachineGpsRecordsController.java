package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachineGpsRecordsQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineGpsRecordsModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.service.IMachineGpsRecordsService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("MechanicsGpsRecords")
public class MachineGpsRecordsController extends BaseController{

    @Autowired
    private IMachineGpsRecordsService machineGpsRecordsService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachineGpsRecordsQueryParams machineGpsRecordsQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machineGpsRecordsQueryParams);

        List list = machineGpsRecordsService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add( MachineGpsRecordsModel mechanicsGpsRecordsModel) {
        this.machineGpsRecordsService.save(mechanicsGpsRecordsModel);
    }

    @PutMapping(value = "{guid}")
    public void update(MachineGpsRecordsModel mechanicsGpsRecordsModel) {
        this.machineGpsRecordsService.update(mechanicsGpsRecordsModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineGpsRecordsService.remove(guid);
    }
}
