package org.emall.cn.core.design.model.iterator;

/**
 * @Description 迭代器模式：
 *提供一个方法可以顺序访问聚合对象的各个元素，而又不暴露其内部的结构
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class ItteratorTest {
    public static void main(String[] args) {
        Collection collection=new MyCollection();
        Iterator i=collection.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
