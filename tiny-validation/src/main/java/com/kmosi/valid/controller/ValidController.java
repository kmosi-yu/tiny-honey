package com.kmosi.valid.controller;

import com.kmosi.valid.annotation.JsonParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-03-08 16:51
 * @description
 */
@RestController
@Validated
public class ValidController {
    /**
     * 验证输入的是不是JSON字符串
     *
     * @param content 内容
     * @return 内容
     */
    @GetMapping("valid")
    public String valid(@JsonParam String content) {
        return content;
    }
}
