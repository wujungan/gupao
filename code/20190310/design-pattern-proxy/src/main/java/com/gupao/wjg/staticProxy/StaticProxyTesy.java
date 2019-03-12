package com.gupao.wjg.staticProxy;

public class StaticProxyTesy {
    public static void main(String[] args) {
        RealEstateAgents realEstateAgents=new RealEstateAgents(new Tenants());
        realEstateAgents.rentHouse();
    }
}
