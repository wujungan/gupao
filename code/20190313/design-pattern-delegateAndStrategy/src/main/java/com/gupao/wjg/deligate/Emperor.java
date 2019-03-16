package com.gupao.wjg.deligate;

/**
 * 皇帝 ，发起战争
 */
public class Emperor {

    private PrivyCouncil privyCouncil=new PrivyCouncil();

    private String name;

    public Emperor(String name) {
        this.name = name;
    }

    public void startWar(WarType warType) {
        System.out.println(name + "发起战争");
        privyCouncil.command(warType);
    }
}
