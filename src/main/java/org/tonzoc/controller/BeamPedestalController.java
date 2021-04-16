package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamPedestalQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.service.IBeamPedestalService;
import org.tonzoc.support.param.SqlQueryParam;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "beamPedestal")
public class BeamPedestalController extends BaseController{

    @Autowired
    private IBeamPedestalService beamPedestalService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamPedestalQueryParams beamPedestalQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamPedestalModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamPedestalQueryParams);
        List<BeamPedestalModel> list = beamPedestalService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamPedestalModel beamPedestalModel) {

        beamPedestalService.save(beamPedestalModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamPedestalModel beamPedestalModel) {

        beamPedestalService.update(beamPedestalModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        beamPedestalService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamPedestalService.removeMany(guids);
    }
}
