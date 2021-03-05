package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.mapper.SecurityChangMapper;
import org.tonzoc.model.SecurityChangModel;
import org.tonzoc.service.ISecurityChangService;

import java.text.ParseException;

@Service("SecurityChangService")
@Transactional
public class SecurityChangService extends BaseService<SecurityChangModel> implements ISecurityChangService {

    @Autowired
    private SecurityChangMapper securityChangMapper;

    // 处理时间
    @Override
    public SecurityChangModel updateTime(SecurityChangModel securityChangModel) throws ParseException {

        if (securityChangModel.getChangDate() != null && !securityChangModel.getChangDate().equals("")) {

            securityChangMapper.updateChangTime(TimeHelper.stringToDate(securityChangModel.getChangDate()), securityChangModel.getGuid());
        }

        if (securityChangModel.getCheckDate() != null && !securityChangModel.getCheckDate().equals("")) {

            securityChangMapper.updateCheckTime(TimeHelper.stringToDate(securityChangModel.getCheckDate()), securityChangModel.getGuid());
        }
        securityChangModel.setSortId(0);
        securityChangModel.setChangDate("");
        securityChangModel.setCheckDate("");
        return securityChangModel;
    }
}
