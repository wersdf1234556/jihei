package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabStressMachineQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.LabStressMachineModel;
import org.tonzoc.service.ILabStressMachineService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
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

        List<LabStressMachineModel> list = labStressMachineService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public LabStressMachineModel add(LabStressMachineModel labStressMachineModel) {
        System.out.println(labStressMachineModel);
        return labStressMachineModel;
//        this.labStressMachineService.save(labStressMachineModel);
    }

}