package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.UserModel;

import java.text.ParseException;
import java.util.Date;
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
    void updateStatus(String status, String approvalTime, String currentTenderGuid, String guid);

    // 安全统计
    List<ReturnModel> securityStatics();

    // 安全隐患排查
    List<SecurityModel> unsafeSelect();

    // 提交
    void submit(String securityGuid, String currentTenderGuid);

    // 多条提交
    void batchApproval(String securityGuid, String currentTenderGuid, Integer flag);

    // 修改时询问是否能修改
    void updateStack(SecurityModel securityGuid, UserModel userModel) throws Exception;

    // 删除一条
    void removeStack(String guid, UserModel userModel) throws Exception;

    // 循环删除
    void batchRemoveStack(String guids, UserModel userModel) throws Exception;

    // 判断当前分数是否超过10天改状态
    void updateIsEffect(Date oldDate);

}