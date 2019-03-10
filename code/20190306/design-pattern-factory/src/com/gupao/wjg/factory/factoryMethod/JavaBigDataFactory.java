package com.gupao.wjg.factory.factoryMethod;

import com.gupao.wjg.entity.BigData;
import com.gupao.wjg.entity.ICourse;
import com.gupao.wjg.entity.JavaArchitects;

public class JavaBigDataFactory implements ICourseFactory {
    @Override
    public ICourse createCourse() {
           return new BigData();
    }
}
