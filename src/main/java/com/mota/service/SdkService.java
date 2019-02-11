package com.mota.service;


import com.mota.bean.AccountInfo;

import java.util.HashMap;


/**
 * Gps、警务数据接口.
 */
public interface SdkService {

    /**
     * 主账户信息
     */
    AccountInfo accountInfo();

    /**
     * 语音文件上传
     */
    void mediaFileUpload(String fileName, byte[] bytes);

    /**
     * 话单下载
     */
    void billRecords(String appid);


    /**
     * 账单查询
     * @param appid
     * @param calltype
     * @return
     */
    HashMap<String, Object> billList(String appid, String calltype);
}
