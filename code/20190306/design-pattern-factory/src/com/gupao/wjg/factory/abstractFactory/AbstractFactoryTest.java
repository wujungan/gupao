package com.gupao.wjg.factory.abstractFactory;



public class AbstractFactoryTest {
    public static void main(String[] args) {
        ICourseFactory factory=new JavaBigDataFactory();
        factory.createLive().live();
        factory.createRecored().record();
        System.out.println("======================");
    }
}
