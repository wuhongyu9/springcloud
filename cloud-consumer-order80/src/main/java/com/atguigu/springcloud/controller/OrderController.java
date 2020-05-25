package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {
    public static final String url = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    @ResponseBody
    public CommonResult<Payment> create(Payment payment){
        payment = new Payment(null, UUID.randomUUID().toString());
        return restTemplate.postForObject(url+"/payment/create",payment,CommonResult.class);
    }

    @RequestMapping("/consumer/payment/createEntity")
    @ResponseBody
    public CommonResult<Payment> createEntity(Payment payment){
        payment = new Payment(null, UUID.randomUUID().toString());
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(url+"/payment/create",payment,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"插入失败",null);
        }
    }

    @GetMapping("/consumer/payment/get/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    @ResponseBody
    public CommonResult<Payment> getEntityPaymentById(@PathVariable("id") Long id){
//        return restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
        ResponseEntity<CommonResult> entity =  restTemplate.getForEntity(url+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"当前不存在id为"+id+"的对象",null);
        }
    }
}
