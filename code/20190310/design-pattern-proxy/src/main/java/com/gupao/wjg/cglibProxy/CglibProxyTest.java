package com.gupao.wjg.cglibProxy;

public class CglibProxyTest {
    public static void main(String[] args) {
        try {
            Emplyee instance =(Emplyee) new Headhunters().getInstance(Emplyee.class);
            instance.working();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
