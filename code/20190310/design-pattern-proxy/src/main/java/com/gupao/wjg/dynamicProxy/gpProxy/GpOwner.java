package com.gupao.wjg.dynamicProxy.gpProxy;

import com.gupao.wjg.dynamicProxy.dynamicJDKProxy.Person;

/**
 * 业主买房子，找置业公司
 */
public class GpOwner implements  GpPerson {
    @Override
    public void buyHouse() {
        System.out.println("要在市区");
        System.out.println("100平左右");
        System.out.println("有停车位");
    }

    @Override
    public void study(Book book) {
        System.out.println("开始读书："+book.getName());
    }
}
