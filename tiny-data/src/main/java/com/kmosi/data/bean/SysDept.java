package com.kmosi.data.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-08 22:39
 * @description
 */
@Setter
@Getter
@Table(name = "t_sys_dept")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SysDept implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 部门ID
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String deptId;

    /**
     * 父节点ID
     */
    private String parentId;

    /**
     * 祖父节点IDS
     */
    private String ancestorId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 排序（上移下移）
     */
    private String sortNum;

    /**
     * 是否可用
     */
    private String enable;

    /**
     * 删除标志
     */
    private String delFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 租户号
     */
    private String tenantId;

    /**
     * 乐观锁
     */
    private String revision;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedDate;

}

