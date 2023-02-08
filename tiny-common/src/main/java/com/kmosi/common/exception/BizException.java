package com.kmosi.common.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-07 14:41
 * @description
 */
@Setter
@Getter
public class BizException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5890346435551803491L;
    /**
     * 定义错误代码
     */
    private Integer code;
    /**
     * 定义错误信息
     */
    private String message;

    /**
     * 使用自定义消息
     *
     * @param code    错误代码
     * @param message 错误信息
     */
    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}