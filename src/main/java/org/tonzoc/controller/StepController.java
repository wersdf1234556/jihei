package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.StepQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.StepModel;
import org.tonzoc.service.IStepService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "step")
public class StepController extends BaseController {

    @Autowired
    private IStepService stepService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, StepQueryParams stepQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<StepModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(stepQueryParams);
        List<StepModel> list = stepService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid StepModel stepModel) {
        this.stepService.save(stepModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid StepModel stepModel) {
        this.stepService.update(stepModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.stepService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        stepService.removeMany(guids);
    }
}
