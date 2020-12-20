package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.QualityTraceabilityModel;

import java.sql.Date;

public interface IQualityTraceabilityService extends IBaseService<QualityTraceabilityModel> {

    // 上传文件
    String upFile(MultipartFile file, Date currentTime);

    // 生成二维码
    String qrcode(String orderNo);

}
