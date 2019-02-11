package com.mota.task;

import com.mota.bean.YyReport;
import com.mota.service.BillService;
import com.mota.service.SdkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务.
 */
@Component
public class ScheduledTasks {

	@Autowired
	SdkService sdkService;

	@Autowired
	BillService billService;

	private Logger logger = Logger.getLogger(getClass());

	@Scheduled(cron = "0 0 6 * * ?")
	public void bill(){
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
