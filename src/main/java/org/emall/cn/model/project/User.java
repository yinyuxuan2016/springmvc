package org.emall.cn.model.project;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/9/22
 */
public class User  implements java.io.Serializable {
    private Integer id;
    private String username;
    private String password;
    private String age;
    private String tel;
    private String sessionid;

    // Constructors
    /** default constructor */
    public User() {
    }
    /** minimal constructor */
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /** full constructor */
    public User(Integer id, String username, String password, String age, String tel, String sessionid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.tel = tel;
        this.sessionid = sessionid;
    }
    @Override
    public String toString(){
        return this.username + this.password;
    }
    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getSessionid() {
        return sessionid;
    }
    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }
}
