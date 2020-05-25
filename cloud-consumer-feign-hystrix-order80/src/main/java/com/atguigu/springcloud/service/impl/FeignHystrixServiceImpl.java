package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.FeignHystrixOrderService;
import org.springframework.stereotype.Component;

@Component
public class FeignHystrixServiceImpl implements FeignHystrixOrderService {
    @Override
    public String ConsumertypeOk(Long id) {
        return "Ok,Wrong";
    }

    @Override
    public String ConsumertypeTimeOut(Long id) {
        return "TimeOut,Wrong";
    }
}
