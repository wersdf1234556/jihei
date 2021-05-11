package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamPedestalQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.ReturnListModel;
import org.tonzoc.model.support.ReturnQtbModel;
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

        beamPedestalModel.setStatus("unSubmit");
        beamPedestalModel.setColor("rgba(255, 255, 255,0)");
        beamPedestalService.save(beamPedestalModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamPedestalModel beamPedestalModel) {

        beamPedestalService.update(beamPedestalModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {

        beamPedestalService.delete(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamPedestalService.deletes(guids);
    }

    // 按类别统计台座数量和梁的数量
    @GetMapping(value = "listByStatus")
    public List<ReturnQtbModel> listByStatus(String tenderGuid){

        return beamPedestalService.listByStatus(tenderGuid);
    }
}
