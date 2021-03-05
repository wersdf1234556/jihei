package org.tonzoc.service;

import org.tonzoc.model.SecurityChangModel;

import java.text.ParseException;

public interface ISecurityChangService extends IBaseService<SecurityChangModel>{

    // 处理时间
    SecurityChangModel updateTime(SecurityChangModel securityChangModel) throws ParseException;
}
