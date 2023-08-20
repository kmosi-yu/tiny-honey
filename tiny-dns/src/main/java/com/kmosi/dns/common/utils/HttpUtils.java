package com.kmosi.dns.common.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.kmosi.dns.common.domain.constant.BrowserConstant.*;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-12 22:18
 * @description 获取IP地址
 */
@Slf4j
public class HttpUtils {
    /**
     * 获取真实ip地址，避免获取代理ip
     *
     * @param request 请求
     * @return ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        // TODO: 2023/8/12 后续需要解决容器部署无法获取真实IP的问题。
        String ip = request.getHeader(HEADER_X_FOR);
        log.info("HEADER_X_FOR:{}", ip);
        if (isIp(ip)) {
            ip = request.getHeader(HEADER_PROXY_IP);
            log.info("HEADER_PROXY_IP:{}", ip);
        }
        if (isIp(ip)) {
            ip = request.getHeader(HEADER_WL_PROXY_IP);
            log.info("HEADER_WL_PROXY_IP:{}", ip);
        }
        if (isIp(ip)) {
            ip = request.getHeader(HEADER_HTTP_IP);
            log.info("HEADER_HTTP_IP:{}", ip);
        }
        if (isIp(ip)) {
            ip = request.getHeader(HEADER_HTTP_X_FOR);
            log.info("HEADER_HTTP_X_FOR:{}", ip);
        }
        if (isIp(ip)) {
            ip = request.getRemoteAddr();
            log.info("getRemoteAddr:{}", ip);
            if (ip.equalsIgnoreCase(LOCAL_HOST)) {
                try {
                    ip = InetAddress.getLocalHost().getHostAddress();
                    log.info("LOCAL_HOST:{}", ip);
                } catch (UnknownHostException e) {
                    ip = IP_ERROR;
                    log.info("IP_ERROR:{}", ip);
                }
            }
            // 存在多个IP时，第一个为真实的
            if (ip != null && ip.length() > IP_POS) {
                if (ip.contains(IP_CHAR)) {
                    log.info("IP_CHAR:{}", ip);
                    ip = ip.substring(0, ip.indexOf(","));
                    log.info("IP_CHAR_1:{}", ip);
                }
            }
        }
        return ip;
    }

    /**
     * 判断是不是IP
     *
     * @param ip IP地址
     * @return true/false
     */
    private static boolean isIp(String ip) {
        return ip == null || ip.isEmpty() || IP_UNKNOWN.equalsIgnoreCase(ip);
    }

    /**
     * 获取浏览器类型
     *
     * @param userAgent 请求头
     * @return 浏览器类型
     */
    public static String getBrowserType(String userAgent) {
        return userAgent.contains("Postman") ? "Postman" : (userAgent.contains("Firefox") ? "Firefox" : (userAgent.contains("Chrome") ? "Chrome" : (userAgent.contains("Trident") ? "Trident" : "")));
    }
}
