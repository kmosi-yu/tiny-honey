package com.kmosi.dns.scheduler.service.impl;

import com.kmosi.dns.common.domain.bo.TaskBO;
import com.kmosi.dns.common.helper.JobHelper;
import com.kmosi.dns.common.helper.TriggerHelper;
import com.kmosi.dns.scheduler.service.TaskService;
import com.kmosi.dns.scheduler.service.TriggerService;
import com.kmosi.dns.sys.exception.BizException;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 13:57
 * @description 任务管理
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    private Scheduler scheduler;
    @Resource
    private JobHelper jobHelper;
    @Resource
    private TriggerHelper triggerHelper;
    @Resource
    private TriggerService triggerService;

    /**
     * 添加任务
     *
     * @param task 任务
     * @return true
     */
    @SneakyThrows
    @Override
    public Date addTask(TaskBO task) {
        String name = task.getName();
        String group = task.getGroup();
        // 构建触发器
        var trigger = triggerHelper.buildTrigger(name, group, task.getCron());
        // 构建Job
        JobDetail jobDetail = jobHelper.buildJob(name, group, task.getJobClassName(), task.getParam());
        return scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 删除任务
     *
     * @param name  名称
     * @param group 分组
     * @return true
     */
    @SneakyThrows
    @Override
    public boolean deleteTask(String name, String group) {
        boolean result = false;
        triggerService.deleteTriggerByJob(name, group);
        var jobKey = new JobKey(name, group);
        if (scheduler.checkExists(jobKey)) {
            result = scheduler.deleteJob(jobKey);
        }
        return result;
    }

    /**
     * 暂停任务
     *
     * @param name  名称
     * @param group 分组
     * @return true
     */
    @Override
    public boolean pauseTask(String name, String group) {
        boolean result;
        var jobKey = new JobKey(name, group);
        try {
            scheduler.pauseJob(jobKey);
            result = true;
        } catch (SchedulerException e) {
            throw new BizException(e.getMessage());
        }
        return result;
    }

    /**
     * 恢复任务
     *
     * @param name  名称
     * @param group 分组
     * @return true
     */
    @Override
    public boolean resumeTask(String name, String group) {
        boolean result;
        var jobKey = new JobKey(name, group);
        try {
            scheduler.resumeJob(jobKey);
            result = true;
        } catch (SchedulerException e) {
            throw new BizException(e.getMessage());
        }
        return result;
    }
}
