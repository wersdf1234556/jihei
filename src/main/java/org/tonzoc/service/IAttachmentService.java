package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.AttachmentModel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface IAttachmentService extends IBaseService<AttachmentModel> {

    // 单文件上传
    void upFile(MultipartFile file, String qualityTraceabilityGuid);

    // 多文件上传
    void upFiles(MultipartFile[] file, String qualityTraceabilityGuid);

    // 文件下载
    void downLoadFile(HttpServletResponse response, String guid) throws UnsupportedEncodingException;

    // 图片预览
    byte[] getImage(String attachmentId) throws IOException;

    // PDF在线预览
    void PdfPreview(HttpServletResponse response, String guid) throws IOException;

    // 删除物理文件
    String deleteFile(String guid);

}
