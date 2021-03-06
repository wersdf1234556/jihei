package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.AttachmentModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface IAttachmentService extends IBaseService<AttachmentModel> {

    // 单文件上传
    void upFile(MultipartFile file, String qualityTraceabilityGuid, String fileType);

    // 多文件上传
    void upFiles(MultipartFile[] file, String qualityTraceabilityGuid, String fileType);

    // 文件下载
    void downLoadFile(HttpServletResponse response, String guid) throws UnsupportedEncodingException;

    // 多个文件下载
    void downLoadFiles(HttpServletResponse response, String guids) throws UnsupportedEncodingException;

    // 图片预览
    byte[] getImage(String attachmentId) throws IOException;

    // 视频预览
    void getVideo(HttpServletRequest request, HttpServletResponse response, String attachmentId);

    // PDF在线预览
    void PdfPreview(HttpServletResponse response, String guid) throws IOException;

    // 删除一个物理文件
    void deleteFile(String guid);

    // 删除多个物理文件
    void deleteFiles(String guids) throws Exception;

    // 获取当前文件下的所有guid
    String selectAllGuid(String qualityTraceabilityGuid);

}
