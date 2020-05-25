package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HystrixPaymentController {
    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String typeOk(@PathVariable("id") Long id){
        return paymentService.typeOk(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String typeTimeOut(@PathVariable("id") Long id){
        return paymentService.typeTimeOut(id);
    }

    @GetMapping("/payment/hystrix/test/{id}")
    public String paymentCircleBreak(@PathVariable("id") Long id){
        return paymentService.paymentCircleBreak(id);
    }
}
