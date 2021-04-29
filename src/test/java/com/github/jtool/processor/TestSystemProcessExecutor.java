package com.github.jtool.processor;
/**
 * 执行调用链测试
 * @author Zer01ne
 * @since 2021/4/30 0:37
 */
public class TestSystemProcessExecutor {

    public static void main(String[] args) {
        SystemProcessor<MockCommonResult, MockLoginParam> head = new SystemProcessConfigChain<MockCommonResult, MockLoginParam>().next(new SystemProcessor<MockCommonResult, MockLoginParam>() {
            @Override
            public MockCommonResult execute(MockLoginParam param) {
                System.out.println("操作1");
                return null;
            }

            @Override
            public SystemProcessor<MockCommonResult, MockLoginParam> next() {
                return null;
            }
        }).next(new SystemProcessor<MockCommonResult, MockLoginParam>() {
            @Override
            public MockCommonResult execute(MockLoginParam param) {
                System.out.println("操作2");
                return null;
            }

            @Override
            public SystemProcessor<MockCommonResult, MockLoginParam> next() {
                return null;
            }
        }).next(new SystemProcessor<MockCommonResult, MockLoginParam>() {
            @Override
            public MockCommonResult execute(MockLoginParam param) {
                System.out.println("操作3");
                return null;
            }

            @Override
            public SystemProcessor<MockCommonResult, MockLoginParam> next() {
                return null;
            }
        }).build();
        LoginSystemProcessExecutor loginSystemProcessExecutor = new LoginSystemProcessExecutor(head);
        loginSystemProcessExecutor.start(null);
    }

    static class LoginSystemProcessExecutor extends AbstractSystemProcessExecutor<MockCommonResult, MockLoginParam> {

        public LoginSystemProcessExecutor(SystemProcessor<MockCommonResult, MockLoginParam> systemProcessor){
            super(systemProcessor);
        }
        @Override
        public void initProcessList(SystemProcessConfigChain<MockCommonResult, MockLoginParam> config) {

        }
    }

    class MockLoginParam{

    }

    class MockCommonResult{

    }
}
