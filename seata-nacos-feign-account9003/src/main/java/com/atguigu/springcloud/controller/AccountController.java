package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("/reduceAccountMoney")
    public int reduceAccountMoney(Long userid,Float money){
        return accountService.reduceAccountMoney(userid,money);
    }
}
