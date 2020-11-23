package com.shark.entity;

import java.io.Serializable;

public class TrainInfo implements Serializable {

    /**
     * 预定
     */
    private String reserve;

    /**
     * 列车编码
     */
    private String trainNo;

    /**
     * 列车编号
     */
    private String stationTrainCode;

    /**
     * 始发站
     */
    private String startStation;

    /**
     * 终点站
     */
    private String endStation;

    /**
     * 出发站名
     */
    private String fromStation;

    /**
     * 目的地站名
     */
    private String toStation;

    /**
     * 发车时间
     */
    private String startTime;

    /**
     * 到达时间
     */
    private String arriveTime;

    /**
     * 是否当天到达 0是 1否
     */
    private String dayDifference;

    /**
     * 列车历时
     */
    private String liShi;

    /**
     * 是否售票
     */
    private String isSellTicket;

    /**
     * 高级软卧数量
     */
    private String grwNum;

    /**
     * 高级软卧价格
     */
    private String grwPrice;

    /**
     * 其他
     */
    private String other;

    /**
     * 软卧数量
     */
    private String rwNum;

    /**
     * 软卧价格
     */
    private String rwPrice;

    /**
     * 软座数量
     */
    private String rzNum;

    /**
     * 软座价格
     */
    private String rzPrice;

    /**
     * 特等座数量
     */
    private String tdzNum;

    /**
     * 特等座价格
     */
    private String tdzPrice;

    /**
     * 无座数量
     */
    private String wzNum;

    /**
     * 无座价格
     */
    private String wzPrice;

    /**
     * 硬卧数量
     */
    private String ywNum;

    /**
     * 硬卧价格
     */
    private String ywPrice;

    /**
     * 硬座数量
     */
    private String yzNum;

    /**
     * 硬座价格
     */
    private String yzPrice;

    /**
     * 二等坐数量
     */
    private String edzNum;

    /**
     * 二等坐价格
     */
    private String edzPrice;

    /**
     * 一等坐数量
     */
    private String ydzNum;

    /**
     * 一等坐价格
     */
    private String ydzPrice;

    /**
     * 商务坐数量
     */
    private String swzNum;

    /**
     * 商务坐价格
     */
    private String swzPrice;

    /**
     * 动卧数量
     */
    private String dwNum;

    /**
     * 动卧价格
     */
    private String dwPrice;

    public TrainInfo(){}

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

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

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
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

    public String getIsSellTicket() {
        return isSellTicket;
    }

    public void setIsSellTicket(String isSellTicket) {
        this.isSellTicket = isSellTicket;
    }

    public String getGrwNum() {
        return grwNum;
    }

    public void setGrwNum(String grwNum) {
        this.grwNum = grwNum;
    }

    public String getGrwPrice() {
        return grwPrice;
    }

    public void setGrwPrice(String grwPrice) {
        this.grwPrice = grwPrice;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getRwNum() {
        return rwNum;
    }

    public void setRwNum(String rwNum) {
        this.rwNum = rwNum;
    }

    public String getRwPrice() {
        return rwPrice;
    }

    public void setRwPrice(String rwPrice) {
        this.rwPrice = rwPrice;
    }

    public String getRzNum() {
        return rzNum;
    }

    public void setRzNum(String rzNum) {
        this.rzNum = rzNum;
    }

    public String getRzPrice() {
        return rzPrice;
    }

    public void setRzPrice(String rzPrice) {
        this.rzPrice = rzPrice;
    }

    public String getTdzNum() {
        return tdzNum;
    }

    public void setTdzNum(String tdzNum) {
        this.tdzNum = tdzNum;
    }

    public String getTdzPrice() {
        return tdzPrice;
    }

    public void setTdzPrice(String tdzPrice) {
        this.tdzPrice = tdzPrice;
    }

    public String getWzNum() {
        return wzNum;
    }

    public void setWzNum(String wzNum) {
        this.wzNum = wzNum;
    }

    public String getWzPrice() {
        return wzPrice;
    }

    public void setWzPrice(String wzPrice) {
        this.wzPrice = wzPrice;
    }

    public String getYwNum() {
        return ywNum;
    }

    public void setYwNum(String ywNum) {
        this.ywNum = ywNum;
    }

    public String getYwPrice() {
        return ywPrice;
    }

    public void setYwPrice(String ywPrice) {
        this.ywPrice = ywPrice;
    }

    public String getYzNum() {
        return yzNum;
    }

    public void setYzNum(String yzNum) {
        this.yzNum = yzNum;
    }

    public String getYzPrice() {
        return yzPrice;
    }

    public void setYzPrice(String yzPrice) {
        this.yzPrice = yzPrice;
    }

    public String getEdzNum() {
        return edzNum;
    }

    public void setEdzNum(String edzNum) {
        this.edzNum = edzNum;
    }

    public String getEdzPrice() {
        return edzPrice;
    }

    public void setEdzPrice(String edzPrice) {
        this.edzPrice = edzPrice;
    }

    public String getYdzNum() {
        return ydzNum;
    }

    public void setYdzNum(String ydzNum) {
        this.ydzNum = ydzNum;
    }

    public String getYdzPrice() {
        return ydzPrice;
    }

    public void setYdzPrice(String ydzPrice) {
        this.ydzPrice = ydzPrice;
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

    public String getDwNum() {
        return dwNum;
    }

    public void setDwNum(String dwNum) {
        this.dwNum = dwNum;
    }

    public String getDwPrice() {
        return dwPrice;
    }

    public void setDwPrice(String dwPrice) {
        this.dwPrice = dwPrice;
    }
}
