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
 * @date 2022-11-01 14:59
 * @description 固定时间
 */
@Setter
@Getter
@ToString
@Builder
public class FixedPeriod implements Serializable {
    @Serial
    private static final long serialVersionUID = 4964923985316353420L;
    /**
     * 触发器名称
     */
    private String name;
    /**
     * 触发器分组
     */
    private String group;
    /**
     * 执行日期
     */
    @Builder.Default
    private LocalDateTime fireDate = LocalDateTime.now();
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
