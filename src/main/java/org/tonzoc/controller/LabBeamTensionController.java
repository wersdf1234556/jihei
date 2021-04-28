package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabBeamTensionQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabBeamTensionModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabBeamTensionService;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "labBeamTension")
public class LabBeamTensionController extends BaseController {

    @Autowired
    private ILabBeamTensionService labBeamTensionService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabBeamTensionQueryParams labBeamTensionQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabBeamTensionModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labBeamTensionQueryParams);

        List<LabBeamTensionModel> list = labBeamTensionService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabBeamTensionModel labBeamTensionModel) {
        labBeamTensionModel.setTenderGuid(labTenderService.getBySectionId(labBeamTensionModel.getSectionId()));
        labBeamTensionService.save(labBeamTensionModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labBeamTensionService.save(labBeamTensionModel);
    }

    @GetMapping(value = "groupData")
    public PageResponse getGroupData(PageQueryParams pageQueryParams, String componentParts, String startDate, String endDate)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabBeamTensionModel> page = parsePage(pageQueryParams);

        List<LabBeamTensionModel> list = labBeamTensionService.getGroupData(componentParts, startDate, endDate);

        for (LabBeamTensionModel labBeamTensionModel : list) {
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            sqlQueryParams.add(new SqlQueryParam("componentId", labBeamTensionModel.getComponentId(), "eq"));
            labBeamTensionModel.setChildren(labBeamTensionService.list(sqlQueryParams));
        }

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping(value = "match")
    public void match(String componentId, String beamPrefabricationGuid) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("componentId", componentId, "eq"));
        List<LabBeamTensionModel> list = labBeamTensionService.list(sqlQueryParams);
        for (LabBeamTensionModel labBeamTensionModel : list) {
            labBeamTensionModel.setModelNum(beamPrefabricationGuid);
            this.labBeamTensionService.update(labBeamTensionModel);
        }
    }
}
