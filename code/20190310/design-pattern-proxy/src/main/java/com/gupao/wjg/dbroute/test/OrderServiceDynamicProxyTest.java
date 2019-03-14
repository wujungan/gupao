package com.gupao.wjg.dbroute.test;

import com.gupao.wjg.dbroute.entity.Order;
import com.gupao.wjg.dbroute.proxy.OrderServiceDynamicProxy;
import com.gupao.wjg.dbroute.service.IOrderService;
import com.gupao.wjg.dbroute.service.OrderService;
import com.gupao.wjg.dynamicProxy.dynamicJDKProxy.Person;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.UUID;

public class OrderServiceDynamicProxyTest {

    public static void main(String[] args) {
        OrderServiceDynamicProxy orderServiceDynamicProxy = new OrderServiceDynamicProxy(new OrderService());
        Order order = new Order(UUID.randomUUID().toString(), 100.23, new Date());
        IOrderService orderService=(IOrderService)orderServiceDynamicProxy.getInstance();

       /* byte[] $proxy0s = ProxyGenerator.generateProxyClass("$proxy0", new Class[]{IOrderService.class});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("D://$proxy0.class"));
            fileOutputStream.write($proxy0s);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        orderService.quertChar(order);
    }
}
