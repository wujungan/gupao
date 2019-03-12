package com.gupao.wjg.dynamicProxy.gpProxy;

import com.gupao.wjg.dynamicProxy.dynamicJDKProxy.Owner;
import com.gupao.wjg.dynamicProxy.dynamicJDKProxy.Person;

public class GpProxyTest {
    public static void main(String[] args) {


        GpProxy.newProxyInstance(Owner.class.getClassLoader(),Owner.class.getInterfaces(),null);
    }
}
