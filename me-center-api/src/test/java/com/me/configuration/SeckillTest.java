package com.me.configuration;

import com.me.mysql.mapper.extension.SeckillInventoryMapper;
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
    @Test
    public void updateInventoryTest(){
        int number = seckillInventoryExtMapper.updateSeckillInventory(1001);
        log.debug("update number is "+number);
    }
}

