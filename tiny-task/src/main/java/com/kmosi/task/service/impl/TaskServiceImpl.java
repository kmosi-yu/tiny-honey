package com.kmosi.task.service.impl;

import com.kmosi.task.job.RamJob;
import com.kmosi.task.service.TaskService;
import lombok.SneakyThrows;
import org.quartz.*;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-10-31 13:52
 * @description
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    private Scheduler scheduler;

    /**
     * @param name  名称
     * @param group 分组
     * @return 值
     */
    @SneakyThrows
    @Override
    public String addTask(String name, String group,String cron) {
        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                // 设置名称和分组
                .withIdentity(name, group)
                // 设置开始时间
                .build();
        Map<String, String> params = Map.of("hello", "world", "age", "12");
        JobDetail jobDetail = JobBuilder.newJob(RamJob.class)
                .withIdentity(name, group)
                .usingJobData(new JobDataMap(params))
                .build();
        scheduler.start();
        Date date = scheduler.scheduleJob(jobDetail, trigger);
        return date.toString();
    }
}
