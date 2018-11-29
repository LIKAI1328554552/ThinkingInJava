package com.likai.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.UUID;

/**
 * Created by likai on 2018/11/13.
 */
public class Test1 {
    public static void main(String [] args) throws SchedulerException {

        /*JobDetail job = JobBuilder.newJob(HelloQuartz.class)
                .withIdentity("dummyJobName", "group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName","group1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);*/


        for(int i = 0 ; i < 120; i ++) {
            System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
        }

    }
}
