package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.MemorabiliaModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IMemorabiliaService;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemorabiliaService extends BaseService<MemorabiliaModel> implements IMemorabiliaService {

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private FileHelper fileHelper;

    @Override
    public Map<String, String> upFile(MultipartFile file, String currentTime) {

        String urlName = "大事记/" + currentTime;
        String[] str = fileHelper.fileUpload(file, urlName, "", "");

        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setSortId(0);
        attachmentModel.setSubTypeGuid("");
        attachmentModel.setTypeGuid("");

        attachmentService.save(attachmentModel);
        Map<String, String> map = new HashMap<>();
        map.put("attachmentGuid", attachmentMapper.getGuid(str[0], "", ""));
        return map;
    }
}
