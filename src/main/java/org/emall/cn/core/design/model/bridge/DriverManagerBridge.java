package org.emall.cn.core.design.model.bridge;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public abstract  class DriverManagerBridge {
    private IDriverManager driverManager;

    public IDriverManager getDriverManager() {
        return driverManager;
    }

    public void setDriverManager(IDriverManager driverManager) {
        this.driverManager = driverManager;
    }
    public void getConnection() {
        driverManager.getConnection();
    }
}
