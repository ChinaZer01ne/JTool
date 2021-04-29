package com.github.jtool.core;
/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/11/20 14:37
 */
public abstract class StringUtils {

    /**
     * 是否是空字符串
     * @param target : 目标串
     * @return true represent empty
     */
    public static boolean isEmpty(String target){
        return target == null || target.length() == 0;
    }

    /**
     * 是否是空字符串
     * @param target : 目标串
     * @return true represent not empty
     */
    public static boolean isNotEmpty(String target){
        return !isEmpty(target);
    }

    /**
     * 是否是空字符串
     *
     * @param target : 目标串
     * @return true represent empty
     */
    public static boolean isBlank(String target) {
        return target == null || "".equals(target.trim());
    }

    /**
     * 是否是空字符串
     * @param target : 目标串
     * @return true represent not blank
     */
    public static boolean isNotBlank(String target){
        return !isBlank(target);
    }
}