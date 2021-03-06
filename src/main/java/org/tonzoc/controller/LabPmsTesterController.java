package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabPmsTesterQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabPmsTesterModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabPmsTesterService;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labPmsTester")
public class LabPmsTesterController extends BaseController {

    @Autowired
    private ILabPmsTesterService labPmsTesterService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabPmsTesterQueryParams labPmsTesterQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabPmsTesterModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labPmsTesterQueryParams);

        List<LabPmsTesterModel> list = labPmsTesterService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabPmsTesterModel labPmsTesterModel) {
        labPmsTesterModel.setTenderGuid(labTenderService.getBySectionId(labPmsTesterModel.getSectionId()));
        labPmsTesterModel.setFlag(1);
        labPmsTesterService.save(labPmsTesterModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labPmsTesterService.save(labPmsTesterModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labPmsTesterService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabPmsTesterModel updateStatus (String guid, Integer flag) {
        LabPmsTesterModel model = this.labPmsTesterService.get(guid);
        model.setFlag(flag);
        this.labPmsTesterService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabPmsTesterModel model = this.labPmsTesterService.get(guid);
            model.setFlag(flag);
            this.labPmsTesterService.update(model);
        }
    }

}
