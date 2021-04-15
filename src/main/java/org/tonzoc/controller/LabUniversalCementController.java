package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabUniversalCementQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.LabUniversalCementModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.service.ILabUniversalCementService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labUniversalCement")
public class LabUniversalCementController extends BaseController {

    @Autowired
    private ILabUniversalCementService labUniversalCementService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabUniversalCementQueryParams labUniversalCementQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabUniversalCementModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labUniversalCementQueryParams);

        List<LabUniversalCementModel> list = labUniversalCementService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabUniversalCementModel labUniversalCementModel) {
        labUniversalCementModel.setTenderGuid(labTenderService.getBySectionId(labUniversalCementModel.getSectionId()));
        labUniversalCementModel.setFlag(1);
        labUniversalCementService.save(labUniversalCementModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labUniversalCementService.save(labUniversalCementModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labUniversalCementService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabUniversalCementModel updateStatus (String guid, Integer flag) {
        LabUniversalCementModel model = this.labUniversalCementService.get(guid);
        model.setFlag(flag);
        this.labUniversalCementService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabUniversalCementModel model = this.labUniversalCementService.get(guid);
            model.setFlag(flag);
            this.labUniversalCementService.update(model);
        }
    }
}
