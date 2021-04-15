package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabSofteningPointQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabSofteningPointModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabSofteningPointService;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labSofteningPoint")
public class LabSofteningPointController extends BaseController {

    @Autowired
    private ILabSofteningPointService labSofteningPointService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabSofteningPointQueryParams labSofteningPointQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabSofteningPointModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labSofteningPointQueryParams);

        List<LabSofteningPointModel> list = labSofteningPointService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabSofteningPointModel labSofteningPointModel) {
        labSofteningPointModel.setTenderGuid(labTenderService.getBySectionId(labSofteningPointModel.getSectionId()));
        labSofteningPointModel.setFlag(1);
        labSofteningPointService.save(labSofteningPointModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labSofteningPointService.save(labSofteningPointModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labSofteningPointService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabSofteningPointModel updateStatus (String guid, Integer flag) {
        LabSofteningPointModel model = this.labSofteningPointService.get(guid);
        model.setFlag(flag);
        this.labSofteningPointService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabSofteningPointModel model = this.labSofteningPointService.get(guid);
            model.setFlag(flag);
            this.labSofteningPointService.update(model);
        }
    }
}
