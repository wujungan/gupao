package com.gupao.wjg.dbroute.test;

import com.gupao.wjg.dbroute.entity.Order;
import com.gupao.wjg.dbroute.proxy.GpOrderServiceDynamicProxy;
import com.gupao.wjg.dbroute.proxy.OrderServiceDynamicProxy;
import com.gupao.wjg.dbroute.service.IOrderService;
import com.gupao.wjg.dbroute.service.OrderService;

import java.util.Date;
import java.util.UUID;

public class GpOrderServiceDynamicProxyTest {

    public static void main(String[] args) {
        GpOrderServiceDynamicProxy orderServiceDynamicProxy = new GpOrderServiceDynamicProxy(new OrderService());
        Order order = new Order(UUID.randomUUID().toString(), 100.23, new Date());
        IOrderService orderService=(IOrderService)orderServiceDynamicProxy.getInstance();
        //orderService.createOrder(order);
       // orderService.quertCount(order);
        orderService.quertByte(order);
    }
}
