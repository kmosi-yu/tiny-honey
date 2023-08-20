package com.kmosi.dns.common.aspect;

import com.alibaba.fastjson2.JSON;
import com.kmosi.dns.common.utils.ThreadLocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 16:16
 * @description
 */
@Aspect
@Component
@Slf4j
public class OpLogAspect {
    /**
     * 记录开始时间
     */
    private static final ThreadLocal<LocalDateTime> START_DATE = new ThreadLocal<>();

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    // @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RestController)")
    @Pointcut("execution(* com.yudone.aliyun.scheduler.job.*..*(..))")
    public void opLogPointCut() {

    }

    /**
     * 返回信息记录
     *
     * @param joinPoint 切入点
     * @throws Throwable 异常信息
     */
    @Around("opLogPointCut()")
    public Object saveOperationLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 执行开始时间
        START_DATE.set(LocalDateTime.now());
        Object result = joinPoint.proceed();
        // log.error("context:{}", JSON.toJSONString(ThreadLocalUtils.get("context")));
        // log.error("records:{}", JSON.toJSONString(ThreadLocalUtils.get("records")));
        // 执行结束时间
        LocalDateTime endDate = LocalDateTime.now();
        // 耗时
        long period = Duration.between(START_DATE.get(), endDate).toMillis();
        log.info("方法开始执行时间：{}，执行结果：{}，结束时间：{}，耗时：{}毫秒", formatter.format(START_DATE.get()), JSON.toJSONString(ThreadLocalUtils.get("records")), formatter.format(endDate), period);
        START_DATE.remove();
        ThreadLocalUtils.clear();
        return result;
    }

    /**
     * 保存异常记录信息
     *
     * @param joinPoint 切入点
     * @param e         异常信息
     */
    @AfterThrowing(pointcut = "opLogPointCut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e) {
        // 日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 执行结束时间
        LocalDateTime endDate = LocalDateTime.now();
        // 耗时
        long period = Duration.between(START_DATE.get(), endDate).toMillis();
        log.info("方法开始执行时间：{}，异常信息为：{}，结束时间：{}，耗时：{}", formatter.format(START_DATE.get()), e.getMessage(), formatter.format(endDate), period);
        START_DATE.remove();
    }
}
