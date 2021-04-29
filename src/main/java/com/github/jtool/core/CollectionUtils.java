package com.github.jtool.core;

import java.util.Collection;
import java.util.Map;

/**
 * @author Zer01ne
 * @since 2021/4/29 23:32
 */
public abstract class CollectionUtils {

    /**
     * 判断集合是否为空
     * @param collection : 目标集合
     * @return true represent empty
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * @param map : 目标映射
     * @return true represent empty
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
