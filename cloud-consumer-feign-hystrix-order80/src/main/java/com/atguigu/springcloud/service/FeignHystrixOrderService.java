package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.impl.FeignHystrixServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = FeignHystrixServiceImpl.class)
public interface FeignHystrixOrderService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String ConsumertypeOk(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String ConsumertypeTimeOut(@PathVariable("id") Long id);
}
