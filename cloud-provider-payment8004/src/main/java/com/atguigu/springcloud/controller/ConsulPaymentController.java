package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class ConsulPaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "consul port: " + port + " " + UUID.randomUUID().toString();
    }
}
