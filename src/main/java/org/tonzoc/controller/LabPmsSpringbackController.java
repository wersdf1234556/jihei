package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabPmsSpringbackQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabPmsSpringbackModel;
import org.tonzoc.service.ILabPmsSpringbackService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labPmsSpringback")
public class LabPmsSpringbackController extends BaseController {

    @Autowired
    private ILabPmsSpringbackService labPmsSpringbackService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabPmsSpringbackQueryParams labPmsSpringbackQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabPmsSpringbackModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labPmsSpringbackQueryParams);

        List<LabPmsSpringbackModel> list = labPmsSpringbackService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabPmsSpringbackModel labPmsSpringbackModel) {
        System.out.println(labPmsSpringbackModel);
        labPmsSpringbackService.save(labPmsSpringbackModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labPmsSpringbackService.save(labPmsSpringbackModel);
    }

}
