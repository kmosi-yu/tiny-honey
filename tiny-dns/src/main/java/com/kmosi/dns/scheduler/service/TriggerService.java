package com.kmosi.dns.scheduler.service;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 14:08
 * @description
 */
public interface TriggerService {
    /**
     * 根据job删除触发器
     *
     * @param jobName  名称
     * @param jobGroup 分组
     * @return true
     */
    boolean deleteTriggerByJob(String jobName, String jobGroup);
}
