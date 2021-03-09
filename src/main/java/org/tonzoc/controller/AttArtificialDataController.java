package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.AttArtificialDataQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AttArtificialDataModel;
import org.tonzoc.model.support.AttendanceStatModel;
import org.tonzoc.model.support.StatTotalModel;
import org.tonzoc.service.IAttArtificialDataService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
//假数据
@RestController
@RequestMapping("attArtificialData")
public class AttArtificialDataController extends BaseController {
    @Autowired
    IAttArtificialDataService attArtificialDataService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AttArtificialDataQueryParams attArtificialDataQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println(pageQueryParams.getOrder());
        Page<AttArtificialDataModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(attArtificialDataQueryParams);
        List list = attArtificialDataService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid AttArtificialDataModel attArtificialDataModel) throws Exception {
        this.attArtificialDataService.save(attArtificialDataModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid AttArtificialDataModel attArtificialDataModel) {
        this.attArtificialDataService.update(attArtificialDataModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.attArtificialDataService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        attArtificialDataService.removeMany(guids);
    }
    @GetMapping(value = "statByCategoryGuid")
    public List<AttendanceStatModel> statAllByCategoryGuid(String categoryGuid){
        return attArtificialDataService.statAllByCategoryGuid(categoryGuid);
    }

    @GetMapping(value = "statAll")
    public StatTotalModel statAll(String categoryGuid){
        return attArtificialDataService.statAll(categoryGuid);
    }

//    @GetMapping(value = "statByTender")
//    public List<Object> statByTender(String categoryGuid){
//        return attArtificialDataService.statByTender(categoryGuid);
//
//    }

//    //首件认可
//    @GetMapping(value = "statArticle")
//    public List<AttendanceStatModel> statArticle(String tenderName){
//        return attArtificialDataService.statArticle(tenderName);
//    }

    @PostMapping(value = "insertAllArti")
    public void insertAllArti(String categoryGuid){
        attArtificialDataService.insertAllArti(categoryGuid);
    }
}
