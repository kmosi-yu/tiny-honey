package com.kmosi.dns.common.helper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static com.kmosi.dns.common.utils.CastUtils.cast;


/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 13:42
 * @description
 */
@Component
@Slf4j
public class JobHelper {
    /**
     * 构建JobDetail
     *
     * @param name      名称
     * @param group     分组
     * @param className 类
     * @param params    参数及值
     * @return JobDetail
     */
    @SneakyThrows
    public JobDetail buildJob(String name, String group, String className, Map<String, Object> params) {
        // 使用的Job
        Class<?> jobClass = Class.forName(className);
        Job job = cast(jobClass.getDeclaredConstructor().newInstance());
        var jobDataMap = Optional.ofNullable(params).map(JobDataMap::new).orElse(new JobDataMap());
        // 构建JobDetail
        return JobBuilder.newJob(job.getClass())
                .withIdentity(name, group)
                .usingJobData(jobDataMap)
                .build();
    }
}