package com.osc.app.task.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: ScheduledTasks
 * @author: lizhiming
 * @since: 2017/12/7
 */
@Component
public class ScheduledTasks {

    private Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(cron="0/5 * * * * ? ")   //每5秒执行一次
    public void testCron() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LOGGER.info("【定时任务】"+sdf.format(new Date())+"*********每5秒执行一次");
    }
}
