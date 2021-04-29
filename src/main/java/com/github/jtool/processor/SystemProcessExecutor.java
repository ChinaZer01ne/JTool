package com.github.jtool.processor;

import java.util.List;

/**
 * 系统执行器
 * @author Zer01ne
 * @since 2021/4/29 23:50
 */
public interface SystemProcessExecutor<R, T> {

    /**
     * 执行调用链
     * @param param : 调用链参数
     * @return java.util.List<R>
     */
    List<R> start(T param);
}
