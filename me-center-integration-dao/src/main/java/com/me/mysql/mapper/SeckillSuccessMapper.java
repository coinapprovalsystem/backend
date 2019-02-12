package com.me.mysql.mapper;

import com.me.mysql.domain.SeckillSuccess;
import com.me.mysql.domain.SeckillSuccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeckillSuccessMapper {
    long countByExample(SeckillSuccessExample example);

    int deleteByExample(SeckillSuccessExample example);

    int deleteByPrimaryKey(@Param("productId") Integer productId, @Param("phoneNumber") String phoneNumber);

    int insert(SeckillSuccess record);

    int insertSelective(SeckillSuccess record);

    List<SeckillSuccess> selectByExample(SeckillSuccessExample example);

    SeckillSuccess selectByPrimaryKey(@Param("productId") Integer productId, @Param("phoneNumber") String phoneNumber);

    int updateByExampleSelective(@Param("record") SeckillSuccess record, @Param("example") SeckillSuccessExample example);

    int updateByExample(@Param("record") SeckillSuccess record, @Param("example") SeckillSuccessExample example);

    int updateByPrimaryKeySelective(SeckillSuccess record);

    int updateByPrimaryKey(SeckillSuccess record);
}