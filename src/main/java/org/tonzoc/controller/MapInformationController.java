package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.MapInformationQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MapInformationModel;
import org.tonzoc.service.IMapInformationService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
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

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid MapInformationModel mapInformationModel) {

        this.mapInformationService.save(mapInformationModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid MapInformationModel mapInformationModel) {

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
