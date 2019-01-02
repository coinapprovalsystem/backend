package com.me.mysql.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsInfo implements Serializable {
    private Integer goodsId;

    private String goodsName;

    private String goodsType;

    private Integer sourceId;

    private BigDecimal price;

    private Boolean passedQualified;

    private Integer population;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
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

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getPassedQualified() {
        return passedQualified;
    }

    public void setPassedQualified(Boolean passedQualified) {
        this.passedQualified = passedQualified;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}