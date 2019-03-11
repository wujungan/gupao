package com.gupao.wjg.lazySingleton;

import java.io.Serializable;

/**
 * 饿汉式单例，线程安全,效率低
 */
public class LazySingletonThreadSafe implements Serializable {


    private LazySingletonThreadSafe() {
    }

    public static LazySingletonThreadSafe instance=null;

    public static synchronized LazySingletonThreadSafe getInstance(){
        if(instance==null){
            instance=new LazySingletonThreadSafe();
        }
        return instance;
    }

}
