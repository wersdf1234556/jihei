package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabBeamPulpingQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabBeamPulpingModel;
import org.tonzoc.model.LabBeamTensionModel;
import org.tonzoc.service.ILabBeamPulpingService;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "labBeamPulping")
public class LabBeamPulpingController extends BaseController {

    @Autowired
    private ILabBeamPulpingService labBeamPulpingService;
    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabBeamPulpingQueryParams labBeamPulpingQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabBeamPulpingModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labBeamPulpingQueryParams);

        List<LabBeamPulpingModel> list = labBeamPulpingService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabBeamPulpingModel labBeamPulpingModel) {
        labBeamPulpingModel.setTenderGuid(labTenderService.getBySectionId(labBeamPulpingModel.getSectionId()));
        labBeamPulpingService.save(labBeamPulpingModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labBeamPulpingService.save(labBeamPulpingModel);
    }

    @GetMapping(value = "groupData")
    public PageResponse getGroupData(PageQueryParams pageQueryParams, String componentParts, String startDate, String endDate, String tenderGuid)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabBeamTensionModel> page = parsePage(pageQueryParams);

        List<LabBeamPulpingModel> list = labBeamPulpingService.getGroupData(componentParts, startDate, endDate, tenderGuid);

        for (LabBeamPulpingModel labBeamPulpingModel : list) {
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            sqlQueryParams.add(new SqlQueryParam("componentId", labBeamPulpingModel.getComponentId(), "eq"));
            labBeamPulpingModel.setChildren(labBeamPulpingService.list(sqlQueryParams));
        }

        return new PageResponse(page.getTotal(), list);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.labBeamPulpingService.remove(guid);
    }

    @PostMapping(value = "match")
    public void match(String componentId, String beamPrefabricationGuid) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("componentId", componentId, "eq"));
        List<LabBeamPulpingModel> list = labBeamPulpingService.list(sqlQueryParams);
        for (LabBeamPulpingModel labBeamTensionModel : list) {
            labBeamTensionModel.setModelNum(beamPrefabricationGuid);
            this.labBeamPulpingService.update(labBeamTensionModel);
        }
    }
}
