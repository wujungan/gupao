package com.gupao.wjg.ThreadLocalSingleton;

import java.io.Serializable;

/**
 * 线程范围内单例
 */
public class ThreadLocalSingleton  implements Serializable {

    private static final ThreadLocal<ThreadLocalSingleton> instance=new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance(){
        return instance.get();
    }
}
