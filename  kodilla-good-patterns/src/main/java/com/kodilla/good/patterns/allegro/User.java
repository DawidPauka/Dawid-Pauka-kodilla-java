package com.kodilla.good.patterns.allegro;

public class User {
    private String userName;
    private String realName;
    private String realSurname;

    public User(String userName, String realName, String realSurname) {
        this.userName = userName;
        this.realName = realName;
        this.realSurname = realSurname;
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }

    public String getRealSurname() {
        return realSurname;
    }
}