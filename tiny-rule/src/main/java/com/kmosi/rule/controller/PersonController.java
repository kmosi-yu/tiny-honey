package com.kmosi.rule.controller;

import com.kmosi.rule.domain.bo.PersonBO;
import com.kmosi.rule.service.PersonService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-26 11:59
 * @description
 */
@RestController
public class PersonController {
    @Resource
    PersonService personService;

    /**
     * 输入年龄进行测试
     *
     * @param age 年龄
     * @return 结果
     */
    @GetMapping("person")
    public Map<String, Object> isAdult(Integer age) {
        PersonBO personBO = PersonBO.builder()
                .address("山东").sex(0)
                .age(age).name("张三")
                .job("PM")
                .birth(LocalDateTime.of(2000, 11, 12, 14, 20, 0))
                .build();
        return personService.isAdult(personBO);
    }
}
