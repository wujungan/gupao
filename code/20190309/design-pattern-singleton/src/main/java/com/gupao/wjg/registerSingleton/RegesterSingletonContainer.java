package com.gupao.wjg.registerSingleton;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式枚举--容器
 */
public class RegesterSingletonContainer implements Serializable {

    private static Map<String,Object> beanMap=new ConcurrentHashMap<String,Object>();


    private RegesterSingletonContainer() {
    }

    private static Object getInstance(String beanClassName) {
        synchronized (beanMap) {
            if (!beanMap.containsKey(beanClassName)) {
                try {
                    Class<?> clazz = Class.forName(beanClassName);
                    return clazz.newInstance();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                return beanMap.get(beanClassName);
            }
        }
        return null;
    }
}
