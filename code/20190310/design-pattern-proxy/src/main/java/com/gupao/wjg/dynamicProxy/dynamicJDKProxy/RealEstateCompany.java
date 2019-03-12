package com.gupao.wjg.dynamicProxy.dynamicJDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * z置业公司代理类JDK动态代理
 */
public class RealEstateCompany implements InvocationHandler {
   private Person person;

    public RealEstateCompany(Person person) {
        this.person = person ;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object invoke = method.invoke(person, args);
        doAfter();
        return invoke;
    }

    private void doBefore() {
        System.out.println("发布广告");
    }

    private void doAfter() {
        System.out.println("寻找合适房源");
        System.out.println("代客看房");
    }

    public Object getInstance(){
        return  Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
    }
}
