package com.me.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 秒杀地址暴露对象
 *
 * @author zhaohaojie
 * @date 2019-02-07 19:18
 */
@Getter
@Setter
public class SeckillUrlExposer {

    //是否暴露秒杀地址
    private boolean exposed;
    //加盐字符串
    private String MD5;
    //产品Id
    private Integer productId;
    //系统当前时间(服务器的时间，方便前端控制倒计时)
    private LocalDateTime nowTime;
    //秒杀开始时间
    private LocalDateTime startTime;
    //秒杀结束时间
    private LocalDateTime endTime;

    public SeckillUrlExposer(boolean exposed, Integer productId) {
        this.exposed = exposed;
        this.productId = productId;
    }

    public SeckillUrlExposer(boolean exposed, Integer productId, LocalDateTime nowTime, LocalDateTime startTime, LocalDateTime endTime) {
        this.exposed = exposed;
        this.productId = productId;
        this.nowTime = nowTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public SeckillUrlExposer(boolean exposed, String MD5, Integer productId, LocalDateTime nowTime, LocalDateTime startTime, LocalDateTime endTime) {
        this.exposed = exposed;
        this.MD5 = MD5;
        this.productId = productId;
        this.nowTime = nowTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

