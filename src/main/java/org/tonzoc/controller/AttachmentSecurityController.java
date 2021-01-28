package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.AttachmentSecurityQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AttachmentSecurityModel;
import org.tonzoc.service.IAttachmentSecurityService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "attachmentSecurity")
public class AttachmentSecurityController extends BaseController {

    @Autowired
    private IAttachmentSecurityService attachmentSecurityService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AttachmentSecurityQueryParams attachmentSecurityQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<AttachmentSecurityModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(attachmentSecurityQueryParams);
        List<AttachmentSecurityModel> list = attachmentSecurityService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid AttachmentSecurityModel attachmentSecurityModel) {
        this.attachmentSecurityService.save(attachmentSecurityModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid AttachmentSecurityModel attachmentSecurityModel) {
        this.attachmentSecurityService.update(attachmentSecurityModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.attachmentSecurityService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        attachmentSecurityService.removeMany(guids);
    }
}
