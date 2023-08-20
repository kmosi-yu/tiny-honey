package com.kmosi.dns.api.sys;

import com.kmosi.dns.common.utils.HttpUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-12 22:36
 * @description IP管理
 */
@RestController
@RequestMapping("/v1/sys")
public class IpController {
    /**
     * 获取IP
     *
     * @param request 请求
     * @return IP
     */
    @GetMapping("/ip")
    public String getIp(HttpServletRequest request) {
        return HttpUtils.getIpAddress(request);
    }
}
