package com.github.jtool.processor;


import java.util.ArrayList;
import java.util.List;

/**
 * 执行链配置
 * @author TaoFengfeng
 */
public class SystemProcessConfig<T> {


    private List<SystemProcessor<T>> systemProcessors = new ArrayList<>();

    public void add(SystemProcessor<T> processor){
        systemProcessors.add(processor);
    }

    public List<SystemProcessor<T>> getSystemProcessors() {
        return systemProcessors;
    }
}