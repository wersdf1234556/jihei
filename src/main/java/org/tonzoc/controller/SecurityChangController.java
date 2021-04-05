package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SecurityChangQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.SecurityChangModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.service.ISecurityChangService;
import org.tonzoc.service.ISecurityService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("securityChang")
@Transactional
public class SecurityChangController extends BaseController{

    @Autowired
    private ISecurityChangService securityChangService;

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private IRedisAuthService redisAuthService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SecurityChangQueryParams securityChangQueryParams,String accounType, String flag)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SecurityChangModel> page = parsePage(pageQueryParams);

        // 监理
        if (accounType != null) {
            if (accounType.equals("2") && "0".equals(flag)){
                // flag = 0 施工单位查到未提交，监理查不到
                securityChangQueryParams.setStatus("submitted,unFinish,finish");
            }else if (accounType.equals("0") && "1".equals(flag)){
                securityChangQueryParams.setStatus("submitted,unFinish,finish");
            }
        }
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(securityChangQueryParams);
        List<SecurityChangModel> list = securityChangService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(SecurityChangModel securityChangModel, MultipartFile[] file, Integer fileType) throws Exception {

        securityChangService.add(securityChangModel, file, fileType, "0");
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityChangModel securityChangModel) throws Exception {

        UserModel userModel = redisAuthService.getCurrentUser();
        securityChangService.updateStack(securityChangModel, userModel);
        this.securityChangService.update(securityChangModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {

        UserModel userModel = redisAuthService.getCurrentUser();
        this.securityChangService.removeStack(guid, userModel);
    }

    // 提交
    @PostMapping(value = "submit")
    public void submit(String securityChangGuid){

        securityChangService.submit(securityChangGuid);
    }

    // 审批
    @PostMapping(value = "approval")
    public void approval(String securityChangGuid, Integer flag, String approvalScore) throws Exception {

        securityChangService.approval(securityChangGuid, flag, approvalScore);
    }
}