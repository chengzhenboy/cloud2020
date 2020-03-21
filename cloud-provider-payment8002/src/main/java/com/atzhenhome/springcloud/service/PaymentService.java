package com.atzhenhome.springcloud.service;

import com.atzhenhome.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author:Chengzhen
 * @date:2020/3/21
 * @ver:1.0
 **/
public interface PaymentService
{
    
    int create(Payment payment);
    
    Payment getPaymentById(@Param("id") Long id);
}
