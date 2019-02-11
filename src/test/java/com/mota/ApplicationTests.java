package com.mota;


import com.alibaba.fastjson.JSON;
import com.mota.bean.AccountInfo;
import com.mota.bean.YyReport;
import com.mota.service.BillService;
import com.mota.service.SdkService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    protected SdkService sdkService;
    @Autowired
    protected BillService billService;

    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {

    }

    @Test
    public void test1() throws Exception {

        YyReport report = null;
        try {
            //语音验证码话单
            sdkService.billRecords("8a216da8550b8ac001551435696e0b2d");
            //日报
            report = billService.dayReport("13");
            if(null != report){
                billService.insertReport(report);
            }
        } catch (Exception e) {
            logger.error(e);
        }
        try {
            //语音通话话单
            sdkService.billRecords("8aaf070857418a580157454de2d201a5");
            report = billService.dayReport("14");
            if(null != report){
                billService.insertReport(report);
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

}
