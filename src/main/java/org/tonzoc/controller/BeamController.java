package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BeamQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BeamModel;
import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.model.ReturnBeamCount;
import org.tonzoc.model.support.ReturnBeamModel;
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

        if (pageQueryParams.getOrder() == null || "".equals(pageQueryParams.getOrder())) {

            pageQueryParams.setOrder("attTime desc, beamPrefabricationName, leftAndRight, prefabricationNum, beamPedestalName, beamPedestalStatus");
            pageQueryParams.setSort("asc");
        }
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

    // 按照编号查询历史记录
    @GetMapping(value = "listHistory")
    public List<BeamModel> listHistory(String name, String num, String tenderGuid) {

        return beamService.listHistory(name, num, tenderGuid);
    }

    // 查询一条或多条
    @GetMapping(value = "selectOneOrAll")
    public List selectOneOrAll(String tenderGuid, String num) throws Exception {

        return beamService.selectOneOrAll(tenderGuid, num);
    }

    // 查询名称加左右幅
    @GetMapping(value = "selectNameAndLeftAndRight")
    public List<String> selectNameAndLeftAndRight(String tenderGuid) {

        return beamService.selectNameAndLeftAndRight(tenderGuid);
    }

    // 查询梁的编号
    @GetMapping(value = "selectPrefabricationNum")
    public List<BeamPrefabricationModel> selectPrefabricationNum(String nameAndLeftAndRight, String tenderGuid) {

        nameAndLeftAndRight = nameAndLeftAndRight.replace(" ", "+");
        return beamService.selectPrefabricationNum(nameAndLeftAndRight, tenderGuid);
    }

    // 梁统计查询
    @GetMapping(value = "selectByTender")
    public PageResponse selectByTender(PageQueryParams pageQueryParams, String tenderGuid, String name, String leftAndRight) throws PageException {

        Page<BeamModel> page = parsePage(pageQueryParams);
        List<ReturnBeamCount> list = beamService.selectByTender(tenderGuid, name, leftAndRight);
        return new PageResponse(page.getTotal(), list);
    }

    // 筛选
    @GetMapping(value = "screen")
    public String screen(String tenderGuid, String num) throws Exception {

        return beamService.screen(tenderGuid, num);
    }

    // 按照编号查询历史记录 带分页
    @GetMapping(value = "listHistoryPage")
    public PageResponse listHistoryPage(PageQueryParams pageQueryParams, String name, String num, String beamPrefabricationName, String leftAndRight, String tenderGuid) throws PageException {

        Page<ReturnBeamModel> page = parsePage(pageQueryParams);
        List<ReturnBeamModel> list = beamService.listHistoryPage(name, num, beamPrefabricationName, leftAndRight, tenderGuid);

        return new PageResponse(page.getTotal(), list);
    }
}
