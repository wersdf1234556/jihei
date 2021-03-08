package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabPmsCbrQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabPmsCbrModel;
import org.tonzoc.service.ILabPmsCbrService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labPmsCbr")
public class LabPmsCbrController extends BaseController {

    @Autowired
    private ILabPmsCbrService labPmsCbrService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabPmsCbrQueryParams labPmsCbrQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabPmsCbrModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labPmsCbrQueryParams);

        List<LabPmsCbrModel> list = labPmsCbrService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabPmsCbrModel labPmsCbrModel) {
        System.out.println(labPmsCbrModel);
        labPmsCbrService.save(labPmsCbrModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labPmsCbrService.save(labPmsCbrModel);
    }

}
