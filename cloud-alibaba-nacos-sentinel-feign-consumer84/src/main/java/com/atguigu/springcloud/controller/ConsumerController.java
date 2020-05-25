package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/testA")
    public String testA(){
        return paymentFeignService.testA();
    }
}
