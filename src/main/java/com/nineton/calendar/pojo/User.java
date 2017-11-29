package com.nineton.calendar.pojo;

import java.util.Date;

public class User {
    private String identificationCode;

    private Integer haveCoin;

    private Integer consumeCoin;

    private Date createTime;

    private Double consumeMoney;

    private String packageName;

    private String platform;

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode == null ? null : identificationCode.trim();
    }

    public Integer getHaveCoin() {
        return haveCoin;
    }

    public void setHaveCoin(Integer haveCoin) {
        this.haveCoin = haveCoin;
    }

    public Integer getConsumeCoin() {
        return consumeCoin;
    }

    public void setConsumeCoin(Integer consumeCoin) {
        this.consumeCoin = consumeCoin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getConsumeMoney() {
        return consumeMoney;
    }

    public void setConsumeMoney(Double consumeMoney) {
        this.consumeMoney = consumeMoney;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }
}