package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamOrderQueryParams;import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamOrderModel;
import org.tonzoc.service.IBeamOrderService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "beamOrder")
public class BeamOrderController extends BaseController{

    @Autowired
    private IBeamOrderService beamOrderService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamOrderQueryParams beamOrderQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamOrderModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamOrderQueryParams);
        List<BeamOrderModel> list = beamOrderService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamOrderModel beamOrderModel) {

        beamOrderService.add(beamOrderModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamOrderModel beamOrderModel) {

        beamOrderService.update(beamOrderModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        beamOrderService.delete(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamOrderService.removeMany(guids);
    }
}
