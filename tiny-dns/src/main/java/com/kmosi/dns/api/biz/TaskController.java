package com.kmosi.dns.api.biz;

import com.kmosi.dns.common.domain.bo.TaskBO;
import com.kmosi.dns.scheduler.service.TaskService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 15:24
 * @description
 */
@RestController
@RequestMapping("/v1/biz/task")
public class TaskController {
    @Resource
    private TaskService taskService;

    /**
     * 添加任务
     *
     * @param task 任务
     * @return 时间
     */
    @PostMapping("/job")
    public Date addTask(@RequestBody TaskBO task) {
        return taskService.addTask(task);
    }

    /**
     * 删除任务
     *
     * @param name  名称
     * @param group 分组
     * @return 结果
     */
    @DeleteMapping("/job")
    public boolean deleteTask(String name, String group) {
        return taskService.deleteTask(name, group);
    }

    /**
     * 暂停任务
     *
     * @param name  名称
     * @param group 分组
     * @return 结果
     */
    @PutMapping("/pause")
    public boolean pauseTask(String name, String group) {
        return taskService.pauseTask(name, group);
    }

    /**
     * 恢复任务
     *
     * @param name  名称
     * @param group 分组
     * @return 结果
     */
    @PutMapping("/resume")
    public boolean resumeTask(String name, String group) {
        return taskService.resumeTask(name, group);
    }
}
