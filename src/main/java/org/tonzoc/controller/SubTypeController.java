package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SubTypeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.SubTypeModel;
import org.tonzoc.service.ISubTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("subType")
public class SubTypeController extends BaseController {

    @Autowired
    private ISubTypeService subTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SubTypeQueryParams subTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SubTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(subTypeQueryParams);
        List<SubTypeModel> list = subTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid SubTypeModel subTypeModel) {
        this.subTypeService.save(subTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SubTypeModel subTypeModel) {
        this.subTypeService.update(subTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.subTypeService.remove(guid);
    }

    @DeleteMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        subTypeService.removeMany(guids);
    }
}
