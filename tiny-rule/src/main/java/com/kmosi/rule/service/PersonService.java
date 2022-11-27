package com.kmosi.rule.service;

import com.kmosi.rule.domain.bo.PersonBO;

import java.util.Map;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-26 11:34
 * @description 人信息判断
 */
public interface PersonService {
    /**
     * 判断是不是成年人
     *
     * @param person 人
     * @return 是/否
     */
    Map<String, Object> isAdult(PersonBO person);
}
