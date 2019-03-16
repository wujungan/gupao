package com.gupao.wjg.dynamicProxy.gpProxy;

import com.gupao.wjg.dynamicProxy.dynamicJDKProxy.Owner;
import com.gupao.wjg.dynamicProxy.dynamicJDKProxy.Person;
import com.gupao.wjg.dynamicProxy.dynamicJDKProxy.RealEstateCompany;

public class GpProxyTest {
    public static void main(String[] args) {


    /*    GpRealEstateCompany realEstateCompany=new GpRealEstateCompany(new GpOwner());
        GpPerson instance =(GpPerson) realEstateCompany.getInstance();
          instance.buyHouse();*/
        System.out.println("=================================");

        GpRealEstateCompany realEstateCompany=new GpRealEstateCompany(new GpOwner());
        GpPerson  instance =(GpPerson) realEstateCompany.getInstance();
        Book book=new Book();book.setName("JAVA");
        instance.study(book);

        GpEmplyee e=(GpEmplyee)realEstateCompany.getInstance();
        e.work("JAVA");


        //instance.work("JAVA");

    }
}
