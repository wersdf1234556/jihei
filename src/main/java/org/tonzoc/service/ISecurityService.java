package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.SecurityModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ISecurityService extends IBaseService<SecurityModel> {

    // 查询字符串转时间
    List<SecurityModel> selected(List<SecurityModel> list);

    // 处理时间
    SecurityModel updateTime (SecurityModel securityModel) throws ParseException;

    // 上传安全文件
    Map<String, String> upFile(MultipartFile file, String currentTime);
}
