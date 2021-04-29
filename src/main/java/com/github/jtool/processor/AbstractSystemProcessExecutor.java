package com.github.jtool.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 系统调用链执行器
 * T 表示任务的返回结果
 * @author Zer01ne
 * @since 2021/4/29 23:47
 */
public abstract class AbstractSystemProcessExecutor<R, T> implements SystemProcessExecutor<R, T> {

    /**
     * 调用链配置
     */
    private final SystemProcessConfigChain<R, T> config = new SystemProcessConfigChain<>();
    /**
     * 调用链头节点
     */
    private final SystemProcessor<R, T> systemProcessor;

    public AbstractSystemProcessExecutor(SystemProcessor<R, T> systemProcessor) {
        this.systemProcessor = systemProcessor;
    }

    /**
     * 初始化配置
     */
    public void init(){
        initProcessList(config);
    }

    @Override
    public List<R> start(T param) {
        if (systemProcessor == null) {
            return Collections.emptyList();
        }
        return execute(param);
    }

    /**
     * 调用链执行,默认执行方式是链式执行，遇到异常终止
     * @param param : 携带参数
     * @return java.util.List<R>
     */
    private List<R> execute(T param){
        List<R> result = new ArrayList<>();
        SystemProcessor<R, T> executeProcessor = systemProcessor;
        do {
            R executeResult = executeProcessor.execute(param);
            result.add(executeResult);

            // 调用方的处理策略
            boolean isGoOn = processStrategy(executeResult);
            if (!isGoOn){
                return result;
            }
        }while ((executeProcessor = executeProcessor.next()) != null);

        return result;
    }

    /**
     * 执行策略
     * @param executeResult : 执行结果
     * @return true is go on
     */
    protected boolean processStrategy(R executeResult) {
        return true;
    }
    /**
     * 获取调用链配置
     * @return com.github.jtool.com.github.jtool.processor.SystemProcessConfig<R,T>
     */
    public SystemProcessConfigChain<R, T> getConfig() {
        return config;
    }
    /**
     * 初始化调用链配置
     * @param config 调用链配置
     * @return void
     */
    public abstract void initProcessList(SystemProcessConfigChain<R, T> config);

}