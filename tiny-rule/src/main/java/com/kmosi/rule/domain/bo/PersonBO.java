package com.kmosi.rule.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-11-26 11:28
 * @description 人的部分信息
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonBO implements Serializable {
    @Serial
    private static final long serialVersionUID = -1347626832774707188L;
    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 出生日期
     */
    @JsonFormat(shape =STRING,pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private LocalDateTime birth;
    /**
     * 地址
     */
    private String address;
    /**
     * 工作
     */
    private String job;
}
