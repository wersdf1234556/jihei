package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.ProgressWeatherQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.ProgressWeatherModel;
import org.tonzoc.model.support.LabStatModel;
import org.tonzoc.service.IProgressWeatherService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "progressWeather")
public class ProgressWeatherController extends BaseController {

    @Autowired
    private IProgressWeatherService progressWeatherService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProgressWeatherQueryParams progressWeatherQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProgressWeatherModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(progressWeatherQueryParams);

        List<ProgressWeatherModel> list = progressWeatherService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public ExceptionResponse add(@RequestBody ProgressWeatherModel progressWeatherModel) {
        System.out.println(progressWeatherModel);
        progressWeatherService.save(progressWeatherModel);
        return new ExceptionResponse(200, "success", "成功！");
        //        this.progressWeatherService.save(progressWeatherModel);
    }

}
