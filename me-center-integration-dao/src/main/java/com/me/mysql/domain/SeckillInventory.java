package com.me.mysql.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SeckillInventory implements Serializable {
    private Integer pid;

    private Integer productId;

    private String productName;

    private Integer productNumber;

    private Double price;

    private LocalDateTime secStartTime;

    private LocalDateTime secEndTime;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getSecStartTime() {
        return secStartTime;
    }

    public void setSecStartTime(LocalDateTime secStartTime) {
        this.secStartTime = secStartTime;
    }

    public LocalDateTime getSecEndTime() {
        return secEndTime;
    }

    public void setSecEndTime(LocalDateTime secEndTime) {
        this.secEndTime = secEndTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
}