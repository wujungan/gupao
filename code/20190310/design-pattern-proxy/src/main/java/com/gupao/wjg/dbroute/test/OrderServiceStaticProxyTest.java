package com.gupao.wjg.dbroute.test;

import com.gupao.wjg.dbroute.entity.Order;
import com.gupao.wjg.dbroute.proxy.OrderServiceStaticProxy;
import com.gupao.wjg.dbroute.service.OrderService;

import java.util.Date;
import java.util.UUID;

public class OrderServiceStaticProxyTest {
    public static void main(String[] args) {
        Order order = new Order(UUID.randomUUID().toString(), 100.23, new Date());
        new OrderServiceStaticProxy(new OrderService()).createOrder(order);
    }
}
