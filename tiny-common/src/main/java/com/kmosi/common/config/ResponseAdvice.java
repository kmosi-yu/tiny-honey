package com.kmosi.common.config;

import com.alibaba.fastjson2.JSON;
import com.kmosi.common.domain.vo.ResponseResult;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;
import java.util.UUID;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-07 14:06
 * @description ResponseAdvice统一结果返回值
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    private static final String OPENAPI = "openapiJson";

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
        // 结果如果进行了封装，则直接返回
        if (body instanceof ResponseResult<?>) {
            return body;
        }
        // 处理knife4j整合异常
        if (OPENAPI.equalsIgnoreCase(Objects.requireNonNull(returnType.getMethod()).getName())) {
            return body;
        }
        // 处理文件下载
        if (selectedContentType.includes(MediaType.APPLICATION_OCTET_STREAM)) {
            HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
            servletResponse.setHeader("Content-Disposition", "attachment;filename=" + UUID.randomUUID() + ".png");
            return body;
        }
        // 当返回值为String类型时进行单独的处理
        else if (body instanceof String) {
            HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
            servletResponse.setCharacterEncoding("UTF-8");
            servletResponse.setContentType("application/json; charset=utf-8");
            return JSON.toJSONString(ResponseResult.buildSuccess(body));
        }
        // 对结果进行封装📦
        return ResponseResult.buildSuccess(body);
    }
}
