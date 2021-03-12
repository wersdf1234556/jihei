package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonNucleicInfoQueryParams;
import org.tonzoc.controller.params.PersonQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.PersonNucleicInfoModel;
import org.tonzoc.service.IPersonNucleicInfoService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("personNucleicInfo")
public class PersonNucleicInfoController  extends BaseController{
    @Autowired
    private IPersonNucleicInfoService personNucleicInfoService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, PersonNucleicInfoQueryParams personNucleicInfoQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<PersonNucleicInfoModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(personNucleicInfoQueryParams);

        List list = personNucleicInfoService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid PersonNucleicInfoModel personNucleicInfoModel ){
        this.personNucleicInfoService.save(personNucleicInfoModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid PersonNucleicInfoModel personNucleicInfoModel) {
        this.personNucleicInfoService.update(personNucleicInfoModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.personNucleicInfoService.remove(guid);
    }


    @PostMapping(value = "removeMany")
    public void removeMany(String  guids) throws Exception {
        personNucleicInfoService.removeMany(guids);
    }
}
