package com.kmosi.data.service.impl;

import com.kmosi.data.bean.SysDept;
import com.kmosi.data.repository.SysDeptRepository;
import com.kmosi.data.service.SysDeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-08 23:07
 * @description
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Resource
    private SysDeptRepository deptRepository;

    /**
     * 根据部门名称获取信息
     *
     * @param deptName 部门名称
     * @return SysDept
     */
    @Override
    public List<SysDept> findDeptByName(String deptName) {
        return deptRepository.findAllByDeptNameContains(deptName);
    }

    /**
     * 添加部门信息
     *
     * @param dept 部门
     * @return 部门信息
     */
    @Override
    public SysDept addDept(SysDept dept) {
        return deptRepository.save(dept);
    }
}
