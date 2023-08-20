package com.kmosi.dns.common.helper;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Component;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 13:46
 * @description
 */
@Component
@SuppressWarnings("unused")
public class TriggerHelper {
    /**
     * 构建Cron触发器
     *
     * @param name  名称
     * @param group 分组
     * @param cron  表达式
     * @return 触发器
     */
    public Trigger buildTrigger(String name, String group, String cron) {
        // 生成cronTrigger
        TriggerBuilder<CronTrigger> cronTrigger =
                TriggerBuilder.newTrigger()
                        .withIdentity(name, group)
                        .withSchedule(CronScheduleBuilder.cronSchedule(cron)
                                // 第一次不触发
                                .withMisfireHandlingInstructionDoNothing());
        return cronTrigger.build();
    }
}
