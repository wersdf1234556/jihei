package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.AreaDataQueryParams;
import org.tonzoc.controller.params.CameraTypeQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AreaDataModel;
import org.tonzoc.model.CameraTypeModel;
import org.tonzoc.service.IAreaDataService;
import org.tonzoc.service.ICameraTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("areaData")
public class AreaDataController extends BaseController {

    @Autowired
    private IAreaDataService areaDataService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AreaDataQueryParams areaDataQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println(pageQueryParams.getOrder());
        Page<AreaDataModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(areaDataQueryParams);
        List list = areaDataService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid AreaDataModel areaDataModel) {
        this.areaDataService.save(areaDataModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid AreaDataModel areaDataModel) {
        this.areaDataService.update(areaDataModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.areaDataService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        areaDataService.removeMany(guids);
    }

    @GetMapping(value = "listWithLevel")
    public List<AreaDataModel> listWithLevel(String parentCode) throws Exception {
        return areaDataService.listWithLevel(parentCode);
    }

}
