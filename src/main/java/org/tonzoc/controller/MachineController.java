package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MachineQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.TenderModel;
import org.tonzoc.model.support.ReturnListModel;
import org.tonzoc.model.support.ReturnMachineModel;
import org.tonzoc.service.IMachineService;
import org.tonzoc.service.IMachineTypeService;
import org.tonzoc.service.ITenderMachineTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("machine")
public class MachineController extends BaseController {

    @Autowired
    private IMachineService machineService;

    @Autowired
    private IMachineTypeService machineTypeService;

    @Autowired
    private ITenderMachineTypeService tenderMachineTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MachineQueryParams machineQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<MachineModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(machineQueryParams);

        List<MachineModel> list  = machineService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid MachineModel mechanicsModel) {
        String machineCategoryGuid = tenderMachineTypeService.get(mechanicsModel.getTenderMachineTypeGuid()).getMachineCategoryGuid();
        mechanicsModel.setMachineCategoryGuid(machineCategoryGuid);

        this.machineService.save(mechanicsModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid MachineModel mechanicsModel) {

        if (mechanicsModel.getTenderMachineTypeGuid() != "" && !"".equals(mechanicsModel.getTenderMachineTypeGuid())) {
            mechanicsModel.setMachineCategoryGuid(tenderMachineTypeService.get(mechanicsModel.getTenderMachineTypeGuid()).getMachineCategoryGuid());

        }

        this.machineService.update(mechanicsModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.machineService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        machineService.removeMany(guids);
    }

    // 机械概况
    @GetMapping(value = "mechanicSurvey")
    public List<ReturnModel> machineSurvey(String tenderGuid){

        return machineService.machineSurvey(tenderGuid);
    }

    // 重点机械
    @GetMapping(value = "importantMachine")
    public List<ReturnMachineModel> importantMachine () {

        return machineService.importantMachine();
    }

    // 全标段的重点机械
    @GetMapping(value = "allImportantMachine")
    public List<TenderModel> allImportantMachine(){

        return machineService.allImportantMachine();
    }

    // 按照机械类别查询机械类型
    @GetMapping(value = "machineTypeAndNumber")
    public List<ReturnListModel> machineTypeAndNumber(String machineCategoryGuid){

        return machineService.machineTypeAndNumber(machineCategoryGuid);
    }

    // 查询重点机械
    @GetMapping(value = "importantByMachineType")
    public List<MachineModel> importantByMachineType(String machineTypeGuid){

        return machineService.importantByMachineType(machineTypeGuid);
    }

    // 主界面机械概况
    @GetMapping(value = "machineMainSurvey")
    public List<ReturnModel> machineMainSurvey(String tenderGuid){

        return machineService.machineMainSurvey(tenderGuid);
    }
}