package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-nacos-feign-account")
public interface AccountService {
    @RequestMapping("/account/reduceAccountMoney")
    int reduceAccountMoney(@RequestParam("userid") Long userid,@RequestParam("money") Float money);
}
