package org.emall.cn.core.design.model.iterator;

/**
 * @Description 迭代器的实现类，将集合进行绑定，对于迭代器的操作，认为是对于集合的操作
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class MyIterator implements Iterator{
    private Collection collection;
    private int pos=-1;
    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if(pos>0){
            pos--;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if (pos<collection.size()-1)
            pos++;
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if (pos<collection.size()-1){
            return true;
        }
        return false;
    }

    @Override
    public Object first() {
        pos=1;
        return collection.get(pos);
    }
}
