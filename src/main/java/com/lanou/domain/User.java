package com.lanou.domain;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by dllo on 17/11/10.
 */
public class User {
    @NotBlank(message ="*用户名不能为空")
    private String uname;
    @NotBlank(message = "*密码不能为空")
    private String pwd;

    public User() {
    }

    public User(String uname, String pwd) {

        this.uname = uname;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
