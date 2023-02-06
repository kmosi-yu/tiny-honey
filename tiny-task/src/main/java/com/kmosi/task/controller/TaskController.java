package com.kmosi.task.controller;

import com.kmosi.task.domain.bo.IntervalPeriod;
import com.kmosi.task.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-10-27 16:38
 * @description
 */
@RestController
public class TaskController {
    @Resource
    private TaskService taskService;

    @GetMapping("task")
    public String addTask(String name, String group, String cron) {
        return taskService.addTask(name, group, cron);
    }

    public static void main(String[] args) {
        IntervalPeriod period =IntervalPeriod.builder().build();
        System.out.println("period = " + period);
    }
}
