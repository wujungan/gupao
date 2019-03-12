package com.gupao.wjg.dbroute.service;

import com.gupao.wjg.dbroute.dao.OrderDao;
import com.gupao.wjg.dbroute.entity.Order;

public class OrderService implements  IOrderService {
    OrderDao orderDao=new OrderDao();
    @Override
    public String createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.createOrder(order);
    }
}
