package com.gupao.wjg.staticProxy;

/**
 * 房产中介
 */
public class RealEstateAgents {

    private Tenants tenants;

    public RealEstateAgents(Tenants tenants) {
        this.tenants = tenants;
    }

    public void rentHouse(){
        System.out.println("发布广告");
        tenants.rentHouse();
        System.out.println("寻找合适房源");
        System.out.println("代客看房");
    }
}
