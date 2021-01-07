package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.mapper.SecurityMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.ISecurityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecurityService extends BaseService<SecurityModel> implements ISecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    // 查询字符串转时间
    @Override
    public List<SecurityModel> selected (List<SecurityModel> list) {
        if (list.size() > 0) {
            for (SecurityModel m : list) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                m.setCurrentDate(simpleDateFormat.format(m.getCurrentTime()));
            }
        }
        return list;
    }

    // 处理时间
    @Override
    public SecurityModel updateTime(SecurityModel securityModel) throws ParseException {

        if (!"".equals(securityModel.getCurrentDate()) && securityModel.getCurrentDate() != null) {

            securityMapper.updateTime(TimeHelper.stringToDate(securityModel.getCurrentDate()), securityModel.getGuid());
        }
        securityModel.setSortId(0);
        securityModel.setCurrentDate("");
        return securityModel;
    }

    // 上传安全的文件
    @Override
    public Map<String, String> upFile(MultipartFile file, String currentDate) {

        intelliSiteProperties.setFileUrl("/安全/");
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
