package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProjectQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.HallModel;
import org.tonzoc.service.IProjectService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController extends BaseController {

    @Autowired
    private IProjectService projectService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProjectQueryParams projectQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(projectQueryParams);

        List list = projectService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid ProjectModel projectModel) {
        this.projectService.save(projectModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ProjectModel projectModel) {
        this.projectService.update(projectModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.projectService.remove(guid);
    }

    // 全部项目的数据
    @GetMapping(value = "dateAll")
    public List<ReturnModel> dateAll(){

        return projectService.dateAll();
    }

    // 项目情况
    @GetMapping(value = "typeOne")
    public List<ReturnModel> typeOne(String industryCategoryGuid, String managementPowerGuid){

        return projectService.typeOne(industryCategoryGuid, managementPowerGuid);
    }

    // 项目数
    @GetMapping(value = "typeTwo")
    public List<ReturnModel> typeTwo(String industryCategoryGuid, String managementPowerGuid){

        return projectService.typeTwo(industryCategoryGuid, managementPowerGuid);
    }

    // 总投资额
    @GetMapping(value = "typeThree")
    public List<ReturnModel> typeThree(String industryCategoryGuid, String managementPowerGuid){

        return projectService.typeThree(industryCategoryGuid, managementPowerGuid);
    }

    // 已完成投资额
    @GetMapping(value = "typeFour")
    public List<ReturnModel> typeFour(String industryCategoryGuid, String managementPowerGuid){

        return projectService.typeFour(industryCategoryGuid, managementPowerGuid);
    }

    // 投资完成率
    @GetMapping(value = "typeFive")
    public List<ReturnModel> typeFive(String industryCategoryGuid, String managementPowerGuid){

        return projectService.typeFive(industryCategoryGuid, managementPowerGuid);
    }

    // 条件查询
    @GetMapping(value = "conditionSelect")
    public List<ReturnModel> conditionSelect(Integer typeId, String industryCategoryGuid, String managementPowerGuid){

        return projectService.conditionSelect(typeId, industryCategoryGuid, managementPowerGuid);
    }

}
