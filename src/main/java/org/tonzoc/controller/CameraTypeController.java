package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.CameraTypeQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.CameraTypeModel;
import org.tonzoc.service.ICameraTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("cameraType")
public class CameraTypeController extends BaseController {

    @Autowired
    private ICameraTypeService cameraTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, CameraTypeQueryParams cameraTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println(pageQueryParams.getOrder());
        Page<CameraTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(cameraTypeQueryParams);
        List list = cameraTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid CameraTypeModel cameraTypeModel) {
        this.cameraTypeService.save(cameraTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid CameraTypeModel cameraTypeModel) {
        this.cameraTypeService.update(cameraTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.cameraTypeService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        cameraTypeService.removeMany(guids);
    }

}
