package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabMarshallStabilityQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabMarshallStabilityModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabMarshallStabilityService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labMarshallStability")
public class LabMarshallStabilityController extends BaseController {

    @Autowired
    private ILabMarshallStabilityService labMarshallStabilityService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabMarshallStabilityQueryParams labMarshallStabilityQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabMarshallStabilityModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labMarshallStabilityQueryParams);

        List<LabMarshallStabilityModel> list = labMarshallStabilityService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabMarshallStabilityModel labMarshallStabilityModel) {
        System.out.println(labMarshallStabilityModel);
        labMarshallStabilityService.save(labMarshallStabilityModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labMarshallStabilityService.save(labMarshallStabilityModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labMarshallStabilityService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabMarshallStabilityModel updateStatus (String guid, Integer flag) {
        LabMarshallStabilityModel model = this.labMarshallStabilityService.get(guid);
        model.setFlag(flag);
        this.labMarshallStabilityService.update(model);
        return model;
    }
}
