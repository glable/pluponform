package com.mota.bean;

import com.mota.bean.common.BaseEntity;

import java.util.Date;

/**
 * 语音通知话单
 */
public class YyTzHd extends BaseEntity {

    private String caller;

    private String called;

    private Date calltime;

    private Date ansertime;

    private Date endtime;

    private int duration;

    private double cost;

    private String calltype;

    private String callid;

    private String address;

    private int shaketime;

    private String tjrq;

    private String appid;

    private String durationConditon;

    private String startTime;

    private String endTime;

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getCalled() {
        return called;
    }

    public void setCalled(String called) {
        this.called = called;
    }

    public Date getCalltime() {
        return calltime;
    }

    public void setCalltime(Date calltime) {
        this.calltime = calltime;
    }

    public Date getAnsertime() {
        return ansertime;
    }

    public void setAnsertime(Date ansertime) {
        this.ansertime = ansertime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getShaketime() {
        return shaketime;
    }

    public void setShaketime(int shaketime) {
        this.shaketime = shaketime;
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
}
