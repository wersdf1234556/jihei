package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabSofteningPointQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.LabSofteningPointModel;
import org.tonzoc.service.ILabSofteningPointService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labSofteningPoint")
public class LabSofteningPointController extends BaseController {

    @Autowired
    private ILabSofteningPointService labSofteningPointService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabSofteningPointQueryParams labSofteningPointQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabSofteningPointModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labSofteningPointQueryParams);

        List<LabSofteningPointModel> list = labSofteningPointService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public LabSofteningPointModel add(@RequestBody LabSofteningPointModel labSofteningPointModel) {
        System.out.println(labSofteningPointModel);
        labSofteningPointService.save(labSofteningPointModel);
        return labSofteningPointModel;
//        this.labSofteningPointService.save(labSofteningPointModel);
    }

}
