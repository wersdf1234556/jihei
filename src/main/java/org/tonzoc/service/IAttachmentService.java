package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.ReturnModel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IAttachmentService extends IBaseService<AttachmentModel> {

    // 单文件上传
    void upFile(MultipartFile file, String typeGuid, String subTypeGuid, String laboratoryGuid);

    // 多文件上传
    void upFiles(MultipartFile[] file, String typeGuid, String subTypeGuid, String laboratoryGuid);

    // 文件下载
    void downLoadFile(HttpServletResponse response, String guid) throws UnsupportedEncodingException;

    byte[] getImage(String attachmentId) throws IOException;

    // PDF在线预览
    void PdfPreview(HttpServletResponse response, String guid) throws IOException;

}