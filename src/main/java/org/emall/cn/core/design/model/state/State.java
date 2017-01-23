package org.emall.cn.core.design.model.state;

/**
 * @Description 状态模式 状态类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class State {
    private  String state;

   /* public State(String state) {
        this.state = state;
    }*/

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public void method1(){
        System.out.println("this is method1");
    }
    public void method2(){
        System.out.println("this is method2");
    }
}
