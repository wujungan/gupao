package com.gupao.wjg.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 猎头公司
 */
public class Headhunters implements MethodInterceptor {


    public Object getInstance(Class<?> clazz) throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        dobefore();
        Object obj = methodProxy.invokeSuper(o, objects);
        doafter();
        return obj;
    }

    private void dobefore() {
        System.out.println("服务前");

    }
    private void doafter() {
        System.out.println("服务后");
    }
}
