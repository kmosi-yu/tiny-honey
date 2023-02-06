package com.kmosi.task.domain.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import static com.kmosi.common.utils.DateUtils.strToLocalDateTime;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-03 14:53
 * @description cron表达式
 */
@Setter
@Getter
@ToString
@Builder
public class CronPeriod implements Serializable {
    @Serial
    private static final long serialVersionUID = -7470425277090106746L;
    /**
     * 触发器名称
     */
    private String name;
    /**
     * 触发器分组
     */
    private String group;
    /**
     * 执行表达式
     */
    private String cron;
    /**
     * 开始日期（有效开始日期）manufacturing date
     */
    @Builder.Default
    private LocalDateTime mfg = LocalDateTime.now();
    /**
     * 截止日期（有效截止日期）expiry date
     */
    @Builder.Default
    private LocalDateTime exp = strToLocalDateTime("9999-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
}
