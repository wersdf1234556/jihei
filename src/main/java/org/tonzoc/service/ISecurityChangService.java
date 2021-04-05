package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.SecurityChangModel;
import org.tonzoc.model.UserModel;


public interface ISecurityChangService extends IBaseService<SecurityChangModel>{

    //添加
    void add(SecurityChangModel securityChangModel, MultipartFile[] file, Integer fileType, String accounType) throws Exception;

    // 提交
    void submit(String securityChangModel);

    // 审批
    void approval(String securityChangGuid, Integer flag, String approvalScore) throws Exception;

    // 修改时询问是否能修改
    void updateStack(SecurityChangModel securityChangModel, UserModel userModel) throws Exception;

    // 删除一条
    void removeStack(String guid, UserModel userModel) throws Exception;
}
