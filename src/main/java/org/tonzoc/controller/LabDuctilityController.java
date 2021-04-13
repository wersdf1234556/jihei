package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabDuctilityQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabConcreteTestHammerModel;
import org.tonzoc.model.LabCoverProtectometerModel;
import org.tonzoc.model.LabDuctilityModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.ILabDuctilityService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "labDuctility")
public class LabDuctilityController extends BaseController {

    @Autowired
    private ILabDuctilityService labDuctilityService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LabDuctilityQueryParams labDuctilityQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabDuctilityModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labDuctilityQueryParams);

        List<LabDuctilityModel> list = labDuctilityService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabDuctilityModel labDuctilityModel) {
        System.out.println(labDuctilityModel);
        labDuctilityService.save(labDuctilityModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labDuctilityService.save(labDuctilityModel);
    }

    @GetMapping(value = "statistics")
    public List<LabStatModel> listStatistics() {
        return labDuctilityService.listStatistics();
    }

    @PostMapping(value = "updateStatus")
    public LabDuctilityModel updateStatus (String guid, Integer flag) {
        LabDuctilityModel model = this.labDuctilityService.get(guid);
        model.setFlag(flag);
        this.labDuctilityService.update(model);
        return model;
    }

    @PostMapping(value = "batchUpdateStatus")
    public void batchUpdateStatus (String guids, Integer flag) {
        String[] guidArray = guids.split(",");
        for (String guid : guidArray) {
            LabDuctilityModel model = this.labDuctilityService.get(guid);
            model.setFlag(flag);
            this.labDuctilityService.update(model);
        }
    }
}
