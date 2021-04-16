package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamModel;
import org.tonzoc.service.IBeamService;
import org.tonzoc.support.param.SqlQueryParam;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "beam")
public class BeamController extends BaseController{

    @Autowired
    private IBeamService beamService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamQueryParams beamQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamQueryParams);
        List<BeamModel> list = beamService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamModel beamModel) {

        beamService.save(beamModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamModel beamModel) {

        beamService.update(beamModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        beamService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamService.removeMany(guids);
    }
}
