package com.kmosi.data.controller;

import com.kmosi.data.bean.SysDept;
import com.kmosi.data.service.SysDeptService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-08 23:08
 * @description
 */
@RestController
@RequestMapping("sys")
public class SysDeptController {
    @Resource
    private SysDeptService deptService;

    @GetMapping("/dept/{deptName}")
    public List<SysDept> findDept(@PathVariable String deptName) {
        return deptService.findDeptByName(deptName);
    }

    @PostMapping("/dept")
    public SysDept addDept(@RequestBody SysDept dept) {
        return deptService.addDept(dept);
    }
}
