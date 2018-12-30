package com.me.mysql.domain;

import java.io.Serializable;

public class GoodsInfo implements Serializable {
    private Long goodsId;

    private String goodsName;

    private String goodsType;

    private Long sourceId;

    private Long price;

    private Boolean passedQualified;

    private Long population;

    private static final long serialVersionUID = 1L;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getPassedQualified() {
        return passedQualified;
    }

    public void setPassedQualified(Boolean passedQualified) {
        this.passedQualified = passedQualified;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}