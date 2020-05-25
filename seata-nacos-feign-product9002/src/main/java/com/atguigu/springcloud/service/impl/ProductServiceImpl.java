package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.mapper.TProductMapper;
import com.atguigu.springcloud.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private TProductMapper tProductMapper;

    @Override
    public int reduceProductNum(Long productid, int pcount) {
        int residueCount = tProductMapper.getResidueCount(productid);
        if(residueCount < pcount){
            return -1;
        }
        int state = tProductMapper.reduceProductNum(productid,pcount);
        return state;
    }
}
