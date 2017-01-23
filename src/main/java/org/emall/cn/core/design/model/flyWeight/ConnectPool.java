package org.emall.cn.core.design.model.flyWeight;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @Description 恒元模式就是实现了数据的共享，比如数据连接池，当建立连接时就会从连接池中删除，
 * 将接受新的连接进来
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class ConnectPool {
    private Vector<Connection> pool;
    /**
     * 公有属性
     */
    private String url="jdbc:mysql://10.4.0.20:3306/e_testcgs1021";
    private String driver="com.mysql.jdbc.Driver";
    private String user="tianyuan";
    private String password="s7GaCUG5";
    private int poolSize=100;
    Connection con=null;
    private ConnectPool() {
        pool=new Vector<Connection>(100);
        for (int i = 0; i <pool.size() ; i++) {
            try {
                Class.forName(driver);
                try {
                    con= (Connection) DriverManager.getConnection(url,user,password);
                    pool.add(con);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 返回连接到连接池
     */
    public  synchronized  void  release(){
        pool.add(con);
    }
    public  synchronized Connection getConnection(){
        if(pool.size()>0){
            pool.remove(pool.get(0));
            return pool.get(0);
        }else{
            return null;
        }
    }

}
