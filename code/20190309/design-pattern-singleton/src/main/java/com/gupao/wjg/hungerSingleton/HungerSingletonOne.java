package com.gupao.wjg.hungerSingleton;

import java.io.Serializable;

/**
 * 饿汉式单例
 */
public class HungerSingletonOne implements Serializable {

    private static  HungerSingletonOne instance=new HungerSingletonOne();

    private HungerSingletonOne() {
    }

    public static HungerSingletonOne getInstance(){
          return instance;
    }
}
