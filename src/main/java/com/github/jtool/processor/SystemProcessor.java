package com.github.jtool.processor;


/**
 * 系统处理器
 * @author TaoFengfeng
 */
@FunctionalInterface
public interface SystemProcessor<T> {
    /**
     * 调用链中的处理器方法
     * @param user
     * @return T
     */
    T execute(Object user);

}