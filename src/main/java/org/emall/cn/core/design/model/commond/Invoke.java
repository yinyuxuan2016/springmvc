package org.emall.cn.core.design.model.commond;

/**
 * @Description 调用命令
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class Invoke {
    private Commond commond;

    public Invoke(Commond commond) {
        this.commond = commond;
    }
    public void action(){
        commond.exe();
    }
}
