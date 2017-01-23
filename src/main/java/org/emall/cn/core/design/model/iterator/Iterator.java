package org.emall.cn.core.design.model.iterator;

/**
 * @Description 迭代器接口
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public interface Iterator {
    public Object previous();
    public Object next();
    public boolean hasNext();
    public Object first();
}
