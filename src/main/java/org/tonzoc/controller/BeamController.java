package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamModel;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.service.IBeamPedestalService;
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
    public void add(@RequestBody @Valid BeamModel beamModel,
                    String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception {

        beamService.add(beamModel, concreteStrengthOne, concreteStrengthTwo, concreteStrengthThree, remarks);
    }

    // 修改台座等信息
    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BeamModel beamModel,
                       String concreteStrengthOne, String concreteStrengthTwo, String concreteStrengthThree, String remarks) throws Exception {

        beamService.modify(beamModel, concreteStrengthOne, concreteStrengthTwo, concreteStrengthThree, remarks);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {

        beamService.delete(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        beamService.deletes(guids);
    }

    // 更新信息
    @PutMapping(value = "modify")
    public void modify( BeamModel beamModel, String remarks) throws Exception {

//        beamService.modify(beamModel, remarks);
    }

    // 按照编号查询历史记录
    @GetMapping(value = "listHistory")
    public List<BeamModel> listHistory(String name, String num) {

        return beamService.listHistory(name, num);
    }

    // 查询一条或多条
    @GetMapping(value = "selectOneOrAll")
    public List selectOneOrAll(String tenderGuid, String num) throws Exception {

        return beamService.selectOneOrAll(tenderGuid, num);
    }
}
