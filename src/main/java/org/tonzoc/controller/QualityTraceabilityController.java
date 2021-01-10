package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.controller.params.QualityTraceabilityQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.QualityTraceabilityModel;
import org.tonzoc.service.IQualityTraceabilityService;
import org.tonzoc.service.ISubTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("qualityTraceability")
public class QualityTraceabilityController extends BaseController {

    @Autowired
    private IQualityTraceabilityService qualityTraceabilityService;

    @Autowired
    private ISubTypeService subTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, QualityTraceabilityQueryParams laboratoryQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<QualityTraceabilityModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(laboratoryQueryParams);
        List<QualityTraceabilityModel> list = qualityTraceabilityService.list(sqlQueryParams);
        list = qualityTraceabilityService.selected(list);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid QualityTraceabilityModel qualityTraceabilityModel) throws ParseException {

        Map<String, String> map = this.qrcode(qualityTraceabilityModel.getSubTypeGuid());
        qualityTraceabilityModel.setQrcodeGuid(map.get("attachmentGuid"));

        if (!"".equals(qualityTraceabilityModel.getCurrentDate()) && qualityTraceabilityModel.getCurrentDate() != null) {
            qualityTraceabilityModel.setCurrentTime(TimeHelper.stringToDate(qualityTraceabilityModel.getCurrentDate()));
        }
        if (!"".equals(qualityTraceabilityModel.getSubTypeGuid()) && qualityTraceabilityModel.getSubTypeGuid() != null) {
            qualityTraceabilityModel.setTypeId(subTypeService.get(qualityTraceabilityModel.getSubTypeGuid()).getTypeId());
        }

        this.qualityTraceabilityService.save(qualityTraceabilityModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid QualityTraceabilityModel qualityTraceabilityModel) throws ParseException {

        if (!"".equals(qualityTraceabilityModel.getCurrentDate()) && qualityTraceabilityModel.getCurrentDate() != null) {
            qualityTraceabilityModel = qualityTraceabilityService.updateTime(qualityTraceabilityModel);
        }
        if (!"".equals(qualityTraceabilityModel.getSubTypeGuid()) && qualityTraceabilityModel.getSubTypeGuid() != null) {
            qualityTraceabilityModel.setTypeId(subTypeService.get(qualityTraceabilityModel.getSubTypeGuid()).getTypeId());
        }
        this.qualityTraceabilityService.update(qualityTraceabilityModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.qualityTraceabilityService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        qualityTraceabilityService.removeMany(guids);
    }

    // 生成二维码
    @PostMapping(value = "qrcode")
    public Map<String, String> qrcode(String subTypeGuid){

        return qualityTraceabilityService.qrcode(subTypeGuid);
    }

    // 上传多个质量追溯文件
    @PostMapping(value = "upFiles")
    public void upFiles(MultipartFile[] file, String qualityTraceabilityGuid){

        qualityTraceabilityService.upFiles(file, qualityTraceabilityGuid);
    }

    // 上传质量追溯文件
    @PostMapping(value = "upFile")
    public void upFile(MultipartFile file, String qualityTraceabilityGuid){

        qualityTraceabilityService.upFile(file, qualityTraceabilityGuid);
    }

    // 按照名称模糊查询的功能
    @GetMapping(value = "selectLikeName")
    public List<AttachmentModel> selectLikeName(String name, String qualityTraceabilityGuid) {

       return qualityTraceabilityService.selectLikeName(name, qualityTraceabilityGuid);
    }

    // 按照时间和名称排序
    @GetMapping(value = "selectSortName")
    public PageResponse selectSortName(PageQueryParams pageQueryParams) throws PageException {

        Page<QualityTraceabilityModel> page = parsePage(pageQueryParams);
        List<QualityTraceabilityModel> list = qualityTraceabilityService.selectSortName();

        return new PageResponse(page.getTotal(), list);
    }
}
