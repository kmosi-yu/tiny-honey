package com.kmosi.common.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-10-27 16:25
 * @description 统一返回结果
 */
@Setter
@Getter
@Builder
@ToString
public class ResponseResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -4561660494342335921L;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态（true/false）
     */
    private Boolean state;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;


    /**
     * 成功
     *
     * @param message 信息
     * @param data    数据
     * @param <T>     泛型
     * @return T
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
     * 失败
     *
     * @param message 信息
     * @param data    数据
     * @param <T>     泛型
     * @return T
     */
    public static <T> ResponseResult<T> buildFailure(String message, T data) {
        return ResponseResult.<T>builder()
                .code(200)
                .state(false)
                .message(message)
                .data(data)
                .build();
    }

    /**
     * 失败
     *
     * @param code    状态码
     * @param state   状态
     * @param message 信息
     * @param data    数据
     * @param <T>     泛型
     * @return T
     */
    public static <T> ResponseResult<T> buildFailure(Integer code, Boolean state, String message, T data) {
        return ResponseResult.<T>builder()
                .code(code)
                .state(state)
                .message(message)
                .data(data)
                .build();
    }
}