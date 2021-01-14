package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonTenderQueryParams;
import org.tonzoc.controller.params.PersonTypeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.PersonTenderModel;
import org.tonzoc.service.IPersonTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "personTender")
public class PersonTenderController extends BaseController {

    @Autowired
    private IPersonTenderService personTenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, PersonTenderQueryParams personTenderQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<PersonTenderModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(personTenderQueryParams);

        List<PersonTenderModel> list = personTenderService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid PersonTenderModel personTenderModel ) {
        this.personTenderService.save(personTenderModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid PersonTenderModel personTenderModel) {
        this.personTenderService.update(personTenderModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.personTenderService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        personTenderService.removeMany(guids);
    }
}
