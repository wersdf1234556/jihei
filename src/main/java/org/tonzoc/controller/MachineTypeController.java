package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachineTypeQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.MachineTypeModel;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.TenderMachineTypeModel;
import org.tonzoc.service.IMachineService;
import org.tonzoc.service.IMachineTypeService;
import org.tonzoc.service.ITenderMachineTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("machineType")
public class MachineTypeController extends BaseController {

    @Autowired
    private IMachineTypeService machineTypeService;

    @Autowired
    private ITenderMachineTypeService tenderMachineTypeService;

    @Autowired
    private IMachineService machineService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachineTypeQueryParams machineTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<MachineTypeModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machineTypeQueryParams);

        List<MachineTypeModel> list = machineTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid MachineTypeModel mechanicTypeModel) {
        this.machineTypeService.save(mechanicTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid MachineTypeModel mechanicTypeModel) {
        if (mechanicTypeModel.getMachineCategoryGuid() != null && !"".equals(mechanicTypeModel.getMachineCategoryGuid())) {
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            sqlQueryParams.add(new SqlQueryParam("mechanicTypeGuid", mechanicTypeModel.getGuid(), "eq"));
            List<TenderMachineTypeModel> list = tenderMachineTypeService.list(sqlQueryParams);

            for (TenderMachineTypeModel li : list) {
                li.setMachineCategoryGuid(mechanicTypeModel.getMachineCategoryGuid());
                tenderMachineTypeService.update(li);

            }
        }

        this.machineTypeService.update(mechanicTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineTypeService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        machineTypeService.removeMany(guids);
    }
}
