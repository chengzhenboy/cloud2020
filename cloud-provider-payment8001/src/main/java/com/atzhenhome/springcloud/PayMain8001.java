package com.atzhenhome.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author:Chengzhen
 * @date:2020/3/21
 * @ver:1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //服务发现
public class PayMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PayMain8001.class,args);
    }
}
