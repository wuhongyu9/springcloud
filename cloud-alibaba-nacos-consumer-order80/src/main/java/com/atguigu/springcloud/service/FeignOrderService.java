package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-alibaba-nacos-provider-payment")
public interface FeignOrderService {
    @GetMapping("/nacos/getServerPort/{id}")
    public String getServerPort(@PathVariable("id") Long id);
}
