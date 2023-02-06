package com.kmosi.data.service.impl;

import com.kmosi.data.bean.SysUser;
import com.kmosi.data.mapper.SysUserMapper;
import com.kmosi.data.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-30 15:33
 * @description
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper userMapper;

    /**
     * 通过用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public List<SysUser> findUser(String username) {
        return userMapper.selectByUsername(username);
    }

    /**
     * 插入用户信息
     *
     * @param user 用户
     * @return 条目
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUser(SysUser user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setEnable("0");
        user.setDelFlag("0");
        return userMapper.insert(user);
    }

    /**
     * 删除用户信息
     *
     * @param userId 用户ID
     * @return 条目
     */
    @Override
    public int delUser(String userId) {
        return userMapper.deleteById(userId);
    }
}
