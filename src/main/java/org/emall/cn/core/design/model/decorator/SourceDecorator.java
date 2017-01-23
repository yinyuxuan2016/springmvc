package org.emall.cn.core.design.model.decorator;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class SourceDecorator implements ISource{
    private ISource source;
    public SourceDecorator(ISource source) {
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("开始装饰==========");
        source.method();
        System.out.println("结束装饰==========");
    }

    public static void main(String[] args) {
        ISource source=new SourceDecorator(new SourceImpl());
        source.method();
    }
}
