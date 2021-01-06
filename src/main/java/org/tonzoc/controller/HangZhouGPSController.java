package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.HangZhouGPSQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.HangZhouGPSModel;
import org.tonzoc.service.IHangZhouGPSService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("HangZhouGPS")
public class HangZhouGPSController extends BaseController {

    @Autowired
    private IHangZhouGPSService hangZhouGPSService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, HangZhouGPSQueryParams hangZhouGPSQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<HangZhouGPSModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(hangZhouGPSQueryParams);
        List<HangZhouGPSModel> list = hangZhouGPSService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid HangZhouGPSModel hangZhouGPSModel) {

        this.hangZhouGPSService.save(hangZhouGPSModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid HangZhouGPSModel hangZhouGPSModel) {

        this.hangZhouGPSService.update(hangZhouGPSModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.hangZhouGPSService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        hangZhouGPSService.removeMany(guids);
    }
}
