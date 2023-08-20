package com.kmosi.dns.scheduler.service;


import com.kmosi.dns.common.domain.bo.TaskBO;

import java.util.Date;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 13:55
 * @description
 */
public interface TaskService {
    /**
     * 添加任务
     *
     * @param task 任务
     * @return true
     */
    Date addTask(TaskBO task);

    /**
     * 删除任务
     *
     * @param name  名称
     * @param group 分组
     * @return true
     */
    boolean deleteTask(String name, String group);

    /**
     * 暂停任务
     *
     * @param name  名称
     * @param group 分组
     * @return true
     */
    boolean pauseTask(String name, String group);

    /**
     * 恢复任务
     *
     * @param name  名称
     * @param group 分组
     * @return true
     */
    boolean resumeTask(String name, String group);
}
