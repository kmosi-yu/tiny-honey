package com.kmosi.dns.common.domain.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 13:56
 * @description
 */
@Setter
@Getter
@ToString
public class TaskBO implements Serializable {
    @Serial
    private static final long serialVersionUID = 7052966921597415948L;
    /**
     * 名称
     */
    private String name;
    /**
     * 名称
     */
    private String group;
    /**
     * 使用的JOB类
     */
    private String jobClassName;
    /**
     * 参数
     */
    private Map<String, Object> param;
    /**
     * 时间策略
     */
    private String cron;
}
