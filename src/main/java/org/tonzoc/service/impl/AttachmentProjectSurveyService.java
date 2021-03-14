package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.common.FileHelper;
import org.tonzoc.mapper.AttachmentProjectSurveyMapper;
import org.tonzoc.model.AttachmentProjectSurveyModel;
import org.tonzoc.model.AttachmentSecurityModel;
import org.tonzoc.service.IAttachmentProjectSurveyService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentProjectSurveyService extends BaseService<AttachmentProjectSurveyModel> implements IAttachmentProjectSurveyService {

    @Autowired
    private AttachmentProjectSurveyMapper attachmentProjectSurveyMapper;

    @Autowired
    private FileHelper fileHelper;

    // 预览图片
    public byte[] getImage(String attachmentProjectSurveyGuid) throws IOException {
        System.out.println("attachmentProjectSurveyGuid" + attachmentProjectSurveyGuid);
        AttachmentProjectSurveyModel attachmentProjectSurveyModel = get(attachmentProjectSurveyGuid);
        String url = attachmentProjectSurveyModel.getUrl();
        System.out.println("222");
        return fileHelper.getImage(url);
    }

    // 删除物理文件
    @Override
    public String deleteFile(String guid) {
        List<String> list = new ArrayList<>();
        if (guid.contains(",")) {
            String str[] = guid.split(",");
            for (String s:str) {
                list.add(this.get(s).getUrl());
            }
        }else{
            list.add(this.get(guid).getUrl());
        }

        return fileHelper.deleteFile(list);
    }
}
