package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.StepPersonQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.StepPersonModel;
import org.tonzoc.service.IStepPersonService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "stepPerson")
public class StepPersonController extends BaseController {

    @Autowired
    private IStepPersonService stepPersonService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, StepPersonQueryParams stepPersonQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<StepPersonModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(stepPersonQueryParams);
        List<StepPersonModel> list = stepPersonService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid StepPersonModel stepPersonModel) {
        this.stepPersonService.save(stepPersonModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid StepPersonModel stepPersonModel) {
        this.stepPersonService.update(stepPersonModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.stepPersonService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        stepPersonService.removeMany(guids);
    }
}
