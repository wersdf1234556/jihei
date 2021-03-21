package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SecurityQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.ISecurityService;
import org.tonzoc.service.ITenderScoreService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("security")
@Transactional
public class SecurityController extends BaseController {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private IRedisAuthService redisAuthService;

    @Autowired
    private ITenderScoreService tenderScoreService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SecurityQueryParams securityQueryParams, String accounType, String flag)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SecurityModel> page = parsePage(pageQueryParams);

        // 监理
        if (accounType != null) {
            if (accounType.equals("2") && "0".equals(flag)){
                // flag = 0 施工单位查到未提交，监理查不到
                securityQueryParams.setStatus("submitted,unFinish,finish");
            }else if (accounType.equals("0") && "1".equals(flag)){
                securityQueryParams.setStatus("submitted,unFinish,finish");
            }
        }
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(securityQueryParams);
        List<SecurityModel> list = securityService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(SecurityModel securityModel, MultipartFile[] file, Integer fileType, String accounType) throws ParseException {

        securityService.add(securityModel, file, fileType, accounType);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityModel securityModel) throws Exception {

        securityService.updateStack(securityModel);  // 判断状态是否能修改
        this.securityService.update(securityModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {

        this.securityService.removeStack(guid);
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
    public void submit(String securityGuid){

        securityService.submit(securityGuid);
    }

    // 判断当前分数超过10天改状态
    @GetMapping(value = "updateIsEffect")
    public void updateIsEffect() throws ParseException {

        securityService.updateIsEffect();
    }

    // 查询分数
    @GetMapping(value = "selectScore")
    public List<ReturnModel> selectScore() throws ParseException {

       return securityService.selectScore();
    }
}