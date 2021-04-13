package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabHumitureQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabHumitureModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabHumitureService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labHumiture")
public class LabHumitureController extends BaseController {

    @Autowired
    private ILabHumitureService labHumitureService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabHumitureQueryParams labHumitureQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabHumitureModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labHumitureQueryParams);

        List<LabHumitureModel> list = labHumitureService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabHumitureModel labHumitureModel) {
        System.out.println(labHumitureModel);
        labHumitureService.save(labHumitureModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labHumitureService.save(labHumitureModel);
    }


    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labHumitureService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabHumitureModel updateStatus (String guid, Integer flag) {
        LabHumitureModel model = this.labHumitureService.get(guid);
        model.setFlag(flag);
        this.labHumitureService.update(model);
        return model;
    }
}
