package org.tonzoc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.tonzoc.service.IMachineGpsRecordService;
import org.tonzoc.service.ISecurityService;

import java.text.ParseException;
import java.util.Date;

// 定时
@Configuration
public class TimingHelper {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private IMachineGpsRecordService machineGpsRecordService;

    @Scheduled(cron = "0 0 0 */1 * ?")
    public void list () throws ParseException {

        System.out.println(new Date() + "当前时间");
        securityService.updateIsEffect();
        machineGpsRecordService.add();
    }
}
