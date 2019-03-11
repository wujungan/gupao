package com.gupao.wjg.lazySingleton;

import java.io.Serializable;

/**
 * 饿汉式单例，线程安全，双重校验锁
 */
public class LazySingletonThreadSafeDoubleLock implements Serializable {


    private LazySingletonThreadSafeDoubleLock() {
    }

    public static LazySingletonThreadSafeDoubleLock instance=null;

    public static  LazySingletonThreadSafeDoubleLock getInstance(){
        if(instance==null){
            synchronized(LazySingletonThreadSafeDoubleLock.class){
                if(instance==null){
                    instance=new LazySingletonThreadSafeDoubleLock();
                }
            }
        }
        return instance;
    }

}
