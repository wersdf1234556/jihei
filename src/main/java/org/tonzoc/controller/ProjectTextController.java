package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonQueryParams;
import org.tonzoc.controller.params.ProjectTextQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.model.ProjectTextModel;
import org.tonzoc.service.IProjectTextService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("projectText")
public class ProjectTextController extends BaseController {
    @Autowired
    private IProjectTextService projectTextService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProjectTextQueryParams projectTextQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectTextModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(projectTextQueryParams);

        List list = projectTextService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(ProjectTextModel projectTextModel, MultipartFile file) throws Exception{
        this.projectTextService.insertStack(projectTextModel,file);
    }

    @PutMapping(value = "{guid}")
    public void update(ProjectTextModel projectTextModel, MultipartFile file) throws Exception{
        this.projectTextService.updateStack(projectTextModel,file);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.projectTextService.remove(guid);
    }


    @PostMapping(value = "removeMany")
    public void removeMany(String  guids) throws Exception {
        projectTextService.removeMany(guids);
    }
}
