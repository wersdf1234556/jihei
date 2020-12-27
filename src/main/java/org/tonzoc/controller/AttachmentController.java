package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.AttachmentQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.support.param.SqlQueryParam;

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

    @PostMapping("/upFile")
    public void upFile(MultipartFile file, Integer typeId, String subTypeGuid) {

        attachmentService.upFile(file, typeId, subTypeGuid);
    }

    @PostMapping("/upFiles")
    public void upFiles(MultipartFile[] file, Integer typeId, String subTypeGuid) {

        attachmentService.upFiles(file, typeId, subTypeGuid);
    }

    @GetMapping("/downLoadFile")
    public void downLoadFile(HttpServletResponse response, String guid) throws UnsupportedEncodingException {

        attachmentService.downLoadFile(response, guid);
    }

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
        this.attachmentService.remove(guid);
    }

    @GetMapping(value = "image/{guid}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "guid") String guid) throws IOException {
        return attachmentService.getImage(guid);
    }

    @GetMapping("/pdfPreview")
    public void PdfPreview (HttpServletResponse response,  String guid) throws IOException {

        attachmentService.PdfPreview(response, guid);
    }

//    @GetMapping("/dataCount")
//    public List<ReturnModel> dataCount(String projectId) {
//
//        return attachmentsService.dataCount(projectId);
//    }
}
