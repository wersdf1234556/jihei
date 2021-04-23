package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.SecurityResultModel;
import org.tonzoc.service.ISecurityResultService;

@Service(value = "securityResultService")
public class SecurityResultService extends BaseService<SecurityResultModel> implements ISecurityResultService {

}
