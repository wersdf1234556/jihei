package org.tonzoc.service;

import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.SecurityRuleModel;

import java.util.List;

public interface ISecurityRuleService extends IBaseService<SecurityRuleModel> {

    // 考核项积分情况
    List<SecurityRuleModel> selectByDocument();

    // 积分变化情况
    List<ReturnModel> selectChang();
}
