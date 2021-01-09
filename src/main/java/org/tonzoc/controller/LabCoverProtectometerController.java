package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabCoverProtectometerQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabCoverProtectometerModel;
import org.tonzoc.service.ILabCoverProtectometerService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labCoverProtectometer")
public class LabCoverProtectometerController extends BaseController {

    @Autowired
    private ILabCoverProtectometerService labCoverProtectometerService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabCoverProtectometerQueryParams labCoverProtectometerQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabCoverProtectometerModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labCoverProtectometerQueryParams);

        List<LabCoverProtectometerModel> list = labCoverProtectometerService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabCoverProtectometerModel labCoverProtectometerModel) {
        System.out.println(labCoverProtectometerModel);
        labCoverProtectometerService.save(labCoverProtectometerModel);
        return new ExceptionResponse(200, "success", "成功！");
//        this.labCoverProtectometerService.save(labCoverProtectometerModel);
    }

}
