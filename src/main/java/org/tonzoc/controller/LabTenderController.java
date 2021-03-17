package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LabTenderQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.LabTenderModel;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "labTender")
public class LabTenderController extends BaseController {

    @Autowired
    private ILabTenderService labTenderService;

    @GetMapping
    public Map list(PageQueryParams pageQueryParams, LabTenderQueryParams labTenderQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<LabTenderModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(labTenderQueryParams);

        List<LabTenderModel> list = labTenderService.list(sqlQueryParams);

        Map<String, LabTenderModel> result = new HashMap<>();
        for (LabTenderModel labTenderModel : list) {
            result.put(labTenderModel.getTenderName(), labTenderModel);
        }

        return result;
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody LabTenderModel labTenderModel) {
        System.out.println(labTenderModel);
        labTenderService.save(labTenderModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.labTenderService.save(labTenderModel);
    }

}
