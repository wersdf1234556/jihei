package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamSecurityQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamSecurityModel;
import org.tonzoc.service.IBeamSecurityService;
import org.tonzoc.support.param.SqlQueryParam;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("beamSecurity")
public class BeamSecurityController extends BaseController{

    @Autowired
    private IBeamSecurityService beamSecurityService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamSecurityQueryParams beamSecurityQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamSecurityModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamSecurityQueryParams);
        List<BeamSecurityModel> list = beamSecurityService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamSecurityModel beamSecurityModel) {

        this.beamSecurityService.save(beamSecurityModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamSecurityModel beamSecurityModel) {

        this.beamSecurityService.update(beamSecurityModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.beamSecurityService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamSecurityService.removeMany(guids);
    }
}
