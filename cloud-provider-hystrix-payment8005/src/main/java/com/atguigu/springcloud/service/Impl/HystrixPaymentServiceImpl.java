package com.atguigu.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class HystrixPaymentServiceImpl implements PaymentService {
    @Override
    public String typeOk(Long id) {
        log.info(Thread.currentThread().getName() + "type:ok id:"+id);
        return "当前线程:"+Thread.currentThread().getName()+" type:ok "+"id:"+id + "O(∩_∩)O哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "typeTimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String typeTimeOut(Long id) {
        try{
            int times = 5;
            TimeUnit.SECONDS.sleep(5);
            log.info(Thread.currentThread().getName() + "type:TimeOut id:"+id);
            return "当前线程:"+Thread.currentThread().getName()+" type:TimeOut "+"id:"+id;
        }catch (Exception e){
            log.info("当前服务已超时!");
        }
        return null;
    }

    public String typeTimeOutHandler(Long id) {
        log.info("当前线程:"+Thread.currentThread().getName()+" type:typeTimeOutHandler "+"id:"+id + "o(╥﹏╥)o");
        return "当前线程:"+Thread.currentThread().getName()+" type:typeTimeOutHandler "+"id:"+id + "o(╥﹏╥)o";
    }
    //HystrixCommondProperties

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircleBreakHandler",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircleBreak(Long id) {
        if(id < 0){
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,id:"+id+" 流水号:"+serialNumber;
    }

    public String paymentCircleBreakHandler(Long id){
        return "服务降级了o(╥﹏╥)o id："+id;
    }
}
