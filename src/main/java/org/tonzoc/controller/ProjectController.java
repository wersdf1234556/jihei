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

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        this.projectService.removeMany(guids);
    }

    // 全部项目的数据
    @GetMapping(value = "dateAll")
    public List<ReturnProjectModel> dateAll(Integer isImportant){

        return projectService.dateAll(isImportant);
    }

    // 总投资额
    @GetMapping(value = "typeThree")
    public List<ReturnProjectModel> typeThree(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant){

        return projectService.typeThree(industryCategoryGuid, managementPowerGuid, buildLevelGuid, isImportant);
    }

    // 数量
    @GetMapping(value = "typeFour")
    public List<ReturnProjectModel> typeFour(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant){

        return projectService.typeFour(industryCategoryGuid, managementPowerGuid, buildLevelGuid, isImportant);
    }

    // 投资完成率
    @GetMapping(value = "typeFive")
    public List<ReturnProjectModel> typeFive(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant){

        return projectService.typeFive(industryCategoryGuid, managementPowerGuid, buildLevelGuid, isImportant);
    }

    // 百大项目
    @GetMapping(value = "hundredOne")
    public List<ReturnProjectModel> hundredOne(String industryCategoryGuid){

        return projectService.hundredOne(industryCategoryGuid);
    }

    // 项目情况
    @GetMapping(value = "projectSelect")
    public List<ReturnProjectModel> projectSelect(Integer isImportant){

        return projectService.dateAll(isImportant);
    }

    // 条件查询
    @GetMapping(value = "conditionSelect")
    public Map<String ,List<ReturnProjectModel>> conditionSelect(String industryCategoryGuid, String managementPowerGuid, String buildLevelGuid, Integer isImportant){

        return projectService.conditionSelect(industryCategoryGuid, managementPowerGuid, buildLevelGuid, isImportant);
    }

    // 百大查询
    @GetMapping(value = "hundredSelect")
    public  Map<String, List<ReturnProjectModel>> hundredSelect(){

        return projectService.hundredSelect();
    }

}
