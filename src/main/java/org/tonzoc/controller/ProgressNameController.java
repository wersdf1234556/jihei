package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProgressNameQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProgressNameModel;
import org.tonzoc.service.IProgressNameService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("progressName")
public class ProgressNameController extends BaseController {

    @Autowired
    private IProgressNameService progressNameService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProgressNameQueryParams progressNameQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProgressNameModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(progressNameQueryParams);

        List list = progressNameService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid ProgressNameModel progressNameModel) {
        this.progressNameService.save(progressNameModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ProgressNameModel progressNameModel) {
        this.progressNameService.update(progressNameModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.progressNameService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        progressNameService.removeMany(guids);
    }

}
