package com.kmosi.valid.validator;

import com.alibaba.fastjson2.JSONObject;
import com.kmosi.valid.annotation.JsonParam;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-03-08 16:28
 * @description JsonParam注解验证的实现
 */
public class JsonParamValidator implements ConstraintValidator<JsonParam, Object> {
    /**
     * @param value   值
     * @param context 内容
     * @return true/false
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 是否为空
        if (value == null || value == "") {
            return false;
        }
        // 是不是字符串
        if (value instanceof String) {
            boolean isTruth;
            try {
                JSONObject jsonObject = JSONObject.parseObject(value.toString());
                isTruth = true;
            } catch (Exception e) {
                isTruth = false;
            }
            return isTruth;
        }
        // 其它均为错误
        return false;
    }
}
