package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachineGpsRecordQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineGpsRecordModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.service.IMachineGpsRecordService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("MechanicsGpsRecord")
public class MachineGpsRecordController extends BaseController{

    @Autowired
    private IMachineGpsRecordService machineGpsRecordService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachineGpsRecordQueryParams machineGpsRecordQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machineGpsRecordQueryParams);

        List list = machineGpsRecordService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add( MachineGpsRecordModel mechanicsGpsRecordsModel) {
        this.machineGpsRecordService.save(mechanicsGpsRecordsModel);
    }

    @PutMapping(value = "{guid}")
    public void update(MachineGpsRecordModel mechanicsGpsRecordsModel) {
        this.machineGpsRecordService.update(mechanicsGpsRecordsModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineGpsRecordService.remove(guid);
    }
}
