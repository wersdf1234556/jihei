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
    public void add(@RequestBody @Valid SecurityModel securityModel) {

        securityModel.setStatus("start");
        this.securityService.save(securityModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityModel securityModel) {

        this.securityService.update(securityModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.securityService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        this.securityService.removeMany(guids);
    }

    // 判断当前时间是否在这个时间内
    @GetMapping(value = "isTimeInside")
    public String isTimeInside(String documentGuid) {

        return securityService.isTimeInside(documentGuid);
    }

    // 上传安全文件
    @PostMapping(value = "upFile")
    public Map<String, String> upFile(MultipartFile file, Integer judge) {

        return securityService.upFile(file, judge);
    }

    // 添加多条并修改分数
    @PostMapping(value = "adds")
    public void adds(List<SecurityModel> list) {

        securityService.adds(list);
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
}