package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabPenetrationQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabPenetrationModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabPenetrationService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labPenetration")
public class LabPenetrationController extends BaseController {

    @Autowired
    private ILabPenetrationService labPenetrationService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabPenetrationQueryParams labPenetrationQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabPenetrationModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labPenetrationQueryParams);

        List<LabPenetrationModel> list = labPenetrationService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabPenetrationModel labPenetrationModel) {
        System.out.println(labPenetrationModel);
        labPenetrationService.save(labPenetrationModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labPenetrationService.save(labPenetrationModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labPenetrationService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabPenetrationModel updateStatus (String guid, Integer flag) {
        LabPenetrationModel model = this.labPenetrationService.get(guid);
        model.setFlag(flag);
        this.labPenetrationService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabPenetrationModel model = this.labPenetrationService.get(guid);
            model.setFlag(flag);
            this.labPenetrationService.update(model);
        }
    }
}
