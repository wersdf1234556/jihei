package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabUniversalRebarQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabUniversalRebarModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.service.ILabUniversalRebarService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labUniversalRebar")
public class LabUniversalRebarController extends BaseController {

    @Autowired
    private ILabUniversalRebarService labUniversalRebarService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabUniversalRebarQueryParams labUniversalRebarQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabUniversalRebarModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labUniversalRebarQueryParams);

        List<LabUniversalRebarModel> list = labUniversalRebarService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabUniversalRebarModel labUniversalRebarModel) {
        labUniversalRebarModel.setTenderGuid(labTenderService.getBySectionId(labUniversalRebarModel.getSectionId()));
        labUniversalRebarService.save(labUniversalRebarModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labUniversalRebarService.save(labUniversalRebarModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labUniversalRebarService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabUniversalRebarModel updateStatus (String guid, Integer flag) {
        LabUniversalRebarModel model = this.labUniversalRebarService.get(guid);
        model.setFlag(flag);
        this.labUniversalRebarService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabUniversalRebarModel model = this.labUniversalRebarService.get(guid);
            model.setFlag(flag);
            this.labUniversalRebarService.update(model);
        }
    }
}
