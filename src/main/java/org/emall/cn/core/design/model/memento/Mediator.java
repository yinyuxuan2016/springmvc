package org.emall.cn.core.design.model.memento;

/**
 * @Description  备忘录模式
 * 用来存储原有对象的某种状态
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/1
 */
public class Mediator {
    private String value;

    public Mediator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
