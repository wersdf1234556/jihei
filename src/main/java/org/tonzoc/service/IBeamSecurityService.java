package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.BeamSecurityModel;

public interface IBeamSecurityService extends IBaseService<BeamSecurityModel>{

    // 上传多个质量追溯文件
    void upFiles(MultipartFile[] file, String fileType);

    // 上传质量追溯文件
    void upFile(MultipartFile file, String fileType);
}
