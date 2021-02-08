package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.CameraPurposeQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.CameraPurposeModel;
import org.tonzoc.service.ICameraPurposeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("cameraPurpose")
public class CameraPurposeController extends BaseController {
    @Autowired
    ICameraPurposeService cameraPurposeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, CameraPurposeQueryParams cameraPurposeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println(pageQueryParams.getOrder());
        Page<CameraPurposeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(cameraPurposeQueryParams);
        List list = cameraPurposeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid CameraPurposeModel cameraPurposeModel) {
        this.cameraPurposeService.save(cameraPurposeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid CameraPurposeModel cameraPurposeModel) {
        this.cameraPurposeService.update(cameraPurposeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.cameraPurposeService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        cameraPurposeService.removeMany(guids);
    }
}
