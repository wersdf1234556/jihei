package org.tonzoc.service;

import org.tonzoc.model.AttachmentSecurityModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IAttachmentSecurityService extends IBaseService<AttachmentSecurityModel>{

    // 图片预览
    byte[] getImage(String attachmentSecurityGuid) throws IOException;

    // 视频预览
    void getVideo(HttpServletRequest request, HttpServletResponse response, String attachmentSecurityGuid);

    // 删除物理文件
    String deleteFile(String guid);
}
