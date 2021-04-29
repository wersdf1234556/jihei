package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.TenderMachineTypeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.MachineTypeModel;
import org.tonzoc.model.TenderMachineTypeModel;
import org.tonzoc.service.IMachineCategoryService;
import org.tonzoc.service.IMachineService;
import org.tonzoc.service.IMachineTypeService;
import org.tonzoc.service.ITenderMachineTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "tenderMachineType")
public class TenderMachineTypeController extends BaseController {

    @Autowired
    private ITenderMachineTypeService tenderMachineTypeService;

    @Autowired
    private IMachineTypeService machineTypeService;

    @Autowired
    private IMachineService machineService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, TenderMachineTypeQueryParams tenderMachineTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<TenderMachineTypeModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(tenderMachineTypeQueryParams);

        List<TenderMachineTypeModel> list  = tenderMachineTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid TenderMachineTypeModel tenderMachineTypeModel) {

        MachineTypeModel machineTypeModel = machineTypeService.get(tenderMachineTypeModel.getMachineTypeGuid());
        tenderMachineTypeModel.setName(machineTypeModel.getName());
        tenderMachineTypeModel.setFormattedName(machineTypeModel.getFormattedName());
        tenderMachineTypeModel.setSortId(machineTypeModel.getSortId());
        tenderMachineTypeModel.setMachineCategoryGuid(machineTypeModel.getMachineCategoryGuid());

        this.tenderMachineTypeService.save(tenderMachineTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid TenderMachineTypeModel tenderMachineTypeModel) {

        MachineTypeModel machineTypeModel = machineTypeService.get(tenderMachineTypeModel.getMachineTypeGuid());
        if (tenderMachineTypeModel.getName() != null && !"".equals(tenderMachineTypeModel.getName())) {

            tenderMachineTypeModel.setName(machineTypeModel.getName());
            tenderMachineTypeModel.setFormattedName(machineTypeModel.getFormattedName());
        }
        tenderMachineTypeModel.setMachineCategoryGuid(machineTypeModel.getMachineCategoryGuid());

        this.tenderMachineTypeService.update(tenderMachineTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.tenderMachineTypeService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        tenderMachineTypeService.removeMany(guids);
    }
}
