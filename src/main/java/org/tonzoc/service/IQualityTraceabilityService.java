package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.QualityTraceabilityModel;

import java.util.Map;


public interface IQualityTraceabilityService extends IBaseService<QualityTraceabilityModel> {

    // 上传质量追溯文件
    void upFile(MultipartFile[] file, String typeGuid, String subTypeGuid);

    // 生成二维码
    Map<String, String> qrcode(String orderNo);

}
