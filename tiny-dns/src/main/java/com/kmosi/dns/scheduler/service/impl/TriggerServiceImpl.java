package com.kmosi.dns.scheduler.service.impl;

import com.kmosi.dns.scheduler.service.TriggerService;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.stereotype.Service;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 14:08
 * @description
 */
@Service
public class TriggerServiceImpl implements TriggerService {
    @Resource
    private Scheduler scheduler;

    /**
     * 根据job删除触发器
     *
     * @param jobName  名称
     * @param jobGroup 分组
     * @return true
     */
    @SneakyThrows
    @Override
    public boolean deleteTriggerByJob(String jobName, String jobGroup) {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        // 获取所有的触发器
        var triggers = scheduler.getTriggersOfJob(jobKey);
        var triggerKeys = triggers.stream().map(Trigger::getKey).toList();
        for (var key : triggerKeys) {
            // 暂停
            scheduler.pauseTrigger(key);
        }
        // 停止触发器
        return scheduler.unscheduleJobs(triggerKeys);
    }
}
