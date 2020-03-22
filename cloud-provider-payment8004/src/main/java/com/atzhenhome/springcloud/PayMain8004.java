package com.atzhenhome.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:Chengzhen
 * @date:2020/3/22
 * @ver:1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient  //该注册注解用于向使用consul或者zookeeper作为注册中心是注册服务
public class PayMain8004
{
    public static void main(String[] args)
    {
        SpringApplication.run(PayMain8004.class, args);
    }
    
}
