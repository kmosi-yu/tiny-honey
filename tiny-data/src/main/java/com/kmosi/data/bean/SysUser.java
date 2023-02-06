package com.kmosi.data.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-30 15:17
 * @description 用户表
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否可用
     */
    private String enable;

    /**
     * 是否删除
     */
    private String delFlag;

    /**
     * 登陆IP（记录最后一次）
     */
    private String loginIp;

    /**
     * 登陆时间（记录最后一次）
     */
    private Date loginDate;

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
    @JsonFormat(shape =STRING,pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date createdDate;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    @JsonFormat(shape =STRING,pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date updatedDate;
}