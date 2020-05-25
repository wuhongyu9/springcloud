package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.FeignOrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private FeignOrderService feignOrderService;

    @RequestMapping("/comsumer/payment/getServerPort/{id}")
    public String getServerPort(@PathVariable("id") Long id){
        return feignOrderService.getServerPort(id);
    }
}
