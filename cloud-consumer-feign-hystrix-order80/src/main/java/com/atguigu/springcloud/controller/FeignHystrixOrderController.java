package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.FeignHystrixOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "DefaultFunctionMethod")
public class FeignHystrixOrderController {
    @Resource
    private FeignHystrixOrderService feignHystrixOrderService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String ConsumertypeOk(@PathVariable("id") Long id){
        return feignHystrixOrderService.ConsumertypeOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "ConsumertypeTimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String ConsumertypeTimeOut(@PathVariable("id") Long id){
        int age = 10 / 0;
        return feignHystrixOrderService.ConsumertypeTimeOut(id);
    }

//    public String ConsumertypeTimeOutHandler(@PathVariable("id") Long id){
//        return "超时o(╥﹏╥)o";
//    }

    //默认处理方法里面不能加参数
    public String DefaultFunctionMethod(){
        return "默认处理方法,o(╥﹏╥)o";
    }
}
