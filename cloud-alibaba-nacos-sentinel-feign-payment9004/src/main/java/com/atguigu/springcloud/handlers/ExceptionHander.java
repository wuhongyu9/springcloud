package com.atguigu.springcloud.handlers;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class ExceptionHander {

    public static CommonResult byResouceHandler1(BlockException b){
        return new CommonResult(500,b.getClass().getCanonicalName() + "服务不可用o(╥﹏╥)o 11");
    }

    public static CommonResult byResouceHandler2(BlockException b){
        return new CommonResult(500,b.getClass().getCanonicalName() + "服务不可用o(╥﹏╥)o 22");
    }
}
