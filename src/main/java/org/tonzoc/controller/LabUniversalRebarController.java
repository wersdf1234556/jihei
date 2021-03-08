package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabUniversalRebarQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabUniversalRebarModel;
import org.tonzoc.service.ILabUniversalRebarService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labUniversalRebar")
public class LabUniversalRebarController extends BaseController {

    @Autowired
    private ILabUniversalRebarService labUniversalRebarService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabUniversalRebarQueryParams labUniversalRebarQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabUniversalRebarModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labUniversalRebarQueryParams);

        List<LabUniversalRebarModel> list = labUniversalRebarService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabUniversalRebarModel labUniversalRebarModel) {
        System.out.println(labUniversalRebarModel);
        labUniversalRebarService.save(labUniversalRebarModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labUniversalRebarService.save(labUniversalRebarModel);
    }

}
