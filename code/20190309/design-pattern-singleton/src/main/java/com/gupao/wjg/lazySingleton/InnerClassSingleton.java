package com.gupao.wjg.lazySingleton;

/**
 * 静态内部类类加载在外部类调用方法时加载，避免了现线程安全，是新能最有的单例
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
        if(InnerClassSingletonHold.instance!=null){
            throw new RuntimeException("inited");
        }
    }

    private static final class InnerClassSingletonHold{
        private static final InnerClassSingleton instance=new InnerClassSingleton();

    }

    public static InnerClassSingleton getInstance(){
        return InnerClassSingletonHold.instance;
    }

    public static void main(String[] args) {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
    }
}
