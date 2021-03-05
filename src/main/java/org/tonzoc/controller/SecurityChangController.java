package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SecurityChangQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.SecurityChangModel;
import org.tonzoc.service.ISecurityChangService;
import org.tonzoc.service.ISecurityService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("securityChang")
public class SecurityChangController extends BaseController{

    @Autowired
    private ISecurityChangService securityChangService;

    @Autowired
    private ISecurityService securityService;

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

        if (!"".equals(securityChangModel.getChangDate()) && securityChangModel.getChangDate() != null) {
            securityChangModel.setChangTime(TimeHelper.stringToDate(securityChangModel.getChangDate()));
        }
        if (!"".equals(securityChangModel.getCheckDate()) && securityChangModel.getCheckDate() != null) {
            securityChangModel.setCheckTime(TimeHelper.stringToDate(securityChangModel.getCheckDate()));
        }
        securityChangModel.setStatus("0");
        securityService.updateStatus("1", securityChangModel.getSecurityGuid());
        String guid = new FileHelper().newGUID();
        securityChangModel.setGuid(guid);
        securityService.upFiles(file, "", guid, fileType);
        this.securityChangService.save(securityChangModel);
        securityService.upFiles(file, "", securityChangModel.getGuid(), fileType);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityChangModel securityChangModel) throws ParseException {

        if (!"".equals(securityChangModel.getChangDate()) && securityChangModel.getChangDate() != null) {
            securityChangModel = securityChangService.updateTime(securityChangModel);
        }
        if (!"".equals(securityChangModel.getCheckDate()) && securityChangModel.getCheckDate() != null) {
            securityChangModel.setCheckTime(TimeHelper.stringToDate(securityChangModel.getCheckDate()));
        }
        this.securityChangService.update(securityChangModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.securityChangService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        this.securityChangService.removeMany(guids);
    }
}
