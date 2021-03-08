package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SecurityQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.service.ISecurityService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("security")
public class SecurityController extends BaseController {

    @Autowired
    private ISecurityService securityService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SecurityQueryParams securityQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SecurityModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(securityQueryParams);
        List<SecurityModel> list = securityService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid SecurityModel securityModel, MultipartFile[] file, Integer fileType) throws ParseException {

        securityModel.setStatus("unSubmit");
        securityModel.setCurrentTenderGuid(securityModel.getTenderGuid());

        this.securityService.save(securityModel);
        securityService.upFiles(file, securityModel.getGuid(), "", fileType);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityModel securityModel) throws Exception {

        securityService.updateStack(securityModel);
        this.securityService.update(securityModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {

        this.securityService.removeStack(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        this.securityService.batchRemoveStack(guids);
    }

    // 上传安全文件
    @PostMapping(value = "upFile")
    public Map<String, String> upFile(MultipartFile file, String securityGuid, String securityChangGuid, Integer fileType) {

        return securityService.upFile(file, securityGuid, securityChangGuid, fileType);
    }

    // 安全上传多文件
    @PostMapping(value = "/upFiles")
    public void upFiles(MultipartFile[] file, String securityGuid, String securityChangGuid, Integer fileType) {

        securityService.upFiles(file, securityGuid, securityChangGuid, fileType);
    }

    /*// 添加多条并修改分数
    @PostMapping(value = "adds")
    public void adds(List<SecurityModel> list) {

        securityService.adds(list);
    }*/

    // 安全统计
    @GetMapping(value = "securityStatics")
    public List<ReturnModel> securityStatics() {

        return securityService.securityStatics();
    }

    // 安全隐患排查
    @GetMapping(value = "unsafeSelect")
    public List<SecurityModel> unsafeSelect() {

        return securityService.unsafeSelect();
    }

    // 提交
    @PostMapping(value = "submit")
    public void submit(String securityGuid, String currentTenderGuid){

        securityService.submit(securityGuid, currentTenderGuid);
    }

    // 批量提交
    @PostMapping(value = "batchApproval")
    public void batchApproval(String securityGuid, String currentTenderGuid, Integer flag) {

        securityService.batchApproval(securityGuid, currentTenderGuid, flag);
    }
}