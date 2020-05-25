package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.PaymentFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloud-nacos-sentinel-feign-payment",fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {
    @RequestMapping("/testA")
    public String testA();
}
