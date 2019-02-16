package com.me.mysql.mapper.extension;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import javax.inject.Named;

/**
 * @author zhaohaojie
 * @date 2019-02-07 12:09
 */
@Named("extention.SeckillInventoryMapper")
public interface SeckillInventoryMapper extends com.me.mysql.mapper.SeckillInventoryMapper {

    /**
     * 减库存
     * @author : zhaohaojie
     * @date : 2019/2/7 19:23
     */
    @Update("update dev.Seckill_Inventory set productNumber = productNumber -1,modifyTime = now() where productId=#{productId}")
    int updateSeckillInventory(@Param("productId") Integer productId);

}
