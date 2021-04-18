package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.BeamSecurityMapper;
import org.tonzoc.model.BeamSecurityModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IBeamSecurityService;

@Service("BeamSecurityService")
public class BeamSecurityService extends BaseService<BeamSecurityModel> implements IBeamSecurityService {

    @Autowired
    private BeamSecurityMapper beamSecurityMapper;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private IAttachmentService attachmentService;

    // 上传多个质量追溯文件
    @Override
    public void upFiles(MultipartFile[] file, String fileType) {

        intelliSiteProperties.setFileUrl("/智慧梁场/");
        attachmentService.upFiles(file, "", fileType);
        intelliSiteProperties.setFileUrl("/");
    }

    // 上传质量追溯文件
    @Override
    public void upFile(MultipartFile file, String fileType) {

        intelliSiteProperties.setFileUrl("/智慧梁场/");
        attachmentService.upFile(file, "", fileType);
        intelliSiteProperties.setFileUrl("/");
    }
}
