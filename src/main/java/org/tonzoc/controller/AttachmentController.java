package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.AttachmentQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("attachment")
public class AttachmentController extends BaseController {

    @Autowired
    IAttachmentService attachmentService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AttachmentQueryParams attachmentQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Page<AttachmentModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(attachmentQueryParams);

        List list = attachmentService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid AttachmentModel attachmentModel) {
        this.attachmentService.save(attachmentModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid AttachmentModel attachmentModel) {
        this.attachmentService.update(attachmentModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        attachmentService.deleteFile(guid);
        this.attachmentService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        attachmentService.deleteFile(guids);
        attachmentService.removeMany(guids);
    }

    // 单文件上传
    @PostMapping(value = "/upFile")
    public void upFile(MultipartFile file, String qualityTraceabilityGuid, String fileType) {

        attachmentService.upFile(file, qualityTraceabilityGuid, fileType);
    }

    // 多文件上传
    @PostMapping(value = "/upFiles")
    public void upFiles(MultipartFile[] file, String qualityTraceabilityGuid, String fileType) {

        attachmentService.upFiles(file, qualityTraceabilityGuid, fileType);
    }

    // 下载文件
    @GetMapping(value = "/downLoadFile")
    public void downLoadFile(HttpServletResponse response, String guid) throws UnsupportedEncodingException {

        attachmentService.downLoadFile(response, guid);
    }

    // 预览图片
    @GetMapping(value = "image/{guid}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "guid") String guid) throws IOException {

        return attachmentService.getImage(guid);
    }

    // 预览视频
    @GetMapping(value = "video/{guid}")
    public void getVideo(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "guid") String guid) {

        attachmentService.getVideo(request, response, guid);
    }

    // 预览PDF
    @GetMapping(value = "/pdfPreview")
    public void PdfPreview (HttpServletResponse response,  String guid) throws IOException {

        attachmentService.PdfPreview(response, guid);
    }
}
