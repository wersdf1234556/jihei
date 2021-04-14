package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabConcreteTestHammerQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabConcreteTestHammerService;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labConcretTestHammer")
public class LabConcreteTestHammerController extends BaseController {

    @Autowired
    private ILabConcreteTestHammerService labConcretTestHammerService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabConcreteTestHammerQueryParams labConcretTestHammerQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabConcreteTestHammerModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labConcretTestHammerQueryParams);

        List<LabConcreteTestHammerModel> list = labConcretTestHammerService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabConcreteTestHammerModel labConcretTestHammerModel) {
        labConcretTestHammerModel.setTenderGuid(labTenderService.getBySectionId(labConcretTestHammerModel.getSectionId()));
        labConcretTestHammerService.save(labConcretTestHammerModel);
        return new ExceptionResponse(200, "success", "成功！");
//        this.labConcretTestHammerService.save(labConcretTestHammerModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labConcretTestHammerService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabConcreteTestHammerModel updateStatus (String guid, Integer flag) {
        LabConcreteTestHammerModel labConcreteTestHammerModel = this.labConcretTestHammerService.get(guid);
        labConcreteTestHammerModel.setFlag(flag);
        this.labConcretTestHammerService.update(labConcreteTestHammerModel);
        return labConcreteTestHammerModel;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabConcreteTestHammerModel model = this.labConcretTestHammerService.get(guid);
            model.setFlag(flag);
            this.labConcretTestHammerService.update(model);
        }
    }
}
