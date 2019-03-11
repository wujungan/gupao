package com.gupao.wjg.hungerSingleton;

import java.io.Serializable;

/**
 * 饿汉式单例
 */
public class HungerSingletonThree implements Serializable {

    private static HungerSingletonThree instance=new HungerSingletonThree();

    private HungerSingletonThree() {
        if(instance!=null){
            throw new RuntimeException("该实例已经创建，单例不能重读创建");
        }
    }

    public static HungerSingletonThree getInstance(){
          return instance;
    }
}
