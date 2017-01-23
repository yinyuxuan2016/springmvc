package org.emall.cn.core.design.model.bridge;

/**
 * @Description 桥接模式  将抽象化和实例化解耦，实现二者可以独立变化
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class DriverManagerBridgeImpl extends DriverManagerBridge{
    public void getConnection() {
        getDriverManager().getConnection();
    }

    public static void main(String[] args) {
        DriverManagerBridge driverManagerBridge=new DriverManagerBridgeImpl();
        IDriverManager driverManager=new MysqlDriverManager();
        driverManagerBridge.setDriverManager(driverManager);
        driverManager.getConnection();

        driverManager=new OraceDriverManager();
        driverManagerBridge.setDriverManager(driverManager);
        driverManager.getConnection();

    }
}
