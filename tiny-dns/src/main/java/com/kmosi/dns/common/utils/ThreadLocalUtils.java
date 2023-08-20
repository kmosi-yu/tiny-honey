package com.kmosi.dns.common.utils;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static com.kmosi.dns.common.utils.CastUtils.cast;


/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 16:25
 * @description
 */
@NoArgsConstructor
@SuppressWarnings("unused")
public class ThreadLocalUtils {
    /**
     * 定义全局的THREAD_CONTEXT用于存储数据
     * 注意后面的初始化由null变为{}
     */
    private final static ThreadLocal<Map<String, Object>> THREAD_CONTEXT = ThreadLocal.withInitial(HashMap::new);

    /**
     * 根据key获取value
     *
     * @param key 键值
     * @return T
     */
    public static <T> T get(String key) {
        // 从Map<String, Object>中根据key获取value
        return cast(getContextMap().get(key));
    }

    /**
     * put操作
     *
     * @param key   键
     * @param value 值
     */
    public static void put(String key, Object value) {
        getContextMap().put(key, value);
    }

    /**
     * 清除map里的某个值
     *
     * @param key 键
     * @return Object
     */
    public static Object remove(String key) {
        return getContextMap().remove(key);
    }

    /**
     * 清除整个Map<String, Object>
     */
    public static void remove() {
        getContextMap().clear();
    }

    /**
     * 从ThreadLocalMap中清除当前ThreadLocal存储的内容
     */
    public static void clear() {
        THREAD_CONTEXT.remove();
    }

    /**
     * 从ThreadLocalMap获取map
     *
     * @return 获取map
     */
    private static Map<String, Object> getContextMap() {
        return THREAD_CONTEXT.get();
    }
}