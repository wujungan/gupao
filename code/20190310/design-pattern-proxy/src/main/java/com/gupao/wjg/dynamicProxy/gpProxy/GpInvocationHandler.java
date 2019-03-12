package com.gupao.wjg.dynamicProxy.gpProxy;

import java.lang.reflect.Method;

public interface GpInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
