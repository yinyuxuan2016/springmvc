package org.emall.cn.core.design.model.iterator;

/**
 * @Description 集合的实现类
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class MyCollection implements Collection{
    public String[] str={"A","B","C","D","E"};
    @Override
    public int size() {
        return str.length;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return str[i];
    }
}
