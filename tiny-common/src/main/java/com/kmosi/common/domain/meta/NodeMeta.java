package com.kmosi.common.domain.meta;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-12 15:58
 * @description
 */
@Getter
@Setter
@ToString
public class NodeMeta implements Serializable {
    @Serial
    private static final long serialVersionUID = -7060368245265727195L;
    /**
     * 节点ID
     */
    private String id;
    /**
     * 父级菜单ID
     */
    private String parentId;
    /**
     * 子菜单
     */
    private List<? extends NodeMeta> children;
}
