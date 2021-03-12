package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabUniversalCementQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabUniversalCementModel;
import org.tonzoc.service.ILabUniversalCementService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labUniversalCement")
public class LabUniversalCementController extends BaseController {

    @Autowired
    private ILabUniversalCementService labUniversalCementService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabUniversalCementQueryParams labUniversalCementQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabUniversalCementModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labUniversalCementQueryParams);

        List<LabUniversalCementModel> list = labUniversalCementService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabUniversalCementModel labUniversalCementModel) {
        System.out.println(labUniversalCementModel);
        labUniversalCementService.save(labUniversalCementModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labUniversalCementService.save(labUniversalCementModel);
    }

}