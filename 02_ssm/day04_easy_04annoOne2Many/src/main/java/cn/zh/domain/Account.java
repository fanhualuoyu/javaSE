package cn.zh.domain;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;

    private DoubleUser doubleUser;

    public DoubleUser getDoubleUser() {
        return doubleUser;
    }

    public void setDoubleUser(DoubleUser doubleUser) {
        this.doubleUser = doubleUser;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
