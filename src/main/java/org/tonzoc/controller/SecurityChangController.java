package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("securityChang")
public class SecurityChangController extends BaseController{

    @Autowired
    private ISecurityChangService securityChangService;

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private IRedisAuthService redisAuthService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SecurityChangQueryParams securityChangQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SecurityChangModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(securityChangQueryParams);
        List<SecurityChangModel> list = securityChangService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid SecurityChangModel securityChangModel, MultipartFile[] file, Integer fileType) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        securityService.updateStatus("finish", df.format(new Date()), "*" , securityChangModel.getSecurityGuid()); // 最终审批

        securityChangModel.setStatus("unSubmit");
        securityChangModel.setCurrentTenderGuid(securityChangModel.getTenderGuid());
        this.securityChangService.save(securityChangModel);
        securityService.upFiles(file, "", securityChangModel.getGuid(), fileType);
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

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        UserModel userModel = redisAuthService.getCurrentUser();
        this.securityChangService.batchRemoveStack(guids, userModel);
    }

}