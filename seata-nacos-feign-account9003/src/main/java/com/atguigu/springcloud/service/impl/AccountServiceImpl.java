package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.mapper.TAccountMapper;
import com.atguigu.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService{
    @Resource
    private TAccountMapper tAccountMapper;

    @Override
    public int reduceAccountMoney(Long userid, Float money) {
        Long residueMoney = tAccountMapper.getResidueMoneyByUserId(userid);
        if(residueMoney < money){
            return -1;
        }
        long resMoney = (long)(residueMoney - money);
        int res = tAccountMapper.updateMoneyByUserId(userid,resMoney);
        return res;
    }
}
