package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BuildLevelQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BuildLevelModel;
import org.tonzoc.service.IBuildLevelService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("buildLevel")
public class BuildLevelController extends BaseController{

    @Autowired
    private IBuildLevelService buildLevelService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BuildLevelQueryParams buildLevelQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BuildLevelModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(buildLevelQueryParams);
        List<BuildLevelModel> list = buildLevelService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BuildLevelModel buildLevelModel) {

        this.buildLevelService.save(buildLevelModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BuildLevelModel buildLevelModel) {

        this.buildLevelService.update(buildLevelModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.buildLevelService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        buildLevelService.removeMany(guids);
    }
}
