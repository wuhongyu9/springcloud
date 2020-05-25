package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int createPayment(Payment payment) {
        try{
            return paymentMapper.create(payment);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Payment getPaymentBySerial(String serial) {
        try{
            return paymentMapper.getPaymentBySerial(serial);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Payment getPaymentById(long id) {
        try{
            return paymentMapper.getPaymentById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
