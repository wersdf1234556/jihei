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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
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
        this.attachmentSecurityService.deleteFile(guid);
        this.attachmentSecurityService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        this.attachmentSecurityService.deleteFile(guids);
        this.attachmentSecurityService.removeMany(guids);
    }

    // 预览图片
    @GetMapping(value = "image/{guid}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "guid") String guid) throws IOException {

        return attachmentSecurityService.getImage(guid);
    }

    // 预览视频
    @GetMapping(value = "video/{guid}")
    public void getVideo(HttpServletRequest request, HttpServletResponse response, String attachmentSecurityGuid){

        attachmentSecurityService.getVideo(request, response, attachmentSecurityGuid);
    }
}
