package com.github.jtool.processor;


/**
 * 系统处理器
 * @author Zer01ne
 * @since 2021/4/29 23:47
 */
public interface SystemProcessor<R, T> {
    /**
     * 调用链中的处理器方法
     * @param param 携带参数
     * @return R
     */
    R execute(T param);

    /**
     * 获取下一个执行节点
     * @return com.github.jtool.com.github.jtool.processor.SystemProcessor<R,T>
     */
    SystemProcessor<R, T> next();

}