package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProgressDetailQueryParams;
import org.tonzoc.controller.params.ProgressTotalDataQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProgressDetailModel;
import org.tonzoc.model.ProgressTotalDataModel;
import org.tonzoc.model.support.ProgressStatModel;
import org.tonzoc.service.IProgressDetailService;
import org.tonzoc.service.IProgressTotalDataService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("progressTotalData")
public class ProgressTotalDataController extends BaseController {

    @Autowired
    private IProgressTotalDataService progressTotalDataService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProgressTotalDataQueryParams progressTotalDataQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProgressTotalDataModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(progressTotalDataQueryParams);

        List list = progressTotalDataService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid ProgressTotalDataModel progressTotalDataModel) {
        this.progressTotalDataService.save(progressTotalDataModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ProgressTotalDataModel progressTotalDataModel) {
        this.progressTotalDataService.update(progressTotalDataModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.progressTotalDataService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String  guids) throws Exception {
        progressTotalDataService.removeMany(guids);
    }


}
