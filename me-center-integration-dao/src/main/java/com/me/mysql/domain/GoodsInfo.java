package com.me.mysql.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsInfo implements Serializable {
    private Integer pid;

    private String productName;

    private String goodsType;

    private BigDecimal price;

    private Integer sourceId;

    private String address;

    private Boolean passedQualified;

    private Integer pop;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getPassedQualified() {
        return passedQualified;
    }

    public void setPassedQualified(Boolean passedQualified) {
        this.passedQualified = passedQualified;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }
}