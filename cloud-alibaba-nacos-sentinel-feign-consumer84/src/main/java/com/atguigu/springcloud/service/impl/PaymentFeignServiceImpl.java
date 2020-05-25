package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public String testA() {
        return "testA fallback";
    }
}
