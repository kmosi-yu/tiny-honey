package com.kmosi.task.helper;

import com.kmosi.task.domain.bo.FixedPeriod;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.kmosi.common.utils.DateUtils.localDateTimeToDate;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-01 14:31
 * @description 触发器构建
 */
@Component
@SuppressWarnings("unused")
public class TriggerHelper {
    /**
     * 构建固定时间触发器
     *
     * @param period 固定时间
     * @return 简单触发器
     */
    public static Trigger buildTrigger(@NonNull FixedPeriod period) {
        // 有效截止日期
        LocalDateTime exp = period.getExp();
        // 有效开始日期
        LocalDateTime mfg = period.getMfg();
        // 触发时间
        LocalDateTime fireDate = period.getFireDate();
        // 触发时间：在当前时间之后，有效开始时间之后，截止时间之前
        boolean isTrue = fireDate.isBefore(exp)
                && fireDate.isAfter(LocalDateTime.now())
                && fireDate.isAfter(mfg);
        if (isTrue) {
            return TriggerBuilder.newTrigger()
                    // 设置名称和分组
                    .withIdentity((period.getName()), period.getGroup())
                    // 设置开始时间
                    .startAt(localDateTimeToDate(period.getFireDate()))
                    .build();
        }
        return null;
    }
}
