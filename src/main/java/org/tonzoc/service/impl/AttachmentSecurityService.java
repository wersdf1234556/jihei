package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.common.FileHelper;
import org.tonzoc.mapper.AttachmentSecurityMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.AttachmentSecurityModel;
import org.tonzoc.service.IAttachmentSecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentSecurityService extends BaseService<AttachmentSecurityModel> implements IAttachmentSecurityService {

    @Autowired
    private AttachmentSecurityMapper attachmentSecurityMapper;

    @Autowired
    private FileHelper fileHelper;

    // 预览图片
    public byte[] getImage(String attachmentSecurityGuid) throws IOException {
        AttachmentSecurityModel attachmentSecurityModel = get(attachmentSecurityGuid);
        String url = attachmentSecurityModel.getUrl();
        return fileHelper.getImage(url);
    }

    // 预览视频
    public void getVideo(HttpServletRequest request, HttpServletResponse response, String attachmentSecurityGuid){

        AttachmentSecurityModel attachmentSecurityModel = this.get(attachmentSecurityGuid);
        String url = attachmentSecurityModel.getUrl();
        fileHelper.getVideo(request, response, url);
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
