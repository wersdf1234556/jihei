package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamCameraQueryParams;
import org.tonzoc.controller.params.BeamQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamCameraModel;
import org.tonzoc.model.BeamModel;
import org.tonzoc.service.IBeamCameraService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "beamCamera")
public class BeamCameraController extends BaseController{

    @Autowired
    private IBeamCameraService beamCameraService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BeamCameraQueryParams beamCameraQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BeamCameraModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(beamCameraQueryParams);
        List<BeamCameraModel> list = beamCameraService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid BeamCameraModel beamCameraModel) throws Exception {

        beamCameraService.save(beamCameraModel);
    }

    // 修改台座等信息
    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamCameraModel beamCameraModel) throws Exception {

        beamCameraService.update(beamCameraModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {

        beamCameraService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamCameraService.removeMany(guids);
    }
}
