package com.atzhenhome.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author:Chengzhen
 * @date:2020/3/22
 * @ver:1.0
 **/
@RestController
@Slf4j
public class OrderZKController
{
    // 通过在eureka上注册过的微服务名称调用
    private static final String PAYMENT_URL = "http://cloud-provider-payment";
    
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
        return result;
    }
    
}
