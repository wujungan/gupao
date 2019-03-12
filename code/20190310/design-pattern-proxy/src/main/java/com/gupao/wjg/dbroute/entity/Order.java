package com.gupao.wjg.dbroute.entity;

import java.util.Date;

public class Order {
    private String id;
    private Double ammount;
    private Date createTime;

    public Order() {
    }

    public Order(String id, Double ammount, Date createTime) {
        this.id = id;
        this.ammount = ammount;
        this.createTime = createTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public Double getAmmount() {
        return ammount;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
