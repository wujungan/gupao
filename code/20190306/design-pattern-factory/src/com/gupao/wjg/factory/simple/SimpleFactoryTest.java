package com.gupao.wjg.factory.simple;

import com.gupao.wjg.entity.ICourse;
import com.gupao.wjg.factory.simple.CourceFactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourceFactory factory=new CourceFactory();
        ICourse course = factory.createCource("BatInterview");
        if(course!=null){
            course.desc();
        }
    }


}
