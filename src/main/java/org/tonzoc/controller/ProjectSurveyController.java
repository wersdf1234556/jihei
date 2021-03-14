package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProjectSurveyQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProjectSurveyModel;
import org.tonzoc.service.IProjectSurveyService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "projectSurvey")
public class ProjectSurveyController extends BaseController{

    @Autowired
    private IProjectSurveyService projectSurveyService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProjectSurveyQueryParams projectSurveyQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectSurveyModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(projectSurveyQueryParams);

        List<ProjectSurveyModel> list = projectSurveyService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(ProjectSurveyModel projectSurveyModel, MultipartFile[] file) {
        this.projectSurveyService.save(projectSurveyModel);
        projectSurveyService.upFiles(file, projectSurveyModel.getGuid());
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ProjectSurveyModel projectSurveyModel) {
        this.projectSurveyService.update(projectSurveyModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.projectSurveyService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        this.projectSurveyService.removeMany(guids);
    }
}
