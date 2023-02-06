package com.kmosi.data.controller;

import com.kmosi.data.bean.SysUser;
import com.kmosi.data.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-30 15:36
 * @description
 */
@RestController
@RequestMapping("/sys")
public class SysUserController {
    @Resource
    private SysUserService userService;

    /**
     * 获取用户（模糊）
     *
     * @param username 用户名
     * @return 用户列表
     */
    @GetMapping({"/user/{username}", "/user"})
    public List<SysUser> findUser(@PathVariable(required = false) String username) {
        return userService.findUser(username);
    }

    @PostMapping("/user")
    public SysUser addUser(@RequestBody SysUser user) {
        userService.addUser(user);
        return user;
    }
}
