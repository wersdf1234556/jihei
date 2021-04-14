package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabCoverProtectometerQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabCoverProtectometerModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabCoverProtectometerService;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labCoverProtectometer")
public class LabCoverProtectometerController extends BaseController {

    @Autowired
    private ILabCoverProtectometerService labCoverProtectometerService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabCoverProtectometerQueryParams labCoverProtectometerQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabCoverProtectometerModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labCoverProtectometerQueryParams);

        List<LabCoverProtectometerModel> list = labCoverProtectometerService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabCoverProtectometerModel labCoverProtectometerModel) {
        labCoverProtectometerModel.setTenderGuid(labTenderService.getBySectionId(labCoverProtectometerModel.getSectionId()));
        labCoverProtectometerService.save(labCoverProtectometerModel);
        return new ExceptionResponse(200, "success", "成功！");
//        this.labCoverProtectometerService.save(labCoverProtectometerModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labCoverProtectometerService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabCoverProtectometerModel updateStatus (String guid, Integer flag) {
        LabCoverProtectometerModel model = this.labCoverProtectometerService.get(guid);
        model.setFlag(flag);
        this.labCoverProtectometerService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabCoverProtectometerModel model = this.labCoverProtectometerService.get(guid);
            model.setFlag(flag);
            this.labCoverProtectometerService.update(model);
        }
    }
}
