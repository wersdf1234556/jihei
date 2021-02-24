package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;

import java.util.List;
import java.util.Map;

public interface ISecurityService extends IBaseService<SecurityModel> {

    // 判断当前时间是否在这个时间内
    String isTimeInside(String documentGuid);

    // 上传安全的文件
    Map<String, String> upFile(MultipartFile file, Integer judge);

    // 添加多条并修改分数
    void adds(List<SecurityModel> list);

    // 安全统计
    List<ReturnModel> securityStatics();

    // 安全比例

}