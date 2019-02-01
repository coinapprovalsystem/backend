package com.me.common.baseControl;

import com.alibaba.fastjson.JSONObject;
import com.me.mysql.domain.BaseControl;
import com.me.mysql.mapper.BaseControlMapper;
import com.me.mysql.mapper.SeckillInventoryMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

/**
 * @author zhaohaojie
 * @date 2019-01-29 17:05
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseControlTest {

    @Autowired
    private BaseControlMapper baseControlMapper;

    @Autowired
    private SeckillInventoryMapper mapper;

    @Test
    public void testCRUD(){
        BaseControl baseControl = baseControlMapper.selectByPrimaryKey(1);
        System.out.println(JSONObject.toJSONString(baseControl));;
        System.out.println(baseControl.getControlID());
        Assert.assertNull(baseControl);
        BaseControl baseControlInsert = new BaseControl();
        BeanUtils.copyProperties(baseControl,baseControlInsert);
        baseControlInsert.setControlID(1121);
        baseControlInsert.setCreateTime(LocalDateTime.now().minusDays(1L));
        baseControlInsert.setPid(null);
        int number = baseControlMapper.insertSelective(baseControlInsert);
        System.out.println(number);
    }
}

