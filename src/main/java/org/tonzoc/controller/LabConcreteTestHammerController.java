package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabConcreteTestHammerQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.service.ILabConcreteTestHammerService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labConcretTestHammer")
public class LabConcreteTestHammerController extends BaseController {

    @Autowired
    private ILabConcreteTestHammerService labConcretTestHammerService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabConcreteTestHammerQueryParams labConcretTestHammerQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabConcreteTestHammerModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labConcretTestHammerQueryParams);

        List<LabConcreteTestHammerModel> list = labConcretTestHammerService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public LabConcreteTestHammerModel add(@RequestBody LabConcreteTestHammerModel labConcretTestHammerModel) {
        System.out.println(labConcretTestHammerModel);
        labConcretTestHammerService.save(labConcretTestHammerModel);
        return labConcretTestHammerModel;
//        this.labConcretTestHammerService.save(labConcretTestHammerModel);
    }

}
