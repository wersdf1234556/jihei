package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachineTypeQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineTypeModel;
import org.tonzoc.service.IMachineTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("machineType")
public class MachineTypeController extends BaseController {

    @Autowired
    private IMachineTypeService machineTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachineTypeQueryParams machineTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<MachineTypeModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machineTypeQueryParams);

        List<MachineTypeModel> list = machineTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid MachineTypeModel mechanicsTypeModel) {
        this.machineTypeService.save(mechanicsTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid MachineTypeModel mechanicsTypeModel) {
        this.machineTypeService.update(mechanicsTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineTypeService.remove(guid);
    }

    @DeleteMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        machineTypeService.removeMany(guids);
    }
}
