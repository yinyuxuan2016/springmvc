package org.emall.cn.core.design.model.state;

/**
 * @Description 状态模式 转换类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }
    public void method(){
        if ("state1".equals(state.getState())){
            state.method1();
        }else if("state2".equals(state.getState())){
            state.method2();
        }
    }

    public static void main(String[] args) {
        State state=new State();
        Context context=new Context(state);
        state.setState("state1");
        context.method();
    }
}
