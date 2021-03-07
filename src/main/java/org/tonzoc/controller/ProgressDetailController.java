package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProgressDetailQueryParams;
import org.tonzoc.controller.params.ProjectQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProgressDetailModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.model.support.ProgressStatModel;
import org.tonzoc.service.IProgressDetailService;
import org.tonzoc.service.IProjectService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("progressDetail")
public class ProgressDetailController extends BaseController {

    @Autowired
    private IProgressDetailService progressDetailService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProgressDetailQueryParams progressDetailQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProgressDetailModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(progressDetailQueryParams);

        List list = progressDetailService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid ProgressDetailModel progressDetailModel) {
        this.progressDetailService.save(progressDetailModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ProgressDetailModel progressDetailModel) throws Exception {
        this.progressDetailService.updateStack(progressDetailModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.progressDetailService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        progressDetailService.removeMany(guids);
    }

    @GetMapping(value = "statCurrentMonth")
    public List<ProgressStatModel> statCurrentMonth(String tender,String date){
        return progressDetailService.statCurrentMonth(tender,date);
    }

    @GetMapping(value = "getNextTender")
    public String getNextTender(String tenderGuid){
        return progressDetailService.getNextTender(tenderGuid);
    }
}
