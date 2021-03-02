package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.UnsafeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.UnsafeModel;
import org.tonzoc.service.IUnsafeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "unsafe")
public class UnsafeController extends BaseController {

    @Autowired
    private IUnsafeService unsafeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, UnsafeQueryParams unsafeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<UnsafeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(unsafeQueryParams);
        List<UnsafeModel> list = unsafeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid UnsafeModel unsafeModel) {
        this.unsafeService.save(unsafeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid UnsafeModel unsafeModel) {
        this.unsafeService.update(unsafeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.unsafeService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        unsafeService.removeMany(guids);
    }

    @GetMapping(value = "count")
    public List<ReturnModel> count(){

        return unsafeService.count();
    }
}
