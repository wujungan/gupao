package com.gupao.wjg.dbroute.proxy;

import com.gupao.wjg.dbroute.db.DynamicDataSourceEntity;
import com.gupao.wjg.dbroute.service.IOrderService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy implements InvocationHandler {
    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object  getInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore(args);
        Object invoke = method.invoke(target, args);
        doAfter(args);
        return invoke;
    }

    private void doBefore(Object[] args) {
        Object arg = args[0];
        try {
            System.out.println("代理前");
            Date date =(Date) arg.getClass().getMethod("getCreateTime").invoke(arg,null);
            String yyyy = new SimpleDateFormat("yyyy").format(date);
            Integer dbRouter=Integer.valueOf(yyyy);
            System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
            DynamicDataSourceEntity.set(dbRouter);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private void doAfter(Object[] args) {
        System.out.println("代理后重置数据库");
        DynamicDataSourceEntity.restore();
    }
}
