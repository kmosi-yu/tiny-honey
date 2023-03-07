package com.kmosi.common.utils;

import com.kmosi.common.domain.meta.NodeMeta;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-02-12 15:05
 * @description tree操作类
 */
@SuppressWarnings("unused")
public class TreeUtils {

    /**
     * 获取树tree
     *
     * @param nodes  节点
     * @param rootId 节点ID
     * @param <T>    类型
     * @return tree数据
     */
    public static <T extends NodeMeta> List<T> nodeTree(List<T> nodes, String rootId) {
        // 操作所有菜单数据：将集合转为map结构，key为parentId，value为其对应的list集合
        Map<String, List<T>> nodeGroup = nodes.stream().collect(Collectors.groupingBy(NodeMeta::getParentId));
        // 遍历集合，设置其子节点
        nodes.forEach(node -> node.setChildren(nodeGroup.get(node.getId())));
        // 数据根据层级过滤，返回tree
        return nodes.stream().filter(node -> rootId.equals(node.getParentId())).collect(Collectors.toList());
    }
}
