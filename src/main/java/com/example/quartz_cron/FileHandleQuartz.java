package com.example.quartz_cron;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.awt.*;
import java.util.Date;

public class FileHandleQuartz extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       // logger.info("定时任务执行啦！");
        System.out.println("任务调度"+new Date());

    }


}
