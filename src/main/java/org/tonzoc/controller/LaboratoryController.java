package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.LaboratoryQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.LaboratoryModel;
import org.tonzoc.model.SubTypeModel;
import org.tonzoc.service.ILaboratoryService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("laboratory")
public class LaboratoryController extends BaseController {

    @Autowired
    private ILaboratoryService laboratoryService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, LaboratoryQueryParams laboratoryQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SubTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(laboratoryQueryParams);
        List<LaboratoryModel> list = laboratoryService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(LaboratoryModel laboratoryModel) {
        this.laboratoryService.save(laboratoryModel);
    }

    @PutMapping(value = "{guid}")
    public void update(LaboratoryModel laboratoryModel) {
        this.laboratoryService.update(laboratoryModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.laboratoryService.remove(guid);
    }
}
