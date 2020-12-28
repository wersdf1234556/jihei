package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.MemorabiliaModel;
import org.tonzoc.model.QualityTraceabilityModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


public interface IQualityTraceabilityService extends IBaseService<QualityTraceabilityModel> {

    // 上传质量追溯文件
    void upFile(MultipartFile[] file, Integer typeId, String subTypeGuid);

    // 查询字符串转时间
    List<QualityTraceabilityModel> selected(List<QualityTraceabilityModel> list);

    // 处理时间
    QualityTraceabilityModel updateTime (QualityTraceabilityModel QualityTraceabilityModel) throws ParseException;

    // 生成二维码
    Map<String, String> qrcode(String subTypeGuid);
}
