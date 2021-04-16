package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamPrefabricationQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.service.IBeamPrefabricationService;
import org.tonzoc.support.param.SqlQueryParam;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "beamPrefabrication")
public class BeamPrefabricationController extends BaseController{

    @Autowired
    private IBeamPrefabricationService beamPrefabricationService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamPrefabricationQueryParams beamPrefabricationQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamPrefabricationModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamPrefabricationQueryParams);
        List<BeamPrefabricationModel> list = beamPrefabricationService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamPrefabricationModel beamPrefabricationModel) {

        beamPrefabricationService.save(beamPrefabricationModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamPrefabricationModel beamPrefabricationModel) {

        beamPrefabricationService.update(beamPrefabricationModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        beamPrefabricationService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamPrefabricationService.removeMany(guids);
    }
}
