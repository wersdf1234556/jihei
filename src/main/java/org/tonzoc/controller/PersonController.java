package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonQueryParams;
import org.tonzoc.controller.params.ProjectQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.service.IPersonService;
import org.tonzoc.service.IProjectService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, PersonQueryParams personQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<PersonModel> page = parsePage(pageQueryParams);
        PersonQueryParams sqlQueryParamList = new PersonQueryParams();
        if (personQueryParams.getGuid() != null && !personQueryParams.getGuid().equals("")) {
            sqlQueryParamList.setGuid(personQueryParams.getGuid());
        }if (personQueryParams.getName() != null && !personQueryParams.getName().equals("")) {
            sqlQueryParamList.setName(personQueryParams.getName());
        }if (personQueryParams.getTenderGuid() != null && !personQueryParams.getTenderGuid().equals("")) {
            sqlQueryParamList.setTenderGuid(personQueryParams.getTenderGuid());
        }
        if (personQueryParams.getPersonTypeGuid() != null && !personQueryParams.getPersonTypeGuid().equals("")) {
            sqlQueryParamList.setPersonTypeGuid(personQueryParams.getPersonTypeGuid());
        }

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(sqlQueryParamList);

        List list = personService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid PersonModel personModel ) {
        this.personService.save(personModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid PersonModel personModel) {
        this.personService.update(personModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.personService.remove(guid);
    }

}
