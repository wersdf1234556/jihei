package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabPmsTesterQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.LabPmsTesterModel;
import org.tonzoc.service.ILabPmsTesterService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labPmsTester")
public class LabPmsTesterController extends BaseController {

    @Autowired
    private ILabPmsTesterService labPmsTesterService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabPmsTesterQueryParams labPmsTesterQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabPmsTesterModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labPmsTesterQueryParams);

        List<LabPmsTesterModel> list = labPmsTesterService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public LabPmsTesterModel add(@RequestBody LabPmsTesterModel labPmsTesterModel) {
        System.out.println(labPmsTesterModel);
        labPmsTesterService.save(labPmsTesterModel);
        return labPmsTesterModel;
//        this.labPmsTesterService.save(labPmsTesterModel);
    }

}
