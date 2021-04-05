package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.controller.params.QualityTraceabilityQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.*;
import org.tonzoc.model.support.ReturnQtbModel;
import org.tonzoc.service.IQualityTraceabilityService;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.ISubTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("qualityTraceability")
@Transactional
public class QualityTraceabilityController extends BaseController {

    @Autowired
    private IQualityTraceabilityService qualityTraceabilityService;

    @Autowired
    private ISubTypeService subTypeService;

    @Autowired
    private FileHelper fileHelper;
    @Autowired
    private IRedisAuthService redisAuthService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, QualityTraceabilityQueryParams qualityTraceabilityQueryParams, String accounType, String flag, String currentTenderGuid)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        pageQueryParams.setOrder("currentTime");
        pageQueryParams.setSort(" desc, mainTable.sortId asc");
        Page<QualityTraceabilityModel> page = parsePage(pageQueryParams);
        String flag0 = "submitted,finish";
        // 监理,试验,项目办,领导
        if (accounType != null) {
            if (!"0".equals(accounType) && "0".equals(flag)){
                // flag = 0 施工单位查到未提交，监理查不到
                if (qualityTraceabilityQueryParams.getStatus() == null || "".equals(qualityTraceabilityQueryParams.getStatus())){
                    qualityTraceabilityQueryParams.setStatus(flag0);
                }
                qualityTraceabilityQueryParams.setCurrentTenderGuid(currentTenderGuid);
            }
        }

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(qualityTraceabilityQueryParams);
        List<QualityTraceabilityModel> list = qualityTraceabilityService.list(sqlQueryParams);
        list = qualityTraceabilityService.selected(list);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid QualityTraceabilityModel qualityTraceabilityModel, String accounType) throws Exception {

        this.qualityTraceabilityService.add(qualityTraceabilityModel, accounType);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid QualityTraceabilityModel qualityTraceabilityModel) throws Exception {
        UserModel userModel = redisAuthService.getCurrentUser();
        if (!"".equals(qualityTraceabilityModel.getCurrentDate()) && qualityTraceabilityModel.getCurrentDate() != null) {
            qualityTraceabilityModel = qualityTraceabilityService.updateTime(qualityTraceabilityModel);
        }

        qualityTraceabilityService.updateStack(qualityTraceabilityModel,userModel);
        this.qualityTraceabilityService.update(qualityTraceabilityModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {
        UserModel userModel = redisAuthService.getCurrentUser();
        qualityTraceabilityService.removeStack(guid, userModel);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        UserModel userModel = redisAuthService.getCurrentUser();
        qualityTraceabilityService.batchRemoveStack(guids, userModel);
    }

    // 生成二维码
    @PostMapping(value = "qrcode")
    public Map<String, String> qrcode(String qualityTraceabilityGuid){

        System.out.println("qualityTraceabilityGuid" + qualityTraceabilityGuid);
        return qualityTraceabilityService.qrcode(qualityTraceabilityGuid);
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

    // 提交
    @PostMapping(value = "submit")
    public void submit(String qualityTraceabilityGuid){

        qualityTraceabilityService.submit(qualityTraceabilityGuid);
    }

    // 审批
    @PostMapping(value = "approval")
    public void approval(String qualityTraceabilityGuid, Integer flag, String currentTenderGuid) {

        qualityTraceabilityService.approval(qualityTraceabilityGuid, flag, currentTenderGuid);
    }

    // 批量审批
    @PostMapping(value = "batchApproval")
    public void batchApproval(String qualityTraceabilityGuid, Integer flag, String currentTenderGuid) {

        qualityTraceabilityService.batchApproval(qualityTraceabilityGuid, flag, currentTenderGuid);
    }

    // 标段和类型数量
    @GetMapping(value = "tenderAndNumber")
    public List<ReturnModel> tenderAndNumber(Integer typeId){

        return qualityTraceabilityService.tenderAndNumber(typeId);
    }

    // A B标段和文件数量的另一种格式
    @GetMapping(value = "tenderAndNumbers")
    public List<ReturnQtbModel> tenderAndNumbers(String tenderName){

        return qualityTraceabilityService.tenderAndNumbers(tenderName);
    }

    // Z S标段和文件数量的另一种格式
    @GetMapping(value = "currentTenderAndNumbers")
    public List<ReturnQtbModel> currentTenderAndNumbers(String currentTenderName){

        return qualityTraceabilityService.currentTenderAndNumbers(currentTenderName);
    }
}