create table if not exists t_sys_user
(
    USER_ID      varchar(36)                        not null comment '用户ID'
        primary key,
    USERNAME     varchar(20)                        not null comment '用户名',
    PASSWORD     varchar(18)                        not null comment '密码',
    ENABLE       char                               null comment '是否可用',
    DEL_FLAG     char                               null comment '是否删除',
    LOGIN_IP     varchar(15)                        null comment '登陆IP（记录最后一次）',
    LOGIN_DATE   datetime                           null comment '登陆时间（记录最后一次）',
    REVISION     varchar(20)                        null comment '乐观锁',
    CREATED_BY   varchar(36)                        null comment '创建人',
    CREATED_DATE datetime default CURRENT_TIMESTAMP null comment '创建时间',
    UPDATED_BY   varchar(36)                        null comment '更新人',
    UPDATED_DATE datetime default CURRENT_TIMESTAMP null comment '更新时间'
)
    comment '用户表' charset = utf8;

