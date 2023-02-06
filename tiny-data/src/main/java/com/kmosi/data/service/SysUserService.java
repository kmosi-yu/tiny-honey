package com.kmosi.data.service;

import com.kmosi.data.bean.SysUser;

import java.util.List;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-30 15:28
 * @description
 */
public interface SysUserService {
    /**
     * 通过用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    List<SysUser> findUser(String username);

    /**
     * 插入用户信息
     *
     * @param user 用户
     * @return 条目
     */
    int addUser(SysUser user);

    /**
     * 删除用户信息
     *
     * @param userId 用户ID
     * @return 条目
     */
    int delUser(String userId);
}
