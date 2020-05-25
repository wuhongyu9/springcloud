package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-nacos-feign-product")
public interface ProductService {
    @RequestMapping("/product/reduceProductNum")
    int reduceProductNum(@RequestParam("productid") Long productid,@RequestParam("pcount") Integer pcount);
}
