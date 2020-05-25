package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.handlers.ExceptionHander;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    @RequestMapping("/byResource")
    @SentinelResource(value="byResouce",blockHandlerClass = ExceptionHander.class,blockHandler = "byResouceHandler1")
    public CommonResult byResource(){
        return new CommonResult(200,"OK",new Payment(2020L,"serial001"));
    }

    @RequestMapping("/testResource")
    @SentinelResource(value = "testResource",blockHandler = "testResourceHandle")
    public String testResource(){
        return "testResource";
    }

    public String testResourceHandle(BlockException e){
        return "testResource exception handler";
    }
}
