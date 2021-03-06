package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabUniversalMachineQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabUniversalMachineModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabUniversalMachineService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labUniversalMachine")
public class LabUniversalMachineController extends BaseController {

    @Autowired
    private ILabUniversalMachineService labUniversalMachineService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabUniversalMachineQueryParams labUniversalMachineQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabUniversalMachineModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labUniversalMachineQueryParams);

        List<LabUniversalMachineModel> list = labUniversalMachineService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabUniversalMachineModel labUniversalMachineModel) {
        System.out.println(labUniversalMachineModel);
        labUniversalMachineService.save(labUniversalMachineModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labUniversalMachineService.save(labUniversalMachineModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labUniversalMachineService.listStatistics();
    }
}
