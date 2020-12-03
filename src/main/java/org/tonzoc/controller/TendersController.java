package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.TendersQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.TendersModel;
import org.tonzoc.service.ITendersService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("tenders")
public class TendersController extends BaseController {

    @Autowired
    private ITendersService tendersService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, TendersQueryParams tendersQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(tendersQueryParams);

        List list = tendersService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid TendersModel tenderModel) {
        this.tendersService.save(tenderModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid TendersModel tenderModel) {
        this.tendersService.update(tenderModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.tendersService.remove(guid);
    }
}
