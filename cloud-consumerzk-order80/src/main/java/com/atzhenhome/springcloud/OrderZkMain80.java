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
@EnableDiscoveryClient
public class OrderZkMain80
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderZkMain80.class, args);
    }
    
}
