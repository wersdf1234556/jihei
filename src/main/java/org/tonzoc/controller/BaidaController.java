package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BaidaQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BaidaModel;
import org.tonzoc.model.BeamModel;
import org.tonzoc.service.IBaidaService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("baida")
public class BaidaController extends BaseController {

    @Autowired
    private IBaidaService baidaService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BaidaQueryParams baidaQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BaidaModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(baidaQueryParams);
        List list = baidaService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @GetMapping(value = "{guid}")
    public BaidaModel get(@PathVariable(value = "guid") String guid){
        return baidaService.get(guid);
    }
    @PostMapping
    public void add(@RequestBody @Valid BaidaModel baidaModel) {
        this.baidaService.save(baidaModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BaidaModel baidaModel) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.baidaService.update(baidaModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.baidaService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        baidaService.removeMany(guids);
    }

    @GetMapping(value = "getStat")
    public List<BaidaModel> getStat(String categoryGuid, String projectTypeGuid) {
        return this.baidaService.getStat(categoryGuid, projectTypeGuid);
    }

}
