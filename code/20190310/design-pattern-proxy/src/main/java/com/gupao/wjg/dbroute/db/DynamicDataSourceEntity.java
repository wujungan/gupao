package com.gupao.wjg.dbroute.db;

public class DynamicDataSourceEntity {

    public static final String DEFAULT_SOURCE="DB_default";

    private static final ThreadLocal<String> local=new ThreadLocal<String>();

    public static void set(int year){
        String db="DB"+year;
        local.set(db);
    }

    public static String get(){
        return local.get();
    }

    public  static void restore(){
        local.set(DEFAULT_SOURCE);
    }

}
