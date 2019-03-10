package com.gupao.wjg.factory.simple;

import com.gupao.wjg.entity.BigData;
import com.gupao.wjg.entity.ICourse;
import com.gupao.wjg.entity.JavaArchitects;

/**
 * 课程创建简单工厂
 */
public class CourceFactory {

    public ICourse createCource(String name){
        if("JavaArchitects".equalsIgnoreCase(name)){
            return new JavaArchitects();
        }else if("BigData".equalsIgnoreCase(name)){
            return new BigData();
        }else{
            return null;
        }
    }
}
