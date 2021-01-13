package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.StepTypeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.StepTypeModel;
import org.tonzoc.service.IStepTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "stepType")
public class StepTypeController extends BaseController {

    @Autowired
    private IStepTypeService stepTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, StepTypeQueryParams stepTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<StepTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(stepTypeQueryParams);
        List<StepTypeModel> list = stepTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid StepTypeModel stepTypeModel) {
        this.stepTypeService.save(stepTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid StepTypeModel stepTypeModel) {
        this.stepTypeService.update(stepTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.stepTypeService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        stepTypeService.removeMany(guids);
    }
}
