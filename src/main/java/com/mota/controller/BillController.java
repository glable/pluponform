package com.mota.controller;

import com.mota.bean.YyReport;
import com.mota.bean.YyTzHd;
import com.mota.bean.common.PageEntity;
import com.mota.sdk.utils.DateUtil;
import com.mota.service.BillService;
import com.mota.util.ExportUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bill")
@CrossOrigin
public class BillController {

    @Autowired
    BillService billService;

    private Logger logger = Logger.getLogger(getClass());

    @RequestMapping("/queryList")
    public Object queryList(YyTzHd yyTzHd) {
        List<YyTzHd> yyTzHds = billService.getBillListWithPage(yyTzHd);
        Map<String, Object> result = new HashMap();
        result.put("code", 20000l);
        result.put("data", new PageEntity<>(yyTzHds));
        return result;
    }

    @RequestMapping("/reportList")
    public Object reportList(YyReport yyReport) {
        List<YyReport> yyReports = billService.getReportListWithPage(yyReport);
        Map<String, Object> result = new HashMap();
        result.put("code", 20000l);
        result.put("data", new PageEntity<>(yyReports));
        return result;
    }

    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    public Object excel(YyTzHd yyTzHd, HttpServletResponse response) throws Exception {

        // 查询到要导出的信息
        List<YyTzHd> billList = billService.exportData(yyTzHd);
        if (billList.size() == 0) {
            Map<String,Object> result = new HashMap();
            result.put("code",20000l);
            result.put("data","无数据导出");
            return result;
        }
        String sTitle = "主叫,被叫,开始呼叫时间,接听时间,挂机时间,通话时长,通话时长,费用,呼叫类型,callid,录音下载地址,振铃时长";
        String mapKey = "caller,called,calltime,ansertime,endtime,duration,cost,calltype,callid,address,shaketime";
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> map = null;
        for (YyTzHd bill : billList) {
            map = new HashMap<>();
            map.put("caller", bill.getCaller());
            map.put("called", bill.getCalled());
            map.put("calltime", DateUtil.dateToStr(bill.getCalltime(),12));
            map.put("ansertime", DateUtil.dateToStr(bill.getAnsertime(),12));
            map.put("endtime", DateUtil.dateToStr(bill.getEndtime(),12));
            map.put("duration", bill.getDuration());
            map.put("cost", bill.getCost());
            map.put("calltype", bill.getCalltype());
            map.put("callid", bill.getCallid());
            map.put("address", bill.getAddress());
            map.put("shaketime", bill.getShaketime());
            dataList.add(map);
        }
        try (final OutputStream os = response.getOutputStream()) {
            ExportUtil.responseSetProperties("bill_", response);
            ExportUtil.doExport(dataList, sTitle, mapKey, os);
            return null;
        } catch (Exception e) {
            logger.error("生成csv文件失败", e);
        }
        Map<String,Object> result = new HashMap();
        result.put("code",20000l);
        result.put("data","数据导出出错");
        return result;
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public Object report(YyReport yyReport, HttpServletResponse response) throws Exception {

        // 查询到要导出的信息
        List<YyReport> reportList = billService.exportReport(yyReport);
        if (reportList.size() == 0) {
            Map<String,Object> result = new HashMap();
            result.put("code",20000l);
            result.put("data","无数据导出");
            return result;
        }
        String sTitle = "报表日期,客户名称,总数量,应答量,合计费用（元）";
        String mapKey = "tjrq,name,zsl,ydl,zfy";
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> map = null;
        for (YyReport report : reportList) {
            map = new HashMap<>();
            map.put("tjrq", report.getTjrq());
            map.put("name", "南京乾璟通网络科技有限公司");
            map.put("zsl", report.getZsl());
            map.put("ydl", report.getYdl());
            map.put("zfy", report.getZfy());
            dataList.add(map);
        }
        try (final OutputStream os = response.getOutputStream()) {
            ExportUtil.responseSetProperties("report_", response);
            ExportUtil.doExport(dataList, sTitle, mapKey, os);
            return null;
        } catch (Exception e) {
            logger.error("生成csv文件失败", e);
        }
        Map<String,Object> result = new HashMap();
        result.put("code",20000l);
        result.put("data","数据导出出错");
        return result;
    }
}
