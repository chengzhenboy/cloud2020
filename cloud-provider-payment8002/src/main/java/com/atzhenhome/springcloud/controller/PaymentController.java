package com.atzhenhome.springcloud.controller;

import com.atzhenhome.springcloud.entities.CommonResult;
import com.atzhenhome.springcloud.entities.Payment;
import com.atzhenhome.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author:Chengzhen
 * @date:2020/3/21
 * @ver:1.0
 **/
@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    
    // 只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0)
        {
            return new CommonResult(200, "插入数据成功，serverPort"+serverPort, result);
        }
        else
        {
            return new CommonResult(444, "插入数据失败", null);
        }
    }
    
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果：" + payment);
        if (payment != null)
        {
            return new CommonResult(200, "查询成功，serverPort:"+serverPort+ payment);
        }
        else
        {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }

    /***
     * 暂停三秒钟
     *
     * @return java.lang.String
     * @param
     * @methodName paymentFeignTimeout
     * @author ChengZhen
     * @date 2020/3/24
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        try
        {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return serverPort;
    }
}
