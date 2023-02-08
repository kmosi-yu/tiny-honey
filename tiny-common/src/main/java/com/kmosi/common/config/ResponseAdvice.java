package com.kmosi.common.config;

import com.kmosi.common.domain.vo.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-07 14:06
 * @description ResponseAdvice统一结果返回值
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    /**
     * @param returnType    参数
     * @param converterType 转换
     * @return 结果
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * @param body                  内容体
     * @param returnType            方法参数
     * @param selectedContentType   媒体类型
     * @param selectedConverterType 转换类型
     * @param request               请求
     * @param response              响应
     * @return 结果
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 异常响应：直接返回异常的数据信息
        if (body instanceof ResponseResult<?>) {
            return body;
        }
        // 返回请求成功的结果
        return ResponseResult.buildSuccess(body);
    }
}
