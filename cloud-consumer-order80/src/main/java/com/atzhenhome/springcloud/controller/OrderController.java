package com.atzhenhome.springcloud.controller;

import com.atzhenhome.springcloud.entities.CommonResult;
import com.atzhenhome.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author:Chengzhen
 * @date:2020/3/21
 * @ver:1.0
 **/
@RestController
@Slf4j
public class OrderController
{
    // public static final String PAYMENT_URL = "http://localhost:8001";
    // 通过在eureka上注册过的微服务名称调用
    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";
    
    @Resource
    private RestTemplate restTemplate;
    
    @GetMapping("/consumer/payment/create1")
    public CommonResult<Payment> create1(Payment payment)
    {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }
    
    @GetMapping("/consumer/payment/create2")
    public CommonResult<Payment> create2(Payment payment)
    {
        ResponseEntity<CommonResult> commonResultResponseEntity =
            restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (commonResultResponseEntity.getStatusCode().is2xxSuccessful())
        {
            return commonResultResponseEntity.getBody();
        }
        else
        {
            return new CommonResult<>(444, "操作失败");
        }
    }
    
    @GetMapping("/consumer/payment/get1/{id}")
    public CommonResult<Payment> getPayment1(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
    
    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id)
    {
        //可以获得请求头，请求体
        ResponseEntity<CommonResult> forEntity =
            restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful())
        {
            return forEntity.getBody();
        }
        else
        {
            return new CommonResult<>(444, "操作失败");
        }
    }
    
}
