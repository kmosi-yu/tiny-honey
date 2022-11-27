package com.kmosi.rule.service.impl;

import com.kmosi.rule.domain.bo.PersonBO;
import com.kmosi.rule.helper.KieSessionHelper;
import com.kmosi.rule.service.PersonService;
import jakarta.annotation.Resource;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-26 11:35
 * @description 人信息判断
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private KieSessionHelper sessionHelper;

    /**
     * 判断是不是成年人
     *
     * @param person 人
     * @return 是/否
     */
    @Override
    public Map<String, Object> isAdult(PersonBO person) {
        //设置输出对象
        Map<String, Boolean> result = new ConcurrentHashMap<>(10);
        StatelessKieSession kieSession = sessionHelper.getStatelessSession("person-session");
        kieSession.addEventListener(new DebugRuleRuntimeEventListener());
        kieSession.setGlobal("result", result);
        kieSession.execute(person);
        return Map.of("isAdult",result.get("result"),"person",person);
    }
}
