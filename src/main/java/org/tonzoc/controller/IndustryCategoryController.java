package org.tonzoc.controller;


import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.IndustryCategoryQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.IndustryCategoryModel;
import org.tonzoc.service.IIndustryCategoryService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("industryCategory")
public class IndustryCategoryController extends BaseController{

    @Autowired
    private IIndustryCategoryService industryCategoryService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, IndustryCategoryQueryParams industryCategoryQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<IndustryCategoryModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(industryCategoryQueryParams);
        List<IndustryCategoryModel> list = industryCategoryService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid IndustryCategoryModel industryCategoryModel) {

        this.industryCategoryService.save(industryCategoryModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid IndustryCategoryModel industryCategoryModel) {

        this.industryCategoryService.update(industryCategoryModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.industryCategoryService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        industryCategoryService.removeMany(guids);
    }
}
