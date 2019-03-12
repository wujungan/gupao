package com.gupao.wjg.dbroute.dao;

import com.gupao.wjg.dbroute.entity.Order;

import java.util.UUID;

public class OrderDao {
    public String createOrder(Order order){
        System.out.println("OrderDao创建Order成功!");
        return order.getId();
    }
}
