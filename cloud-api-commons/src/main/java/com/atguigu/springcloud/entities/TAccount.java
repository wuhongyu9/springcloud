package com.atguigu.springcloud.entities;

import java.io.Serializable;

public class TAccount implements Serializable {
    private Long userid;

    private Long money;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}