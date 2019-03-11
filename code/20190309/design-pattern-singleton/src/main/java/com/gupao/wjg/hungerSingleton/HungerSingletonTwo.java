package com.gupao.wjg.hungerSingleton;

import java.io.Serializable;

/**
 * 饿汉式单例
 */
public class HungerSingletonTwo implements Serializable {

    private static HungerSingletonTwo instance=null;

    static{
        instance=new HungerSingletonTwo();
    }

    private HungerSingletonTwo() {
    }

    private static HungerSingletonTwo getInstance(){
          return instance;
    }
}
