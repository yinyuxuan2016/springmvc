package org.emall.cn.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description HashMap的测试
 * HashMap的数据结构是链表，使用key进行hash,为了避免发生数据存在于相同的桶中，有个参数，是JVM中随便数，避免哈希值冲突，导致撞桶事件。
 * HashMap有多种构造方法，有默认的构造方法设置固定的初始化值，还有加载因子。hashMap是先设置内存空间，然后创建链表进行添加。
 * threshold：重新扩容的时候需要的大小。modCount:当对hashMap的链表进行修改时，modCount会进行计数。
 * 实际上HashMap在进行put操作的时候，会查看当前是否需要扩容，如不需要扩容，对key进行hash然后和链表的长度进行与操作。这就是当前key所
 * 在链表的位置，然后进行添加。
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/14
 */
public class HashMapTest {
    public static void main(String[] args) {
        int hash=1323;
        int length=323;
        System.out.println(hash & length);
       /* Map map=new HashMap();
        map.put("key1",1);
        map.put("key1",0);
        map.put("key3",2);
        map.put("key4",4);
        for (Object str:
             map.entrySet()) {
            System.out.println(str.toString());
        }*/
    }
}
