package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.CameraTypeQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonCategoryQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.CameraTypeModel;
import org.tonzoc.model.PersonCategoryModel;
import org.tonzoc.service.ICameraTypeService;
import org.tonzoc.service.IPersonCategoryService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("personCategory")
public class PersonCategoryController extends BaseController {

    @Autowired
    private IPersonCategoryService personCategoryService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, PersonCategoryQueryParams personCategoryQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println(pageQueryParams.getOrder());
        Page<CameraTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(personCategoryQueryParams);
        List list = personCategoryService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid PersonCategoryModel personCategoryModel) {
        this.personCategoryService.save(personCategoryModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid PersonCategoryModel personCategoryModel) {
        this.personCategoryService.update(personCategoryModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.personCategoryService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        personCategoryService.removeMany(guids);
    }

}
