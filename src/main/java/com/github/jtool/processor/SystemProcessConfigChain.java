package com.github.jtool.processor;


import java.util.ArrayList;
import java.util.List;

/**
 * 执行链配置
 * @author Zer01ne
 * @since 2021/4/29 23:47
 */
public class SystemProcessConfigChain<R, T> {

    private SystemProcessor<R, T> first;
    private Node cur;
    private List<SystemProcessor<R, T>> systemProcessors = new ArrayList<>();

    public void add(SystemProcessor<R, T> processor){
        systemProcessors.add(processor);
    }

    public List<SystemProcessor<R, T>> getSystemProcessors() {
        return systemProcessors;
    }

    public SystemProcessConfigChain<R, T> next(SystemProcessor<R, T> systemProcessor) {
        if (cur == null) {
            cur = new Node(null, null);
            first = systemProcessor;
        }
        cur.next = new Node(systemProcessor, null);
        cur = cur.next;
        return this;
    }

    public SystemProcessor<R, T> build() {
        return first;
    }

    class Node{
        private SystemProcessor<R, T> ele;
        private Node next;

        public Node(SystemProcessor<R, T> ele, Node next) {
            this.ele = ele;
            this.next = next;
        }

        public SystemProcessor<R, T> getEle() {
            return ele;
        }

        public void setEle(SystemProcessor<R, T> ele) {
            this.ele = ele;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}