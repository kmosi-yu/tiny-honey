package com.kmosi.task.job;


import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-10-27 15:57
 * @description
 */
@Component
@Slf4j
public class RamJob implements Job {
    /**
     * @param context 内容
     * @throws JobExecutionException 异常
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        String name = jobDetail.getKey().getName();
        String group = jobDetail.getKey().getGroup();
        log.info("参数信息为：{}，名称为：{}，分组为：{}。", jobDetail.toString(), name, group);
    }
}
