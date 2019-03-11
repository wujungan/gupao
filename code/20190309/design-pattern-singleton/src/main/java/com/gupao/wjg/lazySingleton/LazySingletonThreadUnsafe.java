package com.gupao.wjg.lazySingleton;

import java.io.Serializable;

/**
 * 饿汉式单例，线程不安全
 */
public class LazySingletonThreadUnsafe implements Serializable {


    private LazySingletonThreadUnsafe() {
    }

    public static LazySingletonThreadUnsafe instance=null;

    public static LazySingletonThreadUnsafe getInstance(){
        if(instance==null){
            instance=new LazySingletonThreadUnsafe();
        }
        return instance;
    }

}
