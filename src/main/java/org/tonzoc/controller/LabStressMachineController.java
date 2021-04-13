package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabStressMachineQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabStressMachineModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabStressMachineService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labStressMachine")
public class LabStressMachineController extends BaseController {

    @Autowired
    private ILabStressMachineService labStressMachineService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabStressMachineQueryParams labStressMachineQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabStressMachineModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labStressMachineQueryParams);

        sqlQueryParams.add(new SqlQueryParam("testEvaluation", "0", "eq"));

        List<LabStressMachineModel> list = labStressMachineService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabStressMachineModel labStressMachineModel) {

//        System.out.println(labStressMachineModel);
        labStressMachineService.save(labStressMachineModel);

        return new ExceptionResponse(200, "success", "成功！");
//        this.labStressMachineService.save(labStressMachineModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics(String equipmentType) {
        return labStressMachineService.listStatistics(equipmentType);
    }

    @PostMapping(value = "updateStatus")
    public LabStressMachineModel updateStatus (String guid, Integer flag) {
        LabStressMachineModel model = this.labStressMachineService.get(guid);
        model.setFlag(flag);
        this.labStressMachineService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabStressMachineModel model = this.labStressMachineService.get(guid);
            model.setFlag(flag);
            this.labStressMachineService.update(model);
        }
    }
}
