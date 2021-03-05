package org.tonzoc.service;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.QualityTraceabilityModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ISecurityService extends IBaseService<SecurityModel> {

    // 处理时间
    SecurityModel updateTime(SecurityModel securityModel) throws ParseException;

    // 上传安全的文件
    Map<String, String> upFile(MultipartFile file, String securityGuid, String securityChangGuid, Integer fileType);

    // 上传多条安全的文件
    void upFiles(MultipartFile[] file, String securityGuid, String securityChangGuid, Integer fileType);

    // 修改状态
    void updateStatus(String status, String guid);

    // 安全统计
    List<ReturnModel> securityStatics();

    // 安全隐患排查
    List<SecurityModel> unsafeSelect();

}