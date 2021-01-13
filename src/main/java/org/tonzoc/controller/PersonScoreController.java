package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonScoreQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.PersonScoreModel;
import org.tonzoc.service.IPersonScoreService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("personScore")
public class PersonScoreController extends BaseController {

    @Autowired
    private IPersonScoreService personScoreService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, PersonScoreQueryParams personScoreQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<PersonScoreModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(personScoreQueryParams);

        List<PersonScoreModel> list = personScoreService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid PersonScoreModel personScoreModel ) {
        this.personScoreService.save(personScoreModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid PersonScoreModel personScoreModel) {
        this.personScoreService.update(personScoreModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.personScoreService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        personScoreService.removeMany(guids);
    }

    // 大屏展示人员分数
    @GetMapping(value = "display")
    public List<PersonScoreModel> display(){

        return personScoreService.display();
    }
}
