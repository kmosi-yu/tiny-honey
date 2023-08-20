package com.kmosi.dns.common.domain.constant;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-12 22:19
 * @description
 */
public interface BrowserConstant {
    /**
     * 未知
     */
    String IP_UNKNOWN = "unknown";
    /**
     * 错误
     */
    String IP_ERROR = "IP数据获取失败";
    /**
     * 数量
     */
    Integer IP_POS = 15;
    /**
     * 分割符号
     */
    String IP_CHAR = ",";
    /**
     * 本地地址
     */
    String LOCAL_HOST = "127.0.0.1";
    /**
     * x-forwarded-for
     */
    String HEADER_X_FOR = "x-forwarded-for";
    /**
     * Proxy-Client-IP
     */
    String HEADER_PROXY_IP = "Proxy-Client-IP";
    /**
     * WL-Proxy-Client-IP
     */
    String HEADER_WL_PROXY_IP = "WL-Proxy-Client-IP";
    /**
     * HTTP_CLIENT_IP
     */
    String HEADER_HTTP_IP = "HTTP_CLIENT_IP";
    /**
     * HTTP_X_FORWARDED_FOR
     */
    String HEADER_HTTP_X_FOR = "HTTP_X_FORWARDED_FOR";
    /**
     * user-agent
     */
    String HEADER_USER_AGENT = "user-agent";
}

