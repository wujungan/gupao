package com.gupao.wjg.dbroute.proxy;

import com.gupao.wjg.dbroute.db.DynamicDataSourceEntity;
import com.gupao.wjg.dbroute.entity.Order;
import com.gupao.wjg.dbroute.service.IOrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy {

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    public String createOrder(Order order){
        Date createTime = order.getCreateTime();
        String yyyy = new SimpleDateFormat("yyyy").format(createTime);

        Integer  dbRouter=Integer.valueOf(yyyy);
        DynamicDataSourceEntity.set(dbRouter);
        System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );
        String orderId = orderService.createOrder(order);

        DynamicDataSourceEntity.restore();

        return orderId;

    }
}
