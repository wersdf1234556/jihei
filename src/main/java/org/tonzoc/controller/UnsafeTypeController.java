package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.UnsafeQueryParams;
import org.tonzoc.controller.params.UnsafeTypeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.UnsafeTypeModel;
import org.tonzoc.service.IUnsafeTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RequestMapping("unsafeType")
@RestController
public class UnsafeTypeController extends BaseController{

    @Autowired
    private IUnsafeTypeService unsafeTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, UnsafeTypeQueryParams unsafeTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<UnsafeTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(unsafeTypeQueryParams);
        List<UnsafeTypeModel> list = unsafeTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid UnsafeTypeModel unsafeTypeModel) {
        this.unsafeTypeService.save(unsafeTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid UnsafeTypeModel unsafeTypeModel) {
        System.out.println("weisa");
        this.unsafeTypeService.update(unsafeTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.unsafeTypeService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        unsafeTypeService.removeMany(guids);
    }
}
