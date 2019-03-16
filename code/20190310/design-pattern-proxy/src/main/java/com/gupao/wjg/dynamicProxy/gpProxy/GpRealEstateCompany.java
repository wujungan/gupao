package com.gupao.wjg.dynamicProxy.gpProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * z置业公司代理类JDK动态代理
 */
public class GpRealEstateCompany implements GpInvocationHandler {
   private Object target;

    public GpRealEstateCompany(Object target) {
        this.target = target ;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object invoke = method.invoke(target, args);
        doAfter(target);
        return invoke;
    }

    private void doBefore() {
        System.out.println("发布广告");
    }

    private void doAfter(Object target) {

        System.out.println("寻找合适工作");
        System.out.println("合适入职");
    }

    public Object getInstance(){
        return  GpProxyMulInterface.newProxyInstance(new GpClassLoader(), target.getClass().getInterfaces(), this);
    }
}
