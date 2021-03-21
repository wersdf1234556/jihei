package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.DocumentMapper;
import org.tonzoc.mapper.SecurityRuleMapper;
import org.tonzoc.model.DocumentModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.SecurityRuleModel;
import org.tonzoc.service.ISecurityRuleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecurityRuleService extends BaseService<SecurityRuleModel> implements ISecurityRuleService {

    @Autowired
    private SecurityRuleMapper securityRuleMapper;

}
