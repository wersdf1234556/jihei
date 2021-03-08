package org.tonzoc.service;

import org.tonzoc.model.SecurityChangModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.UserModel;

import java.text.ParseException;

public interface ISecurityChangService extends IBaseService<SecurityChangModel>{

    // 处理时间
    SecurityChangModel updateTime(SecurityChangModel securityChangModel) throws ParseException;

    // 提交
    void submit(String securityChangModel);

    // 审批
    void approval(String securityChangGuid, Integer flag);

    // 多条提交
    void batchApproval(String securityChangModel, Integer flag);

    // 修改时询问是否能修改
    void updateStack(SecurityChangModel securityChangModel, UserModel userModel) throws Exception;

    // 删除一条
    void removeStack(String guid, UserModel userModel) throws Exception;

    // 循环删除
    void batchRemoveStack(String guids, UserModel userModel) throws Exception;
}
