package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabBeamCraneQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabBeamCraneModel;
import org.tonzoc.service.ILabBeamCraneService;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labBeamCrane")
public class LabBeamCraneController extends BaseController {

    @Autowired
    private ILabBeamCraneService labBeamCraneService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabBeamCraneQueryParams labBeamCraneQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabBeamCraneModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labBeamCraneQueryParams);

        List<LabBeamCraneModel> list = labBeamCraneService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabBeamCraneModel labBeamCraneModel) {
        labBeamCraneService.save(labBeamCraneModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labBeamCraneService.save(labBeamCraneModel);
    }
}
