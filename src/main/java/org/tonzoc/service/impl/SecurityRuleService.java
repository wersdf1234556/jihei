package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.SecurityRuleMapper;
import org.tonzoc.model.SecurityRuleModel;
import org.tonzoc.service.ISecurityRuleService;

@Service
public class SecurityRuleService extends BaseService<SecurityRuleModel> implements ISecurityRuleService {

    @Autowired
    private SecurityRuleMapper securityRuleMapper;
}
