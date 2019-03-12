package com.gupao.wjg.dynamicProxy.dynamicJDKProxy;

/**
 * 业主买房子，找置业公司
 */
public class Owner implements  Person {
    @Override
    public void buyHouse() {
        System.out.println("要在市区");
        System.out.println("100平左右");
        System.out.println("有停车位");
    }
}
