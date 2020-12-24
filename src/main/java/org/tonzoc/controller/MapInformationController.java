package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.controller.params.MapInformationQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MapInformationModel;
import org.tonzoc.service.IMapInformationService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("mapInformation")
public class MapInformationController extends BaseController {

    @Autowired
    private IMapInformationService mapInformationService;


    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MapInformationQueryParams mapInformationQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<MapInformationModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(mapInformationQueryParams);
        List<MapInformationModel> list = mapInformationService.list(sqlQueryParams);

        list = mapInformationService.selected(list);
        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid MapInformationModel mapInformationModel) throws ParseException {

        mapInformationModel.setCurrentTime(TimeHelper.stringToDate(mapInformationModel.getCurrentDate()));
        this.mapInformationService.save(mapInformationModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid MapInformationModel mapInformationModel) throws ParseException {

        mapInformationModel.setCurrentTime(TimeHelper.stringToDate(mapInformationModel.getCurrentDate()));
        this.mapInformationService.update(mapInformationModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.mapInformationService.remove(guid);
    }

    @GetMapping(value = "three")
    public List<MapInformationModel> three() {

       return mapInformationService.three();
    }
}
