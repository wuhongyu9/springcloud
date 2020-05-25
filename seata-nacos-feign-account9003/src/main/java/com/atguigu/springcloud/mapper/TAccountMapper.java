package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.TAccount;
import com.atguigu.springcloud.entities.TAccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAccountMapper {
    int countByExample(TAccountExample example);

    int deleteByExample(TAccountExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(TAccount record);

    int insertSelective(TAccount record);

    List<TAccount> selectByExample(TAccountExample example);

    TAccount selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") TAccount record, @Param("example") TAccountExample example);

    int updateByExample(@Param("record") TAccount record, @Param("example") TAccountExample example);

    int updateByPrimaryKeySelective(TAccount record);

    int updateByPrimaryKey(TAccount record);

    Long getResidueMoneyByUserId(@Param("uid") Long userid);

    int updateMoneyByUserId(@Param("uid") Long userid,@Param("rmoney") Long money);
}