package com.kmosi.dns.common.helper;

import com.kmosi.dns.common.domain.meta.AliYunMeta;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 20:22
 * @description
 */
@Component
public class IpHelper {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private AliYunMeta aliYunMeta;

    /**
     * 获取公网IP地址
     *
     * @return IP
     */
    public String getIpv4() {
        String ip = "";
        String regx = "(?<=\").*?(?=\")";
        Pattern pattern = Pattern.compile(regx);
        var result = restTemplate.getForEntity(aliYunMeta.getIpAddress(), String.class).getBody();
        Matcher m = pattern.matcher(result != null ? result : "");
        while (m.find()) {
            ip = m.group(0);
        }
        return ip;
    }
}
