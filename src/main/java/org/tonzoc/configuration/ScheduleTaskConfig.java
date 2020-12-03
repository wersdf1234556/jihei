package org.tonzoc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@Configuration
@EnableScheduling
public class ScheduleTaskConfig {

    //    @Scheduled(fixedRate = 10000)
    private void doTest() throws IOException {
        System.out.println("schedule task executed!");
    }
}
