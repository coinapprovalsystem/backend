package com.me.configuration;

import com.me.controller.SeckillController;
import com.me.entity.SeckillResult;
import com.me.mysql.mapper.extension.SeckillInventoryMapper;
import com.me.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaohaojie
 * @date 2019-02-07 12:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SeckillTest {

    @Autowired
    private SeckillInventoryMapper seckillInventoryExtMapper;

    @Autowired
    private SeckillController seckillController;

    @Autowired
    private SeckillService seckillService;

    @Test
    public void updateInventoryTest(){
        int number = seckillInventoryExtMapper.updateSeckillInventory(1001);
        log.debug("update number is "+number);
    }

    @Test
    public void testExecuteSeckill(){
        //参数准备，单个执行秒杀，不含并发
        String phone = "15026969417";
        Integer productId = 1002;//10010测试没有该商品时的事务
        String md5 = seckillService.getMD5(Long.parseLong(phone));
        SeckillResult seckillResult = seckillController.seckillExecute(md5,productId,phone);
        log.debug("code is "+seckillResult.getResultCode());

    }


}

