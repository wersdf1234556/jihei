package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.QualityTraceabilityModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IQualityTraceabilityService extends IBaseService<QualityTraceabilityModel> {

    // 查询字符串转时间
    List<QualityTraceabilityModel> selected(List<QualityTraceabilityModel> list);

    // 处理时间
    QualityTraceabilityModel updateTime(QualityTraceabilityModel QualityTraceabilityModel) throws ParseException;

    // 生成二维码
    Map<String, String> qrcode(String qualityTraceabilityGuid);

    // 上传多个质量追溯文件
    void upFiles(MultipartFile[] file, String qualityTraceabilityGuid);

    // 上传质量追溯文件
    void upFile(MultipartFile file, String qualityTraceabilityGuid);

    // 按照名称模糊查询的功能
    List<AttachmentModel> selectLikeName(String name);
}
