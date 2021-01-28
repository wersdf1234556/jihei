package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.NextStepQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.NextStepModel;
import org.tonzoc.service.INextStepService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "nextStep")
public class NextStepController extends BaseController {

    @Autowired
    private INextStepService nextStepService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, NextStepQueryParams nextStepQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<NextStepModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(nextStepQueryParams);
        List<NextStepModel> list = nextStepService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid NextStepModel nextStepModel) {
        this.nextStepService.save(nextStepModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid NextStepModel nextStepModel) {
        this.nextStepService.update(nextStepModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.nextStepService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        nextStepService.removeMany(guids);
    }
}
