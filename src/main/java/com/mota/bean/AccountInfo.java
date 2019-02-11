package com.mota.bean;

/**
 * 主账户实体信息
 */
public class AccountInfo {

    /**
     * 请求状态码，取值000000（成功），可参考Rest 错误代码
     */
    private String statusCode;

    /**
     * 主账户的创建时间
     */
    private String dateCreated;

    /**
     * 主账户的最近更新时间
     */
    private String dateUpdated;

    /**
     * 主账户名称，唯一，由64个英文字母和阿拉伯数字组成，默认为你的电子邮箱地址
     */
    private String friendlyName;

    /**
     * 主账户类型，取值有0（试用）和1（已注册），默认值为0
     */
    private String type;

    /**
     * 主账户状态，取值有0（未激活）、1（激活）、2（暂停）、3（关闭），默认值为0
     */
    private String status;

    /**
     * 主账户余额
     */
    private String balance;

    /**
     * 副账户余额
     */
    private String subBalance;


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getSubBalance() {
        return subBalance;
    }

    public void setSubBalance(String subBalance) {
        this.subBalance = subBalance;
    }
}
