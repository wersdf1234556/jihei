package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProjectQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.support.ReturnProjectModel;
import org.tonzoc.service.IProjectService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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
    public List<ReturnProjectModel> dateAll(){

        return projectService.dateAll();
    }

    // 项目数
    @GetMapping(value = "typeTwo")
    public List<ReturnProjectModel> typeTwo(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        return projectService.typeTwo(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
    }

    // 总投资额
    @GetMapping(value = "typeThree")
    public List<ReturnProjectModel> typeThree(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        return projectService.typeThree(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
    }

    // 已完成投资额
    @GetMapping(value = "typeFour")
    public List<ReturnProjectModel> typeFour(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        return projectService.typeFour(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
    }

    // 投资完成率
    @GetMapping(value = "typeFive")
    public List<ReturnProjectModel> typeFive(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        return projectService.typeFive(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
    }

    // 百大项目
    @GetMapping(value = "hundredOne")
    public List<ReturnProjectModel> hundredOne(String projectStateGuid){

        return projectService.hundredOne(projectStateGuid);
    }

    // 百大铁路
    @GetMapping(value = "hundredTwo")
    public List<ReturnProjectModel> hundredTwo(){

        return projectService.hundredTwo();
    }

    // 百大公路
    @GetMapping(value = "hundredThree")
    public List<ReturnProjectModel> hundredThree(){

        return projectService.hundredThree();
    }

    // 百大机场
    @GetMapping(value = "hundredFour")
    public List<ReturnProjectModel> hundredFour(){

        return projectService.hundredFour();
    }

    // 百大水运
    @GetMapping(value = "hundredFive")
    public List<ReturnProjectModel> hundredFive(){

        return projectService.hundredFive();
    }

    // 项目情况
    @GetMapping(value = "projectSelect")
    public List<ReturnProjectModel> projectSelect(){

        return projectService.dateAll();
    }

    // 条件查询
    @GetMapping(value = "conditionSelect")
    public Map<String ,List<ReturnProjectModel>> conditionSelect(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid){

        return projectService.conditionSelect(industryCategoryGuid, managementPowerGuid, buildLevelGuid);
    }

    // 百大查询
    @GetMapping(value = "hundredSelect")
    public  Map<String, List<ReturnProjectModel>> hundredSelect(){

        return projectService.hundredSelect();
    }

}
