package com.kmosi.valid.annotation;

import com.kmosi.valid.validator.JsonParamValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-03-08 16:24
 * @description JSON字符串验证
 */
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = JsonParamValidator.class)
public @interface JsonParam {
    // 当验证不通过时的提示信息
    String message() default "JSON格式错误";

    // 根据实际需求定的方法
    String contains() default "";

    // 约束注解在验证时所属的组别
    Class<?>[] groups() default {};

    // 负载
    Class<? extends Payload>[] payload() default {};
}
