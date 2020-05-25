package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {
    public int createPayment(Payment payment);

    Payment getPaymentBySerial(String serial);

    Payment getPaymentById(long id);
}
