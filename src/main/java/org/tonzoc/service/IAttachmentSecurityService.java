package org.tonzoc.service;

import org.tonzoc.model.AttachmentSecurityModel;

import java.io.IOException;

public interface IAttachmentSecurityService extends IBaseService<AttachmentSecurityModel>{

    // 图片预览
    byte[] getImage(String attachmentSecurityGuid) throws IOException;

    // 删除物理文件
    String deleteFile(String guid);
}
