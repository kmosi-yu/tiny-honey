package com.kmosi.retry.service.impl;

import com.kmosi.retry.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-08-07 21:46
 * @description hello测试
 */
@Service
@EnableRetry
@Slf4j
public class HelloServiceImpl implements HelloService {
    /**
     * Hello方法错误标记
     */
    private static final String ERROR = "error";
    /**
     * Hi方法错误标记
     */
    private static final String SUCCESS = "success";

    /**
     * hello重试计数
     */
    private Integer helloCount = 0;
    /**
     * hi重试计数
     */
    private Integer hiCount = 0;

    /**
     * 测试
     *
     * @param name 名称
     * @return 结果
     * Retryable:
     * maxAttempts：最大重试次数，默认为3，如果要设置的重试次数为3，可以不写（包括第一次失败）；
     * value：抛出指定异常才会重试（已过期）
     * retryFor：需要重试的异常
     * noRetryFor：无需重试的异常
     * recover: 指定重试后依旧不成功的处理逻辑
     * Backoff:
     * value：重试间隔时间，默认为1000毫秒
     * delay：和value一样，但是默认为0
     * multiplier：（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。
     */
    @Override
    @Retryable(recover = "recoverHello", maxAttempts = 3, backoff = @Backoff(value = 1000, multiplier = 1.5))
    public String hello(String name) throws Exception {
        log.info("开始Say Hello！");
        if (ERROR.equals(name)) {
            helloCount++;
            throw new Exception("不支持的名字");
        }
        return "Hello " + name;
    }

    /**
     * 测试
     *
     * @param name 名称
     * @return 结果
     */
    @Override
    @Retryable(retryFor = IndexOutOfBoundsException.class, noRetryFor = NullPointerException.class, recover = "recoverHi", maxAttempts = 3, backoff = @Backoff(value = 10000, multiplier = 1.5))
    public String hi(String name) {
        log.info("开始Say Hi！");
        if (SUCCESS.equals(name)) {
            hiCount++;
            throw new IndexOutOfBoundsException("不支持的名字");
        }
        return "Hi " + name;
    }

    @Recover
    public String recoverHello(Exception e, String name) {
        log.error("异常Say Hello！{}，重试了{}次！", e.getMessage(), helloCount - 1);
        helloCount = 0;
        return name + " Say Hello 出错了吧！";
    }

    @Recover
    public String recoverHi(Exception e, String name) {
        log.error("异常Say Hi！{}，重试了{}次！", e.getMessage(), hiCount - 1);
        hiCount = 0;
        return name + " Say Hi 出错了吧！";
    }
}
