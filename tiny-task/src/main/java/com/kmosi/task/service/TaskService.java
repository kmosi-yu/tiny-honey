package com.kmosi.task.service;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-10-31 13:51
 * @description
 */
public interface TaskService {
    String addTask(String name, String group, String cron);
}
