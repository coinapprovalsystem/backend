package com.me.service;

import com.me.entity.SeckillResult;
import com.me.exception.SeckillException;
import com.me.mysql.domain.SeckillInventory;
import com.me.mysql.mapper.SeckillInventoryMapper;
import com.me.mysql.mapper.SeckillSuccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Arrays;

/**
 * 秒杀服务类
 * @author zhaohaojie
 * @date 2019-01-24 17:49
 */
@Service
public class SeckillService {

    private static final String salt = "dajspofj212498142*&^^^)";
    @Autowired
    private SeckillInventoryMapper seckillInventoryMapper;

    @Autowired
    private SeckillSuccessMapper seckillSuccessMapper;

    public String getMD5(Integer phone){
        if (phone == null){
            throw new SeckillException("用户手机号为空。",-1);
        }
        String base = phone+"/"+salt;
        return Arrays.toString(DigestUtils.md5Digest(base.getBytes()));
    }
    /**
     * 执行秒杀操作
     * 1、只包含秒杀业务层处理，没有校验层数据
     * 2、校验MD5是否一致，
     * @return
     */
    public SeckillResult seckillExecute(Integer productId,Integer phoneNumber){
        //1. 校验盐值
        //2. 减库存
        //3. 根据resultCode判断 是否 插成功表，或者抛异常
        return null;
    }
}

