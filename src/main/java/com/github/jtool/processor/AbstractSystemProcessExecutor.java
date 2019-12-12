package com.github.jtool.processor;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统调用链执行器
 * T 表示任务的返回结果
 * @author TaoFengfeng
 */
public abstract class AbstractSystemProcessExecutor<T> {

    /**
     * 调用链配置
     */
    private SystemProcessConfig<T> config = new SystemProcessConfig<>();

    /**
     * 初始化配置
     */
    @PostConstruct
    public void init(){
        initProcessList(config);
    }
    /**
     * 调用链执行
     */
    public final List<T> start(Object user) {

        return execute(user);
    }

    /**
     * 这里应该是个策略
     * 调用链执行,默认执行方式是链式执行，遇到异常终止
     */
    private List<T> execute(Object request){

        List<T> result = new ArrayList<>();
        for (SystemProcessor<T> systemProcessor : config.getSystemProcessors()) {
            T executeResult = systemProcessor.execute(request);
            // 调用方的处理策略
            boolean isGoOn = processStrategy(executeResult);

            result.add(executeResult);

            if (!isGoOn){
                return result;
            }
        }
        return result;
    }

    protected boolean processStrategy(T executeResult) {
        return true;
    }
    /**
     * 获取调用链配置
     */
    public SystemProcessConfig<T> getConfig() {
        return config;
    }
    /**
     * 初始化调用链配置
     * @param config
     */
    public abstract void initProcessList(SystemProcessConfig<T> config);



}