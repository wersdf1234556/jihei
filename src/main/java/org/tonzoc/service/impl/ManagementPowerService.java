package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.mapper.ManagementPowerMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.ManagementPowerModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IManagementPowerService;

import java.util.HashMap;
import java.util.Map;

@Service("ManagementPowerService")
public class ManagementPowerService extends BaseService<ManagementPowerModel> implements IManagementPowerService {

    @Autowired
    private ManagementPowerMapper managementPowerMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private FileHelper fileHelper;

    // 上传文件
    @Override
    public Map<String, String> upFile(MultipartFile file, String currentDate) {

        intelliSiteProperties.setFileUrl("/管理权属/");
        String[] str = fileHelper.fileUpload(file, currentDate,  "");

        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setGuid(fileHelper.newGUID());
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setSortId(0);
        attachmentModel.setQualityTraceabilityGuid("");

        attachmentService.save(attachmentModel);
        intelliSiteProperties.setFileUrl("/");
        Map<String, String> map = new HashMap<>();
        map.put("attachmentGuid", attachmentMapper.getGuid(str[0],  ""));
        return map;
    }
}
