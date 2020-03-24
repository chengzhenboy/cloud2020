package com.atzhenhome.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author:Chengzhen
 * @date:2020/3/21
 * @ver:1.0
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignMain80
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderOpenFeignMain80.class, args);
    }
}
