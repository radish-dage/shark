package com.shark.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class Train {

    //车次编码
    private String trainNo;

    //列车编号
    private String stationTrainCode;

    //列车启动站名
    private String startStationName;

    //列车终点站名
    private String endStationName;

    //出发站名
    private String fromStationName;

    //目的地站名
    private String toStationName;

    //发车时间
    private String startTime;

    //到达时间
    private String arriveTime;

    //是否当天到达 0是 1否
    private String dayDifference;

    //列车历时
    private String liShi;

    //商务坐数量
    private String swzNum;

    //商务坐价格
    private String swzPrice;

    //一等坐数量
    private String zyNum;

    //一等坐价格
    private String zyPrice;

    //二等坐数量
    private String zeNum;

    //二等坐价格
    private String zePrice;

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getStationTrainCode() {
        return stationTrainCode;
    }

    public void setStationTrainCode(String stationTrainCode) {
        this.stationTrainCode = stationTrainCode;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getEndStationName() {
        return endStationName;
    }

    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }

    public String getFromStationName() {
        return fromStationName;
    }

    public void setFromStationName(String fromStationName) {
        this.fromStationName = fromStationName;
    }

    public String getToStationName() {
        return toStationName;
    }

    public void setToStationName(String toStationName) {
        this.toStationName = toStationName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getDayDifference() {
        return dayDifference;
    }

    public void setDayDifference(String dayDifference) {
        this.dayDifference = dayDifference;
    }

    public String getLiShi() {
        return liShi;
    }

    public void setLiShi(String liShi) {
        this.liShi = liShi;
    }

    public String getSwzNum() {
        return swzNum;
    }

    public void setSwzNum(String swzNum) {
        this.swzNum = swzNum;
    }

    public String getSwzPrice() {
        return swzPrice;
    }

    public void setSwzPrice(String swzPrice) {
        this.swzPrice = swzPrice;
    }

    public String getZyNum() {
        return zyNum;
    }

    public void setZyNum(String zyNum) {
        this.zyNum = zyNum;
    }

    public String getZyPrice() {
        return zyPrice;
    }

    public void setZyPrice(String zyPrice) {
        this.zyPrice = zyPrice;
    }

    public String getZeNum() {
        return zeNum;
    }

    public void setZeNum(String zeNum) {
        this.zeNum = zeNum;
    }

    public String getZePrice() {
        return zePrice;
    }

    public void setZePrice(String zePrice) {
        this.zePrice = zePrice;
    }

    @Override
    public String toString() {
        return "Train [trainNo=" + trainNo + ", stationTrainCode=" + stationTrainCode + ", startStationName="
                + startStationName + ", endStationName=" + endStationName + ", fromStationName=" + fromStationName
                + ", toStationName=" + toStationName + ", startTime=" + startTime + ", arriveTime=" + arriveTime
                + ", dayDifference=" + dayDifference + ", liShi=" + liShi + ", swzNum=" + swzNum + ", swzPrice="
                + swzPrice + ", zyNum=" + zyNum + ", zyPrice=" + zyPrice + ", zeNum=" + zeNum + ", zePrice=" + zePrice
                + "]";
    }

}
