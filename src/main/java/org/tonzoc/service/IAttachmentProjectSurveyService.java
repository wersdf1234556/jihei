package org.tonzoc.service;

import org.tonzoc.model.AttachmentProjectSurveyModel;

import java.io.IOException;

public interface IAttachmentProjectSurveyService extends IBaseService<AttachmentProjectSurveyModel> {

    // 图片预览
    byte[] getImage(String attachmentProjectSurveyGuid) throws IOException;

    // 删除物理文件
    String deleteFile(String guid);
}
