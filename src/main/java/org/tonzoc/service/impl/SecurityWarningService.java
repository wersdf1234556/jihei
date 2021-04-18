package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.CameraMapper;
import org.tonzoc.model.CameraModel;
import org.tonzoc.model.SecurityWarningModel;
import org.tonzoc.service.ICameraService;
import org.tonzoc.service.ISecurityWarningService;

@Service(value = "securityWarningService")
public class SecurityWarningService extends BaseService<SecurityWarningModel> implements ISecurityWarningService {

}
