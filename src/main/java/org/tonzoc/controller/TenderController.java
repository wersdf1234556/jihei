package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.TenderQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.TenderModel;
import org.tonzoc.service.ITenderService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("tender")
public class TenderController extends BaseController {

    @Autowired
    private ITenderService tenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, TenderQueryParams tenderQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(tenderQueryParams);

        List list = tenderService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid TenderModel tenderModel) {
        this.tenderService.save(tenderModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid TenderModel tenderModel) {
        this.tenderService.update(tenderModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.tenderService.remove(guid);
    }
}
