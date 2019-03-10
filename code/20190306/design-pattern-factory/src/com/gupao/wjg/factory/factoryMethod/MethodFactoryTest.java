package com.gupao.wjg.factory.factoryMethod;

public class MethodFactoryTest {
    public static void main(String[] args) {
        ICourseFactory factory=new JavaArchitectsFactory();
        factory.createCourse().desc();
        System.out.println("+++++++++++++++++++++++++++++++++++");
        ICourseFactory factory1=new JavaBigDataFactory();
        factory1.createCourse().desc();

    }
}
