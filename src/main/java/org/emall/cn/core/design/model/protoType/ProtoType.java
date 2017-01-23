package org.emall.cn.core.design.model.protoType;

import java.io.*;

/**
 * @Description 原型模式
 *             该模式主要是对对象进行复制或者克隆，使得新的对象和现有的对象有一样的属性
 *             适用场景:解决了用new 创建对象会有复杂的权限和数据准备过程
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class ProtoType implements Serializable,Cloneable{
    //浅复制
    public Object clone() throws CloneNotSupportedException{
        ProtoType protoType=(ProtoType)super.clone();
        return protoType;
    }
    //深复制 将当前
    public Object deepClone() throws IOException, ClassNotFoundException {
        /**
         * 使用二进制流进行写操作
         */
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=null;
        oos=new ObjectOutputStream(bos);
        oos.writeObject(this);
        /**
         * 使用二进制流进行读操作
         */
        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);
        return ois.readObject();
    }
}
