package org.emall.cn.core.design.model.iterator;

/**
 * @Description 集合接口
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public interface Collection {
    public int size();
    public Iterator iterator();
    public Object get(int i);
}
