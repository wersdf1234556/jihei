package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamPersonGroupQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamPersonGroupModel;
import org.tonzoc.service.IBeamPersonGroupService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "beamPersonGroup")
public class BeamPersonGroupController extends BaseController{

    @Autowired
    private IBeamPersonGroupService beamPersonGroupService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamPersonGroupQueryParams beamPersonGroupQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamPersonGroupModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamPersonGroupQueryParams);
        List<BeamPersonGroupModel> list = beamPersonGroupService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamPersonGroupModel beamPersonGroupModel) {

        beamPersonGroupService.add(beamPersonGroupModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamPersonGroupModel beamPersonGroupModel) {

        beamPersonGroupService.update(beamPersonGroupModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        beamPersonGroupService.delete(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamPersonGroupService.deletes(guids);
    }
}
