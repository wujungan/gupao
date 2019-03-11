package com.gupao.wjg.hungerSingleton;

import java.io.Serializable;

/**
 * 饿汉式单例
 */
public class HungerSingletonFour implements Serializable {

    private static HungerSingletonFour instance=new HungerSingletonFour();

    private HungerSingletonFour() {
    }

    public static HungerSingletonFour getInstance(){
          return instance;
    }

    public Object readResolve(){
        return instance;
    }
}
