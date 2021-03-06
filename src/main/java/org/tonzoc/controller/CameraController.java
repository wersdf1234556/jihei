package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.controller.params.CameraQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.CameraModel;
import org.tonzoc.service.ICameraService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("camera")
public class CameraController extends BaseController {

    @Autowired
    private ICameraService cameraService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, CameraQueryParams camerasQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (pageQueryParams.getOrder()==null||pageQueryParams.getOrder().isEmpty()){
            if (camerasQueryParams.getTenderGuid()==null||camerasQueryParams.getTenderGuid().isEmpty()){
                pageQueryParams.setOrder("topFlag,mainTable.serialNum,mainTable.sortId");
            }else {
                pageQueryParams.setOrder("topFlag,mainTable.sortId");
            }
        }else {
            if (!pageQueryParams.getOrder().contains("topFlag")){
                pageQueryParams.setOrder("topFlag,mainTable."+pageQueryParams.getOrder());
            }
        }
        if (pageQueryParams.getSort()==null||pageQueryParams.getSort().isEmpty()){
            pageQueryParams.setSort("asc");
        }
        Page<CameraModel> page = parsePage(pageQueryParams);
        if (camerasQueryParams.getStatus()==null){
            camerasQueryParams.setStatus(0);
        }
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(camerasQueryParams);
        List list = cameraService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @GetMapping(value = "{guid}")
    public CameraModel get(@PathVariable(value = "guid") String guid){
        return cameraService.get(guid);
    }
    @PostMapping
    public void add(@RequestBody @Valid CameraModel cameraModel) {
        this.cameraService.insertStack(cameraModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid CameraModel cameraModel) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cameraModel.setUpdatedAt(simpleDateFormat.format(new Date()));
        this.cameraService.update(cameraModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.cameraService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        cameraService.removeMany(guids);
    }

}
