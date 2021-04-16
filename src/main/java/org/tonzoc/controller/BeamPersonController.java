package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamPersonQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamPersonModel;
import org.tonzoc.service.IBeamPersonService;
import org.tonzoc.support.param.SqlQueryParam;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("beamPerson")
public class BeamPersonController extends BaseController{

    @Autowired
    private IBeamPersonService beamPersonService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamPersonQueryParams beamPersonQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamPersonModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamPersonQueryParams);
        List<BeamPersonModel> list = beamPersonService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamPersonModel beamPersonModel) {

        this.beamPersonService.save(beamPersonModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamPersonModel beamPersonModel) {

        this.beamPersonService.update(beamPersonModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.beamPersonService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamPersonService.removeMany(guids);
    }
}
