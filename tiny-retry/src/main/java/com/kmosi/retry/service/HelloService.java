package com.kmosi.retry.service;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-08-07 21:32
 * @description hello测试
 */
public interface HelloService {
    /**
     * 测试
     *
     * @param name 名称
     * @return 结果
     */
    String hello(String name) throws Exception;

    /**
     * 测试
     *
     * @param name 名称
     * @return 结果
     */
    String hi(String name) throws Exception;
}
