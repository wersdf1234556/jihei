package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamStatusQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamStatusModel;
import org.tonzoc.service.IBeamStatusService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "beamStatus")
public class BeamStatusController extends BaseController{

    @Autowired
    private IBeamStatusService beamStatusService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamStatusQueryParams beamStatusQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamStatusModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamStatusQueryParams);
        List<BeamStatusModel> list = beamStatusService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamStatusModel beamStatusModel) {

        beamStatusService.save(beamStatusModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamStatusModel beamStatusModel) {

        beamStatusService.update(beamStatusModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        beamStatusService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamStatusService.removeMany(guids);
    }
}
