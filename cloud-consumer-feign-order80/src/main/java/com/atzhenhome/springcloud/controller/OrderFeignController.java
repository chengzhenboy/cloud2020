package com.atzhenhome.springcloud.controller;

import com.atzhenhome.springcloud.entities.CommonResult;
import com.atzhenhome.springcloud.entities.Payment;
import com.atzhenhome.springcloud.service.PaymentFeignSrvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:Chengzhen
 * @date:2020/3/24
 * @ver:1.0
 **/
@RestController
@Slf4j
public class OrderFeignController
{
    @Resource
    private PaymentFeignSrvice paymentFeignSrvice;
    @GetMapping("/consumer/payment/get1/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        log.info("我要看到日志信息");
        return paymentFeignSrvice.getPaymentById(id);
    }
    
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        //openfeign-ribbun，客户端一般默认等待一秒钟
        return paymentFeignSrvice.paymentFeignTimeout();
    }
}
