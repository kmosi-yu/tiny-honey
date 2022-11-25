package com.kmosi.retry.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-08-07 21:33
 * @description 接口响应实体类
 */
@Getter
@Setter
@ToString
@Builder
public class ResponseResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 7417913404677728538L;
    /**
     * 状态信息
     */
    private Integer code;
    /**
     * 是否成功
     */
    private Boolean state;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    /**
     * 请求成功时结果响应实体
     *
     * @param message 信息
     * @param data    数据
     * @param <T>     T
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> buildSuccess(String message, T data) {
        return ResponseResult.<T>builder()
                .code(200)
                .state(true)
                .message(message)
                .data(data)
                .build();
    }

    /**
     * 请求失败时结果响应实体
     *
     * @param code    代码
     * @param message 信息
     * @param data    数据
     * @param <T>     T
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> buildFailure(Integer code, String message, T data) {
        return ResponseResult.<T>builder()
                .code(code)
                .state(false)
                .message(message)
                .data(data)
                .build();
    }
}
