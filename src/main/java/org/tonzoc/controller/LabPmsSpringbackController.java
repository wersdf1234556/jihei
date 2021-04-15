package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabPmsSpringbackQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabPmsSpringbackModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabPmsSpringbackService;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labPmsSpringback")
public class LabPmsSpringbackController extends BaseController {

    @Autowired
    private ILabPmsSpringbackService labPmsSpringbackService;
    @Autowired
    private ILabTenderService labTenderService;

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
        labPmsSpringbackModel.setTenderGuid(labTenderService.getBySectionId(labPmsSpringbackModel.getSectionId()));
        labPmsSpringbackModel.setFlag(1);
        labPmsSpringbackService.save(labPmsSpringbackModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labPmsSpringbackService.save(labPmsSpringbackModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labPmsSpringbackService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabPmsSpringbackModel updateStatus (String guid, Integer flag) {
        LabPmsSpringbackModel model = this.labPmsSpringbackService.get(guid);
        model.setFlag(flag);
        this.labPmsSpringbackService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabPmsSpringbackModel model = this.labPmsSpringbackService.get(guid);
            model.setFlag(flag);
            this.labPmsSpringbackService.update(model);
        }
    }

}
