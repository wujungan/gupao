package com.gupao.wjg.dbroute.service;

import com.gupao.wjg.dbroute.entity.Order;

public interface IOrderService {

    public String createOrder(Order order);

    public int quertCount(Order order);
    public char quertChar(Order order);
    public char quertByte(Order order);
}
