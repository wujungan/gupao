package com.gupao.wjg.entity;

public class BigData implements ICourse {
    @Override
    public void desc() {
        System.out.println("通过“实时交易监控系统”的开发，来讲解典型的大数据实时解决方案的过程及原理，包括数据采集（kafka+canal）、数据计算（spark streaming/storm/kafka stream）、数据存储(hbase)、数据应用及可视化（echarts）等");
    }
}
