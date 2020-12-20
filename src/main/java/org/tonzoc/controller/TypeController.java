package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.TypeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.TypeModel;
import org.tonzoc.service.ITypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("type")
public class TypeController extends BaseController {

    @Autowired
    private ITypeService typeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, TypeQueryParams typeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<TypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(typeQueryParams);
        List<TypeModel> list = typeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid TypeModel typesModel) {
        this.typeService.save(typesModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid TypeModel typesModel) {
        this.typeService.update(typesModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.typeService.remove(guid);
    }
}
