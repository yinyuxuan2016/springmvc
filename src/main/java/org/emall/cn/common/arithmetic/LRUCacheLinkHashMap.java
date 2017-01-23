package org.emall.cn.common.arithmetic;

import java.util.Hashtable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 基于双向列表实现LRU缓存淘汰机制
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class LRUCacheLinkHashMap<K,V> {
    private LinkCacheNode firstNode;
    private LinkCacheNode lastNode;
    private final int MAX_CACHE_SIZE;
    private Hashtable<K,LinkCacheNode> hashtable;

    /**
     * 初始化缓存的最大数量，创建最大数量的缓存
     * @param cacheSize
     */
    public LRUCacheLinkHashMap(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
        hashtable=new Hashtable<>(cacheSize);
    }
    /**
     * 当向链表里放数据，将最新的数据指向链表头
     */
    public synchronized  void put(K key,V value){
        //如果链表已经达到了最大的限制，则先删除表尾的数据
        LinkCacheNode cacheNode=getCacheNode(key);
        if (hashtable.size()>=MAX_CACHE_SIZE){
            if (lastNode!=null){
                hashtable.remove(lastNode.key);
                //当缓存容量满的时候，移除链表尾部的数据
                removeLastNode();
            }
        }
        cacheNode=new LinkCacheNode();
        cacheNode.key=key;
        cacheNode.value=value;
        //将新加入的节点添加到链表头
        moveToHeadNode(cacheNode);
        hashtable.put(key,cacheNode);
        System.out.println("当前线程:" + Thread.currentThread().getName()  + ",put操作:firstNode:" + firstNode);
        System.out.println("当前线程:" + Thread.currentThread().getName() +",put操作:lastNode:" + lastNode);
        System.out.println("=================================================");
    }
    /***
     * 移除链表尾部的节点
     */
    public void removeLastNode(){
        if (lastNode!=null){
            if(lastNode.prev!=null){
                lastNode.prev.next=null;
            }else{
                firstNode=null;
            }
            lastNode=lastNode.prev;
        }
    }
    /**
     * 节点的获取,模拟每次获取一次,都将该节点移动到链表头,表示最近刚被访问过
     * @param key
     * @return
     */
    public synchronized  Object get(K key){
        LinkCacheNode cacheNode=getCacheNode(key);
        if (cacheNode==null){
            return null;
        }
        moveToHeadNode(cacheNode);
        System.out.println("当前线程:" + Thread.currentThread().getName() + ",get操作:firstNode:" + firstNode);
        System.out.println("当前线程:" + Thread.currentThread().getName() + ",get操作:lastNode:" + lastNode);
        System.out.println("================================");
        return cacheNode.value;
    }
    /**
     * 节点的删除
     *
     * @param key
     */
    public synchronized void remove(K key) {
        LinkCacheNode cacheNode=getCacheNode(key);
        if (cacheNode!=null){
            if (cacheNode.prev!=null){
                cacheNode.prev.next=cacheNode.next;
            }
            if (cacheNode.next!=null){
                cacheNode.next.prev=cacheNode.prev;
            }
            // 如果删除的是链表头部节点,将下一个节点设置为第一个节点
            if (cacheNode==firstNode){
                firstNode=cacheNode.next;
            }
            // 如果删除的是链表尾部节点,将上一个节点设置为最后一个节点
            if (lastNode==cacheNode){
                lastNode=cacheNode.prev;
            }
        }
        hashtable.remove(key);
    }
    /***
     * 将新加入的节点添加到链表头
     */
    public void moveToHeadNode(LinkCacheNode cacheNode){
        //如果是第一个节点，则不需要移动
        if (firstNode==cacheNode){
            return;
        }
        //在移动节点前，首先要设置当前节点的前后节点的引用关系
        if (cacheNode.prev!=null){
            cacheNode.prev.next=cacheNode.next;
        }
        if (cacheNode.next!=null){
            cacheNode.next.prev=cacheNode.prev;
        }
        //如果当前节点是最后一个节点
        if (lastNode==cacheNode){
            lastNode=cacheNode.prev;
        }
        if (firstNode!=null){
            // 移动节点的下一个节点的引用指向未移动前的链表的第一个节点
            cacheNode.next=firstNode;
            // 未移动前链表的第一个节点的前一个节点的引用指向当前移动的节点
            firstNode.prev=cacheNode;
        }
        // 将移动节点设置为链表头部节点
        firstNode=cacheNode;
        cacheNode.prev=null;
        if (lastNode==null){
            lastNode=firstNode;
        }
    }
    /**
     * 内部类，定义节点对象
     */
    class LinkCacheNode{
        //前一个节点
        private LinkCacheNode prev;
        //下一个节点
        private LinkCacheNode next;
        //当前节点的key
        private K key;
        //当前节点的value
        private V value;
    }
    /**
     * 通过key获得节点对象
     */
    private LinkCacheNode getCacheNode(K key){
        return hashtable.get(key);
    }

    public static void main(String[] args) throws InterruptedException {
        final LRUCacheLinkHashMap<String, String> lru =
                new LRUCacheLinkHashMap<String, String>(3);
        final CountDownLatch latch = new CountDownLatch(15);
        /**
         * 使用多线程进行并发的模拟操作，启动十五个线程，确保每个线程处理完相关的事务
         */
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=1;i<=15;i++){
            final int index = i;
            service.submit(new  Runnable() {
                @Override
                public void run() {
                    lru.put(String.valueOf(index), "value:" + index);
                    latch.countDown();
                }
            });
        }
        latch.await();
    }
}
