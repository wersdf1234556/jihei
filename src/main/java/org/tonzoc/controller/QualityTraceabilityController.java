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
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.TenderModel;
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

        pageQueryParams.setOrder("currentTime");
        pageQueryParams.setSort(" desc, mainTable.sortId asc");
        Page<QualityTraceabilityModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(laboratoryQueryParams);
        List<QualityTraceabilityModel> list = qualityTraceabilityService.list(sqlQueryParams);
        list = qualityTraceabilityService.selected(list);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid QualityTraceabilityModel qualityTraceabilityModel) throws ParseException {

        Map<String, String> map = this.qrcode(qualityTraceabilityModel.getGuid());
        qualityTraceabilityModel.setQrcodeGuid(map.get("attachmentGuid"));

        if (!"".equals(qualityTraceabilityModel.getCurrentDate()) && qualityTraceabilityModel.getCurrentDate() != null) {
            qualityTraceabilityModel.setCurrentTime(TimeHelper.stringToDate(qualityTraceabilityModel.getCurrentDate()));
        }

        this.qualityTraceabilityService.save(qualityTraceabilityModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid QualityTraceabilityModel qualityTraceabilityModel) throws ParseException {

        if (!"".equals(qualityTraceabilityModel.getCurrentDate()) && qualityTraceabilityModel.getCurrentDate() != null) {
            qualityTraceabilityModel = qualityTraceabilityService.updateTime(qualityTraceabilityModel);
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
    public Map<String, String> qrcode(String guid){

        return qualityTraceabilityService.qrcode(guid);
    }

    // 上传多个质量追溯文件
    @PostMapping(value = "upFiles")
    public void upFiles(MultipartFile[] file, String qualityTraceabilityGuid, String fileType){

        qualityTraceabilityService.upFiles(file, qualityTraceabilityGuid, fileType);
    }

    // 上传质量追溯文件
    @PostMapping(value = "upFile")
    public void upFile(MultipartFile file, String qualityTraceabilityGuid, String fileType){

        qualityTraceabilityService.upFile(file, qualityTraceabilityGuid, fileType);
    }

    // 按照名称模糊查询的功能
    @GetMapping(value = "selectLikeName")
    public List<AttachmentModel> selectLikeName(String name, String qualityTraceabilityGuid) {

       return qualityTraceabilityService.selectLikeName(name, qualityTraceabilityGuid);
    }

    // 将质量表中的sortId同步
    @PutMapping(value = "updateSortId")
    public void updateSortId(){

        qualityTraceabilityService.updateSortId();
    }

    // 追溯统计
    @GetMapping(value = "traceabilityCount")
    public List<ReturnModel> traceabilityCount(){

        return qualityTraceabilityService.traceabilityCount();
    }

    // 标段统计
    @GetMapping(value = "tenderCount")
    public List<TenderModel> tenderCount(){

        return qualityTraceabilityService.tenderCount();
    }
}