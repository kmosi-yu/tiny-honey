package com.kmosi.data.service;

import com.kmosi.data.bean.SysDept;

import java.util.List;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-08 23:06
 * @description
 */
public interface SysDeptService {
    /**
     * 根据部门名称获取信息
     *
     * @param deptName 部门名称
     * @return SysDept
     */
    List<SysDept> findDeptByName(String deptName);

    /**
     * 添加部门信息
     *
     * @param dept 部门
     * @return 部门信息
     */
    SysDept addDept(SysDept dept);
}
