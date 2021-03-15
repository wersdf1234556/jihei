package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SecurityQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.TenderScoreModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.ISecurityService;
import org.tonzoc.service.ITenderScoreService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("security")
public class SecurityController extends BaseController {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private IRedisAuthService redisAuthService;

    @Autowired
    private ITenderScoreService tenderScoreService;

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
        TenderScoreModel tenderScoreModel = new TenderScoreModel();
        tenderScoreModel.setTenderGuid(securityModel.getCurrentTenderGuid());
        tenderScoreModel.setScores(securityModel.getScore());
        tenderScoreService.save(tenderScoreModel);
        securityService.upFiles(file, securityModel.getGuid(), "", fileType);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityModel securityModel) throws Exception {

        UserModel userModel = redisAuthService.getCurrentUser();
        securityService.updateStack(securityModel, userModel);
        this.securityService.update(securityModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {

        UserModel userModel = redisAuthService.getCurrentUser();
        this.securityService.removeStack(guid, userModel);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        UserModel userModel = redisAuthService.getCurrentUser();
        this.securityService.batchRemoveStack(guids, userModel);
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

    // 判断当前分数超过10天改状态
    @GetMapping(value = "updateIsEffect")
    public void updateIsEffect(String oldDate, String guid) throws ParseException {

        securityService.updateIsEffect();
    }

    // 查询分数
    @GetMapping(value = "selectScore")
    public List<ReturnModel> selectScore() throws ParseException {

       return securityService.selectScore();
    }
}