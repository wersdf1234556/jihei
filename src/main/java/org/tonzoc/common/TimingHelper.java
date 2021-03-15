package org.tonzoc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.service.ISecurityService;

import java.text.ParseException;
import java.util.List;

// 定时
@Configuration
public class TimingHelper {

    @Autowired
    private ISecurityService securityService;

    @Scheduled(cron = "0 0 1 * * ?")
    public List<ReturnModel> list () throws ParseException {

        return securityService.selectScore();
    }
}
