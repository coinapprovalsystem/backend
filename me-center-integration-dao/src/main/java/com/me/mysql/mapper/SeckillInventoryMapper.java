package com.me.mysql.mapper;

import com.me.mysql.domain.SeckillInventory;
import com.me.mysql.domain.SeckillInventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeckillInventoryMapper {
    long countByExample(SeckillInventoryExample example);

    int deleteByExample(SeckillInventoryExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(SeckillInventory record);

    int insertSelective(SeckillInventory record);

    List<SeckillInventory> selectByExample(SeckillInventoryExample example);

    SeckillInventory selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") SeckillInventory record, @Param("example") SeckillInventoryExample example);

    int updateByExample(@Param("record") SeckillInventory record, @Param("example") SeckillInventoryExample example);

    int updateByPrimaryKeySelective(SeckillInventory record);

    int updateByPrimaryKey(SeckillInventory record);
}