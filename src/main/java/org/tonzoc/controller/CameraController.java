package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.CameraQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.CameraModel;
import org.tonzoc.service.ICameraService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
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
        CameraQueryParams sqlQueryParamList = new CameraQueryParams();
        if (camerasQueryParams.getName() != null && !camerasQueryParams.getName().equals("")) {
            sqlQueryParamList.setName(camerasQueryParams.getName());
        }if (camerasQueryParams.getDeviceSerial() != null && !camerasQueryParams.getDeviceSerial().equals("")) {
            sqlQueryParamList.setDeviceSerial(camerasQueryParams.getDeviceSerial());
        }if (camerasQueryParams.getTypeGuid() != null && !camerasQueryParams.getTypeGuid().equals("")) {
            sqlQueryParamList.setTypeGuid(camerasQueryParams.getTypeGuid());
        }if (camerasQueryParams.getTenderGuid() != null && !camerasQueryParams.getTenderGuid().equals("")) {
            sqlQueryParamList.setTenderGuid(camerasQueryParams.getTenderGuid());
        }if (camerasQueryParams.getStatus()==null){
            sqlQueryParamList.setStatus(0);
        }
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(sqlQueryParamList);
        List list = cameraService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid CameraModel cameraModel) {
        this.cameraService.insertStack(cameraModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid CameraModel cameraModel) {
        this.cameraService.update(cameraModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.cameraService.remove(guid);
    }

    @DeleteMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        cameraService.removeMany(guids);
    }

}
