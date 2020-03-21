package com.atzhenhome.springcloud.service.impl;

import com.atzhenhome.springcloud.dao.PaymentDao;
import com.atzhenhome.springcloud.entities.Payment;
import com.atzhenhome.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author:Chengzhen
 * @date:2020/3/21
 * @ver:1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;
    
    @Override
    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }
    
    @Override
    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
