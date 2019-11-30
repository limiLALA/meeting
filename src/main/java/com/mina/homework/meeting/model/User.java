package com.mina.homework.meeting.model;


public class User{
    int id;
    String name;
    int acc_id;
    int type;

    public User() {
    }

    public User(String name, int acc_id, int type) {
        this.name = name;
        this.acc_id = acc_id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
