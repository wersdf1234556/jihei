package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BuildLevelQueryParams;
import org.tonzoc.controller.params.BuildingSafetyQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BuildingSafetyModel;
import org.tonzoc.service.IBuildingSafetyService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("buildingSafety")
public class BuildingSafetyController extends BaseController{
    @Autowired
    private IBuildingSafetyService buildingSafetyService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BuildingSafetyQueryParams buildingSafetyQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BuildingSafetyModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(buildingSafetyQueryParams);
        List<BuildingSafetyModel> list = buildingSafetyService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BuildingSafetyModel buildingSafetyModel) {

        this.buildingSafetyService.save(buildingSafetyModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BuildingSafetyModel buildingSafetyModel) {

        this.buildingSafetyService.update(buildingSafetyModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.buildingSafetyService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        buildingSafetyService.removeMany(guids);
    }
}
