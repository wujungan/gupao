package com.gupao.wjg.test;

import com.gupao.wjg.hungerSingleton.HungerSingletonFour;
import com.gupao.wjg.hungerSingleton.HungerSingletonOne;
import com.gupao.wjg.hungerSingleton.HungerSingletonThree;
import com.gupao.wjg.registerSingleton.EnumSingleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 破坏单例模式的方式测试
 */
public class DamageSinletonTest {

    /**
     * f反射破话单例
     * 为了防止反射对单例的侵入，可在构造方法上做控制，如HungerSingletonThree
     */
    public void reflection(){
        //1.反射破坏单例
        HungerSingletonOne hungerSingletonOne=HungerSingletonOne.getInstance();

        try {
            Constructor<HungerSingletonOne> declaredConstructor = HungerSingletonOne.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            HungerSingletonOne hungerSingletonOneReflection = declaredConstructor.newInstance();
            System.out.println(hungerSingletonOne==hungerSingletonOneReflection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化破坏单例，可在单例类中加 readResolve()方法并返回该实例,如HungerSingletonFour
     */
    public void serializable(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("hungerSingletonOne.obj")));
            HungerSingletonOne hungerSingletonOne=HungerSingletonOne.getInstance();
            objectOutputStream.writeObject(hungerSingletonOne);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("hungerSingletonOne.obj")));
            Object o = objectInputStream.readObject();
            System.out.println(o==hungerSingletonOne);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试构造方法控制后无法反射侵入单例
     */
    public void disReflection(){
        HungerSingletonThree hungerSingletonThree=HungerSingletonThree.getInstance();

        try {
            Constructor<HungerSingletonThree> declaredConstructor = HungerSingletonThree.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            HungerSingletonThree hungerSingletonThreeReflection = declaredConstructor.newInstance();//直接报错
            System.out.println(hungerSingletonThree==hungerSingletonThreeReflection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * c测试防止序列化侵入单例
     */
    public void disSerializable(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("hungerSingletonFour.obj")));
            HungerSingletonFour hungerSingletonFour=HungerSingletonFour.getInstance();
            objectOutputStream.writeObject(hungerSingletonFour);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("hungerSingletonFour.obj")));
            Object o = objectInputStream.readObject();
            System.out.println(o==hungerSingletonFour);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 底层已经有防止反序列化侵入
     */
    public void disEnumSerializable(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("enumSingleton.obj")));
            EnumSingleton enumSingleton=EnumSingleton.WEIXIN;
            objectOutputStream.writeObject(enumSingleton);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("enumSingleton.obj")));
            Object o = objectInputStream.readObject();
            System.out.println(o==enumSingleton);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DamageSinletonTest test=new DamageSinletonTest();
       // test.reflection();
       // test.serializable();
       // test.disReflection();
       // test.disSerializable();//返回true
        test.disEnumSerializable();
    }
}
