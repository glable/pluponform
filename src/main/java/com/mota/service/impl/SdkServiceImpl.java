package com.mota.service.impl;

import com.mota.bean.AccountInfo;
import com.mota.bean.YyTzHd;
import com.mota.sdk.CCPRestSDK;
import com.mota.service.SdkService;
import com.mota.util.BeanUtil;
import com.mota.util.DateFormat;
import com.mota.util.HttpClientUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class SdkServiceImpl implements SdkService, InitializingBean {

    @Value("${rest.server.ip}")
    private String ip;

    @Value("${rest.server.port}")
    private String port;

    @Value("${rest.account.id}")
    private String id;

    @Value("${rest.account.token}")
    private String token;

    @Value("${rest.account.app}")
    private String app;

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    private CCPRestSDK restAPI;

    private Logger logger = Logger.getLogger(getClass());

    public void afterPropertiesSet() throws Exception {
        if (null == restAPI) {
            restAPI = new CCPRestSDK();
            restAPI.init(ip, port);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
            restAPI.setAccount(id, token);
            restAPI.setAppId(app);// 初始化应用ID
        }

    }

    @Override
    public AccountInfo accountInfo() {
        HashMap<String, Object> result = null;
        AccountInfo accountInfo = new AccountInfo();
        result = restAPI.queryAccountInfo();
        System.out.println("SDKTestQuerytAccountInfo result=" + result);
        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            try {
                accountInfo = (AccountInfo) BeanUtil.mapToObject((HashMap<String, Object>) data.get("Account"), AccountInfo.class);
            } catch (Exception e) {
                logger.error(e);
            }
        } else {
            //异常返回输出错误码和错误信息
//            logger.error("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            accountInfo.setDateCreated("2016-04-20 11:01:41");
            accountInfo.setBalance("-13714.478146");
            accountInfo.setType("0");
            accountInfo.setFriendlyName("南京乾璟通网络科技有限公司");
            accountInfo.setDateUpdated("2018-12-13 15:52:33");
            accountInfo.setStatus("1");
            //Account = {dateCreated=2016-04-20 11:01:41, balance=-13714.478146, subBalance=0.000000, type=0, friendlyName=南京乾璟通网络科技有限公司, dateUpdated=2018-12-13 15:52:33, status=1}

        }
        return accountInfo;
    }

    @Override
    public void mediaFileUpload(String fileName, byte[] bytes) {
        File file = new File(fileName);
        FileInputStream fileInputStream = null;
        try {
            OutputStream output = new FileOutputStream(file);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(bytes);
            fileInputStream = new FileInputStream(file);
            file.deleteOnExit();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> result = restAPI.MediaFileUpload(fileName, fileInputStream);

        System.out.println("SDKTestMediaFileUpload result=" + result);

        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");

        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
    }

    @Override
    public void billRecords(String appid) {
        HashMap<String, Object> result = null;
        AccountInfo accountInfo = new AccountInfo();
        restAPI.setAppId(appid);
        result = restAPI.billRecords("DAY", "");
        System.out.println("SDKTestBillRecords result=" + result);

        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            String address = data.get("downUrl") + "?token=" + data.get("token");
            String responseString = HttpClientUtil.doGet(address);
            final List<YyTzHd> hdList = new ArrayList<YyTzHd>();
            String[] listString = responseString.split("\\r\\n");
            if (null != listString && listString.length > 1) {
                for (int i = 1; i < listString.length; i++) {
                    String[] rowArray = listString[i].replaceAll("\"","").split(",");
                    if (null != rowArray && rowArray.length > 0) {
                        YyTzHd yyTzHd = new YyTzHd();
                        yyTzHd.setCaller(rowArray[0]);
                        yyTzHd.setCalled(rowArray[1]);
                        try {
                            yyTzHd.setCalltime(DateFormat.parseDate(rowArray[2], DateFormat.DEFAULT_DATETIME_FORMAT_SEC));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        try {
                            yyTzHd.setAnsertime(DateFormat.parseDate(rowArray[3], DateFormat.DEFAULT_DATETIME_FORMAT_SEC));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        try {
                            yyTzHd.setEndtime(DateFormat.parseDate(rowArray[4], DateFormat.DEFAULT_DATETIME_FORMAT_SEC));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        yyTzHd.setDuration(Integer.parseInt(rowArray[5].equals("")?"0":rowArray[5]));
                        yyTzHd.setCost(Double.parseDouble(rowArray[6].equals("")?"0":rowArray[6]));
                        yyTzHd.setCalltype(rowArray[7]);
                        yyTzHd.setCallid(rowArray[8]);
                        yyTzHd.setAddress(rowArray[9]);
                        yyTzHd.setShaketime(Integer.parseInt(rowArray[10].equals("")?"0":rowArray[10]));
                        yyTzHd.setTjrq(DateFormat.toString(DateFormat.getYesterday(), "yyyyMMdd"));
                        yyTzHd.setAppid(appid);
                        hdList.add(yyTzHd);
                    }
                }
            }
            //批量保存
            int[] updatedCountArray = primaryJdbcTemplate.batchUpdate("INSERT INTO yy_tz_hd(caller, called, calltime, ansertime, endtime, duration, cost, calltype, callid, address, shaketime, tjrq, appid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    // TODO Auto-generated method stub
                    ps.setString(1, hdList.get(i).getCaller());//要注意，下标从1开始
                    ps.setString(2, hdList.get(i).getCalled());
                    ps.setTimestamp(3, new java.sql.Timestamp(hdList.get(i).getCalltime().getTime()));
                    ps.setTimestamp(4, new java.sql.Timestamp(hdList.get(i).getAnsertime().getTime()));
                    ps.setTimestamp(5, new java.sql.Timestamp(hdList.get(i).getEndtime().getTime()));
                    ps.setInt(6,hdList.get(i).getDuration());
                    ps.setDouble(7,hdList.get(i).getCost());
                    ps.setString(8,hdList.get(i).getCalltype());
                    ps.setString(9,hdList.get(i).getCallid());
                    ps.setString(10,hdList.get(i).getAddress());
                    ps.setInt(11,hdList.get(i).getShaketime());
                    ps.setString(12,hdList.get(i).getTjrq());
                    ps.setString(13,hdList.get(i).getAppid());
                }
                public int getBatchSize() {
                    return hdList.size();
                }
            });
            int sumInsertedCount = 0;
            for (int a : updatedCountArray) {
                sumInsertedCount += a;
            }
            logger.info("batchInsert() end, hdList.size=" + hdList.size() + ",success inserted " + sumInsertedCount + " records");
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
    }

    @Override
    public HashMap<String, Object> billList(String appid, String calltype) {
//        primaryJdbcTemplate.queryForList();
        return null;
    }
}
