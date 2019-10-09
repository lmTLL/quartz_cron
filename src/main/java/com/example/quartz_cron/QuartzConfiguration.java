package com.example.quartz_cron;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(FileHandleQuartz.class)
                .withIdentity("fileHandleQuartzJobDetail") //自己取名
                .storeDurably().build();
    }
    @Bean
    public Trigger trigger() {
        //SimpleScheduleBuilder schedBuilder=SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever(); //时间自己定，根据方法进行修改时间
         CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
         //CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 10 1/1 * ?");
        //0 0 10 1/1 * ?
        return TriggerBuilder.newTrigger().forJob( jobDetail()).withIdentity("fileHandleQuartzJobTriger") //自己取名
                .withSchedule(cronScheduleBuilder).build();
    }
}



