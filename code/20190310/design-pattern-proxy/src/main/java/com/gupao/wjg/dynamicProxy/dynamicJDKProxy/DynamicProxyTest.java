package com.gupao.wjg.dynamicProxy.dynamicJDKProxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

public class DynamicProxyTest {

    public static void main(String[] args) {
        RealEstateCompany realEstateCompany=new RealEstateCompany(new Owner());
        Person instance =(Person) realEstateCompany.getInstance();
        instance.buyHouse();

        byte[] $proxy0s = ProxyGenerator.generateProxyClass("$proxy0", new Class[]{Person.class});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("E://$proxy0.class"));
            fileOutputStream.write($proxy0s);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
