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

    @Override
    public char quertByte(Order order) {
        System.out.println("查询Byte");
        return 0;
    }

    @Override
    public int quertCount(Order order) {
        System.out.println("查询数量");
        return 0;
    }

    @Override
    public char quertChar(Order order) {
        System.out.println("查询Char");

        return 0;
    }
}
