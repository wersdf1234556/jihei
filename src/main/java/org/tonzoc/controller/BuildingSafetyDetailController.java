package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BuildingSafetyDetailQueryParams;
import org.tonzoc.controller.params.BuildingSafetyQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BuildingSafetyDetailModel;
import org.tonzoc.model.BuildingSafetyModel;
import org.tonzoc.model.ReturnBuildingModel;
import org.tonzoc.service.IBuildingSafetyDetailService;
import org.tonzoc.service.IBuildingSafetyService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("buildingSafetyDetail")
public class BuildingSafetyDetailController extends BaseController{
    @Autowired
    private IBuildingSafetyDetailService buildingSafetyDetailService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BuildingSafetyDetailQueryParams buildingSafetyDetailQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BuildingSafetyDetailModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(buildingSafetyDetailQueryParams);
        List<BuildingSafetyDetailModel> list = buildingSafetyDetailService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BuildingSafetyDetailModel buildingSafetyDetailModel) {

        this.buildingSafetyDetailService.save(buildingSafetyDetailModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BuildingSafetyDetailModel buildingSafetyDetailModel) {

        this.buildingSafetyDetailService.update(buildingSafetyDetailModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.buildingSafetyDetailService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        buildingSafetyDetailService.removeMany(guids);
    }

    // 工作量
    @GetMapping(value = "workload")
    public List<ReturnBuildingModel> workload() {

        return buildingSafetyDetailService.workload();
    }
}