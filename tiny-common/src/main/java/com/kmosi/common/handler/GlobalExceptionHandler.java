package com.kmosi.common.handler;

import com.kmosi.common.domain.vo.ResponseResult;
import com.kmosi.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-07 14:40
 * @description 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 自定义基本错误异常处理
     *
     * @param e 异常
     * @return result
     */
    @ExceptionHandler(value = BizException.class)
    public ResponseResult<Object> handleBizException(BizException e) {
        return ResponseResult.buildFailure(e.getMessage(), null);
    }

    /**
     * 400 - Bad Request
     *
     * @param e 异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseResult<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResponseResult.buildFailure(HttpStatus.BAD_REQUEST.value(), false, "参数请求错误！", e.getMessage());
    }

    /**
     * 400 - Bad Request
     *
     * @param e 异常
     * @return result
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TypeMismatchException.class)
    public ResponseResult<Object> requestTypeMismatch(TypeMismatchException e) {
        return ResponseResult.buildFailure(HttpStatus.BAD_REQUEST.value(), false, "类型不匹配！", e.getMessage());
    }

    /**
     * 404 -NoHandlerFoundException
     *
     * @param e 异常
     * @return result
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseResult<Object> handlerNoHandlerFoundException(NoHandlerFoundException e) {
        return ResponseResult.buildFailure(HttpStatus.NOT_FOUND.value(), false, "资源不存在！", e.getMessage());
    }
    /**
     * 404 -HttpRequestMethodNotSupportedException
     *
     * @param e 异常
     * @return result
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseResult<Object> handlerNoHandlerNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return ResponseResult.buildFailure(HttpStatus.METHOD_NOT_ALLOWED.value(), false, "请求方法错误！", e.getMessage());
    }
}
