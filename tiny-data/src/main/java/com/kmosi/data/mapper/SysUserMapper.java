package com.kmosi.data.mapper;

import com.kmosi.data.bean.SysUser;

import java.util.List;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-30 15:17
 * @description
 */
public interface SysUserMapper {
    /**
     * 通过ID删除用户
     *
     * @param userId 主键
     * @return 受影响的条目
     */
    int deleteById(String userId);

    /**
     * 插入用户数据
     *
     * @param user 用户信息
     * @return 受影响的条数
     */
    int insert(SysUser user);

    /**
     * 通过用户名获取用户
     *
     * @param username 用户名
     * @return sysUser
     */
    List<SysUser> selectByUsername(String username);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 受影响的条目
     */
    int updateById(SysUser user);
}