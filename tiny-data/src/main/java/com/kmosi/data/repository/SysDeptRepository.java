package com.kmosi.data.repository;

import com.kmosi.data.bean.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-08 22:39
 * @description
 */
@Repository
public interface SysDeptRepository extends JpaRepository<SysDept, String> {
    /**
     * 根据部门名称获取信息
     *
     * @param deptName 部门名称
     * @return SysDept
     */
    List<SysDept> findAllByDeptNameContains(String deptName);

}
