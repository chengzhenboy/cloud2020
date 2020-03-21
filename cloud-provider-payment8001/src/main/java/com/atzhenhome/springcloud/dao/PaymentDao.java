package com.atzhenhome.springcloud.dao;

import com.atzhenhome.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author:Chengzhen
 * @date:2020/3/21
 * @ver:1.0
 **/
@Mapper
public interface PaymentDao
{
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
