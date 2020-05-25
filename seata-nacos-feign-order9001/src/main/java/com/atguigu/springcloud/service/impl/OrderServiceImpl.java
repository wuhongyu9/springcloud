package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.TOrder;
import com.atguigu.springcloud.mapper.TOrderMapper;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
    @Resource
    private TOrderMapper tOrderMapper;

    @Resource
    private ProductService productService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "why_transaction",rollbackFor = Exception.class)
    public void create(TOrder tOrder) {
        log.info("创建订单");
        tOrderMapper.create(tOrder);

        Long cId = tOrderMapper.selectCurrentSampleId();
        log.info("减去商品数目");
        int res = productService.reduceProductNum(tOrder.getProductid(),tOrder.getPcount());

        log.info("减去账户里面的余额");
        res = accountService.reduceAccountMoney(tOrder.getUserid(),tOrder.getMoney());

        res = tOrderMapper.update(cId,1);
        if(res > 0){
            log.info("创建订单成功!");
        }else{
            log.info("失败");
        }
        throw new RuntimeException("运行时异常");
    }

    @Override
    public int update(Long id, int status) {
        return tOrderMapper.update(id,status);
    }
}
