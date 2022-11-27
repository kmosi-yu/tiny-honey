package com.kmosi.rule.helper;

import jakarta.annotation.Resource;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Component;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-26 11:39
 * @description KieSession获取
 */
@Component
public class KieSessionHelper {
    @Resource
    KieServices kieServices;

    /**
     * 获取stateless session
     *
     * @param sessionName 名称
     * @return session
     */
    public StatelessKieSession getStatelessSession(String sessionName) {
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        return kieContainer.newStatelessKieSession(sessionName);
    }

    /**
     * 获取stateful session
     *
     * @param sessionName 名称
     * @return session
     */
    public KieSession getStatefulSession(String sessionName) {
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        return kieContainer.newKieSession(sessionName);
    }
}
