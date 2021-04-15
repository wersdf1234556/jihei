package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonTypeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.service.IPersonService;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("personType")
public class PersonTypeController extends BaseController {

    @Autowired
    private IPersonTypeService personTypeService;

    @Autowired
    private IPersonService personService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, PersonTypeQueryParams personTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<PersonModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(personTypeQueryParams);

        List list = personTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid PersonTypeModel personTypeModel) {
        this.personTypeService.save(personTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid PersonTypeModel personTypeModel) {
        if (personTypeModel.getCategoryGuid() != null && !"".equals(personTypeModel.getCategoryGuid())) {
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            sqlQueryParams.add(new SqlQueryParam("personTypeGuid", personTypeModel.getGuid(), "eq"));
            List<PersonModel> list = personService.list(sqlQueryParams);

            for (PersonModel li : list) {
                li.setCategoryGuid(personTypeModel.getCategoryGuid());
                personService.update(li);

            }
        }

        this.personTypeService.update(personTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.personTypeService.remove(guid);
    }

    //@RequestBody(required = false)
    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        personTypeService.removeMany(guids);
    }

    // 按照类型查询数量
    @GetMapping(value = "selectByCategory")
    public List<PersonTypeModel> selectByCategory(String personCategoryGuid, String tenderGuid) {

        return personTypeService.selectByCategory(personCategoryGuid, tenderGuid);
    }

}
