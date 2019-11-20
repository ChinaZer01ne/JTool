package com.github.jtool.core;
/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/11/20 14:37
 */
public class StringUtils {

    public static boolean isEmpty(String target){
        return target == null || "".equals(target.trim());
    }

    private StringUtils(){

    }
}