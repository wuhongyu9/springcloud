package com.atguigu.springcloud.service;

public interface PaymentService {
    public String typeOk(Long id);

    public String typeTimeOut(Long id);

    public String paymentCircleBreak(Long id);
}
