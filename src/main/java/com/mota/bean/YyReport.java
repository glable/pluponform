package com.mota.bean;

import com.mota.bean.common.BaseEntity;

import java.util.Date;

/**
 * 日报、月报
 */
public class YyReport extends BaseEntity {

    private Date calltime;

    private int duration;

    private double cost;

    private String calltype;

    private String tjrq;

    private String appid;

    private String durationConditon;

    private String startTime;

    private String endTime;

    private int zsl;

    private int ydl;

    private double zfy;

    private String tjlx;

    public Date getCalltime() {
        return calltime;
    }

    public void setCalltime(Date calltime) {
        this.calltime = calltime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCalltype() {
        return calltype;
    }

    public void setCalltype(String calltype) {
        this.calltype = calltype;
    }

    public String getTjrq() {
        return tjrq;
    }

    public void setTjrq(String tjrq) {
        this.tjrq = tjrq;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getDurationConditon() {
        return durationConditon;
    }

    public void setDurationConditon(String durationConditon) {
        this.durationConditon = durationConditon;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getZsl() {
        return zsl;
    }

    public void setZsl(int zsl) {
        this.zsl = zsl;
    }

    public int getYdl() {
        return ydl;
    }

    public void setYdl(int ydl) {
        this.ydl = ydl;
    }

    public double getZfy() {
        return zfy;
    }

    public void setZfy(double zfy) {
        this.zfy = zfy;
    }

    public String getTjlx() {
        return tjlx;
    }

    public void setTjlx(String tjlx) {
        this.tjlx = tjlx;
    }
}
