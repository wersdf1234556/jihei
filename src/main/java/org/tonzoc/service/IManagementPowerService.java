package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.ManagementPowerModel;

import java.util.Map;

public interface IManagementPowerService extends IBaseService<ManagementPowerModel>{

    // 上传文件
    Map<String, String> upFile(MultipartFile file, String currentTime);
}
