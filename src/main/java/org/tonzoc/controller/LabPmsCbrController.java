package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabPmsCbrQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabPmsCbrModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabPmsCbrService;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labPmsCbr")
public class LabPmsCbrController extends BaseController {

    @Autowired
    private ILabPmsCbrService labPmsCbrService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabPmsCbrQueryParams labPmsCbrQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabPmsCbrModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labPmsCbrQueryParams);

        List<LabPmsCbrModel> list = labPmsCbrService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabPmsCbrModel labPmsCbrModel) {
        labPmsCbrModel.setTenderGuid(labTenderService.getBySectionId(labPmsCbrModel.getSectionId()));
        labPmsCbrService.save(labPmsCbrModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labPmsCbrService.save(labPmsCbrModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labPmsCbrService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabPmsCbrModel updateStatus (String guid, Integer flag) {
        LabPmsCbrModel model = this.labPmsCbrService.get(guid);
        model.setFlag(flag);
        this.labPmsCbrService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabPmsCbrModel model = this.labPmsCbrService.get(guid);
            model.setFlag(flag);
            this.labPmsCbrService.update(model);
        }
    }
}
