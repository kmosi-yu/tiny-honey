package com.kmosi.common.utils;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-27 08:48
 * @description 去除泛型转化警告
 */
@SuppressWarnings("unused")
public interface CastUtils {
    /**
     * 去除警告
     *
     * @param object 类
     * @param <T>    范型
     * @return 类
     */
    @SuppressWarnings("unchecked")
    static <T> T cast(Object object) {
        return (T) object;
    }
}
