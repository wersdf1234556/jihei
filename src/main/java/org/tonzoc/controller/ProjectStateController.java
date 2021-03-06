package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProjectStateQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProjectStateModel;
import org.tonzoc.service.IProjectStateService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("projectState")
public class ProjectStateController extends BaseController{

    @Autowired
    private IProjectStateService projectStateService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProjectStateQueryParams projectStateQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectStateModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(projectStateQueryParams);
        List<ProjectStateModel> list = projectStateService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid ProjectStateModel projectStateModel) {

        this.projectStateService.save(projectStateModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ProjectStateModel projectStateModel) {

        this.projectStateService.update(projectStateModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.projectStateService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        projectStateService.removeMany(guids);
    }
}
