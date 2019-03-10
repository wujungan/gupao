package com.gupao.wjg.entity;

/**
 * java架构师课程
 */
public  class JavaArchitects implements ICourse {


    @Override
    public void desc() {
        System.out.println("课程主要针对1到5年及以上工作经验的开发人员，提供互联网行业热门技术的Java架构师专题培训，由业内技术大牛，行业及实战经验丰富的讲师进行技术分享。内容涵盖redis/mongodb/dubbo/zookeeper/kafka 高并发、高可用、分布式、高性能、并发编程等技术");
    }
}
