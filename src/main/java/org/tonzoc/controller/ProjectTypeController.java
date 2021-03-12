package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonQueryParams;
import org.tonzoc.controller.params.ProjectTypeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.model.ProjectTypeModel;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.service.IProjectTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("projectType")
public class ProjectTypeController  extends BaseController{
    @Autowired
    private IProjectTypeService projectTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProjectTypeQueryParams projectTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(projectTypeQueryParams);

        List list = projectTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid ProjectTypeModel projectTypeModel ) {
        this.projectTypeService.save(projectTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ProjectTypeModel projectTypeModel) {
        this.projectTypeService.update(projectTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.projectTypeService.remove(guid);
    }


    @PostMapping(value = "removeMany")
    public void removeMany(String  guids) throws Exception {
        projectTypeService.removeMany(guids);
    }
}
