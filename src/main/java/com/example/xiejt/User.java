package com.example.xiejt;

/**
 * @author xiejt
 * @Description:
 * @date : 2019-1-25 11:16
 *//*
 * @功能描述
 * @Author xiejt
 **/
public class User {
    String userName;
    int age;
    int userId;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
