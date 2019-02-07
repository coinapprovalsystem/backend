package com.me.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaohaojie
 * @date 2019-01-24 17:52
 */
@Getter
@Setter
public class SeckillResult {
    private Integer resultCode;// 0:秒杀成功 -1:重复秒杀 -2:秒杀失败
    private String message;

    public SeckillResult(String message,Integer resultCode){
        this.message = message;
        this.resultCode = resultCode;
    }
}

