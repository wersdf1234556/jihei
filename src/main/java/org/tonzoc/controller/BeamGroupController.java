package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamGroupQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamGroupModel;
import org.tonzoc.service.IBeamGroupService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "beamGroup")
public class BeamGroupController extends BaseController{

    @Autowired
    private IBeamGroupService beamGroupService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamGroupQueryParams beamGroupQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamGroupModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamGroupQueryParams);
        List<BeamGroupModel> list = beamGroupService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamGroupModel beamGroupModel) throws Exception {

        beamGroupService.save(beamGroupModel);
    }

    // 修改台座等信息
    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamGroupModel beamGroupModel) throws Exception {

        beamGroupService.update(beamGroupModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {

        beamGroupService.delete(guid);
    }
}
