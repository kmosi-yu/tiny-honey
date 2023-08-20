package com.kmosi.dns.common.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 11:40
 * @description 统一返回结果
 */
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "统一结果响应实体", description = "用于统一返回结果的格式")
public class ResponseResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -4561660494342335921L;
    /**
     * 状态码
     */
    @Schema(description = "状态码")
    private Integer code;
    /**
     * 状态（true/false）
     */
    @Schema(description = "状态：成功为true；失败为false")
    private Boolean state;
    /**
     * 返回信息
     */
    @Schema(description = "返回信息")
    private String message;
    /**
     * 返回数据
     */
    @Schema(description = "返回数据")
    private T data;
    /**
     * 时间戳
     */
    @Builder.Default
    @Schema(description = "时间戳")
    private Long timestamp = System.currentTimeMillis();

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
     * 成功
     *
     * @param data 数据
     * @param <T>  泛型
     * @return T
     */
    public static <T> ResponseResult<T> buildSuccess(T data) {
        return ResponseResult.<T>builder()
                .code(200)
                .state(true)
                .message("数据请求成功！")
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