package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.TenderScoreQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.TenderScoreModel;
import org.tonzoc.service.ITenderScoreService;
import org.tonzoc.service.ITenderService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("tenderScore")
public class TenderScoreController extends BaseController {

    @Autowired
    private ITenderScoreService tenderScoreService;

    @Autowired
    private ITenderService tenderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, TenderScoreQueryParams tenderScoreQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<TenderScoreModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(tenderScoreQueryParams);
        List<TenderScoreModel> list = tenderScoreService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid TenderScoreModel tenderScoreModel) {

        this.tenderScoreService.save(tenderScoreModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid TenderScoreModel tenderScoreModel) {

        this.tenderScoreService.update(tenderScoreModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.tenderScoreService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        this.tenderScoreService.removeMany(guids);
    }

    // 大屏展示标段
    @GetMapping(value = "display")
    public List<TenderScoreModel> display(){

        return tenderScoreService.display();
    }
}
