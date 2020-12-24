package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.QualityTraceabilityQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.QualityTraceabilityModel;
import org.tonzoc.service.IQualityTraceabilityService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("qualityTraceability")
public class QualityTraceabilityController extends BaseController {

    @Autowired
    private IQualityTraceabilityService qualityTraceabilityService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, QualityTraceabilityQueryParams laboratoryQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<QualityTraceabilityModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(laboratoryQueryParams);
        List<QualityTraceabilityModel> list = qualityTraceabilityService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid QualityTraceabilityModel laboratoryModel) {
        this.qualityTraceabilityService.save(laboratoryModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid QualityTraceabilityModel laboratoryModel) {
        this.qualityTraceabilityService.update(laboratoryModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.qualityTraceabilityService.remove(guid);
    }

    @DeleteMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        qualityTraceabilityService.removeMany(guids);
    }

    @GetMapping(value = "qrcode")
    public Map<String, String> qrcode(String guid){

        return qualityTraceabilityService.qrcode(guid);
    }

    @PostMapping(value = "upFile")
    public void upFile(MultipartFile[] file, String typeGuid, String subTypeGuid){

        qualityTraceabilityService.upFile(file, typeGuid, subTypeGuid);
    }
}
