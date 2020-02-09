package com.soft.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/2/9.
 */
public class Account implements Serializable{

    private Integer id;
    private Integer uid;
    private Double money;

    //多对一
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Account(Integer id, Integer uid, Double money) {

        this.id = id;
        this.uid = uid;
        this.money = money;
    }

    public Account() {

    }
}
