package com.me.service;

import com.me.entity.SeckillResult;
import com.me.entity.SeckillUrlExposer;
import com.me.enums.OrderStatusEnum;
import com.me.exception.SeckillException;
import com.me.mysql.domain.SeckillInventory;
import com.me.mysql.domain.SeckillInventoryExample;
import com.me.mysql.domain.SeckillSuccess;
import com.me.mysql.mapper.SeckillSuccessMapper;
import com.me.mysql.mapper.extension.SeckillInventoryMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 秒杀服务类
 *
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

    public String getMD5(Integer phone) {
        if (phone == null) {
            throw new SeckillException("用户手机号为空。", -1);
        }
        String base = phone + "/" + salt;
        return Arrays.toString(DigestUtils.md5Digest(base.getBytes()));
    }

    /**
     * 执行秒杀操作
     * 1、只包含秒杀业务层处理，没有校验层数据
     * 2、校验MD5是否一致，
     *
     * @return
     */
    public SeckillResult seckillExecute(String MD5, Integer productId, String phoneNumber) {
        //1. 校验盐值
        if (StringUtils.isEmpty(phoneNumber) || !StringUtils.equals(MD5,getMD5(Integer.parseInt(phoneNumber)))){
            throw new SeckillException("用户身份验证失败，请重新登陆。",-1);
        }
        //2. 减库存
        int number = seckillInventoryMapper.updateSeckillInventory(productId);
        //3. 插成功表
        if (number <= 0){
            throw new SeckillException("秒杀失败",-1);
        }else {
            SeckillSuccess seckillSuccess = new SeckillSuccess();
            seckillSuccess.setPhoneNumber(phoneNumber);
            seckillSuccess.setProductId(productId);
            seckillSuccess.setStatus(OrderStatusEnum.WaitToPay.getId());
            int successNumber = seckillSuccessMapper.insert(seckillSuccess);
            //重复秒杀
            if (successNumber == 0){
                throw new SeckillException("重复秒杀",-1);
            }else if (successNumber == 1){

            }
        }
        return new SeckillResult("秒杀成功待付款",0);
    }

    /**
     * 获取暴露的秒杀地址，如果符合要求即可调秒杀地址
     * 否则 显示倒计时
     * @author : zhaohaojie
     * @date : 2019/2/7 23:04
     */
    public SeckillUrlExposer getSeckillUrlExposer(Integer productId){
        SeckillInventoryExample exp = new SeckillInventoryExample();
        exp.createCriteria().andProductIdEqualTo(productId);
        SeckillInventory seckillInventory = seckillInventoryMapper.selectByExample(exp).stream().findFirst().orElse(null);
        if (seckillInventory == null){
            return new SeckillUrlExposer(false,productId);
        } else if (seckillInventory.getSecStartTime().isBefore(LocalDateTime.now()) ||
                seckillInventory.getSecEndTime().isAfter(LocalDateTime.now())){
            return new SeckillUrlExposer(true,productId,
                    LocalDateTime.now(),seckillInventory.getSecStartTime(),seckillInventory.getSecEndTime());
        }
        return new SeckillUrlExposer(false,getMD5(productId),productId,
                LocalDateTime.now(), seckillInventory.getSecStartTime(),seckillInventory.getSecEndTime());
    }

}

