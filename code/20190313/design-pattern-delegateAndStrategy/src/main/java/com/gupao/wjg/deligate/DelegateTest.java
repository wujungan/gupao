package com.gupao.wjg.deligate;

public class DelegateTest {
    public static void main(String[] args) {
        Emperor 康熙 = new Emperor("康熙");
        康熙.startWar(WarType.RECAPTURETAIWAN);

        System.out.println("============================");

        Emperor 乾隆 = new Emperor("乾隆");
        乾隆.startWar(WarType.RECOVERYXINJIANG);
    }
}
