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

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("machineGpsRecord")
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
    public void add(@RequestBody @Valid MachineGpsRecordModel mechanicsGpsRecordsModel) {
        this.machineGpsRecordService.save(mechanicsGpsRecordsModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid MachineGpsRecordModel mechanicsGpsRecordsModel) {
        this.machineGpsRecordService.update(mechanicsGpsRecordsModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineGpsRecordService.remove(guid);
    }

    @DeleteMapping(value = "removeMany")
    public void removeMany(@RequestBody(required = false) List<String> guids){
        machineGpsRecordService.removeMany(guids);
    }
}
