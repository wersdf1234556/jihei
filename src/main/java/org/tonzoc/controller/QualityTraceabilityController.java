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
import org.tonzoc.model.SubTypeModel;
import org.tonzoc.service.IQualityTraceabilityService;
import org.tonzoc.support.param.SqlQueryParam;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("qualityTraceability")
public class QualityTraceabilityController extends BaseController {

    @Autowired
    private IQualityTraceabilityService qualityTraceabilityService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, QualityTraceabilityQueryParams laboratoryQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SubTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(laboratoryQueryParams);
        List<QualityTraceabilityModel> list = qualityTraceabilityService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(QualityTraceabilityModel laboratoryModel) {
        this.qualityTraceabilityService.save(laboratoryModel);
    }

    @PutMapping(value = "{guid}")
    public void update(QualityTraceabilityModel laboratoryModel) {
        this.qualityTraceabilityService.update(laboratoryModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.qualityTraceabilityService.remove(guid);
    }

    @GetMapping(value = "qrcode")
    public String qrcode(String guid){

        return qualityTraceabilityService.qrcode(guid);
    }

    @GetMapping(value = "upFile")
    public String upFile(MultipartFile file, Date currentTime) {

        return qualityTraceabilityService.upFile(file, currentTime);
    }
}
