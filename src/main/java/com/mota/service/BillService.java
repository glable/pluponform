package com.mota.service;

import com.mota.bean.YyReport;
import com.mota.bean.YyTzHd;

import java.util.List;

public interface BillService {

    /**
     * 获取账单分页信息
     * @param yyTzHd
     * @return
     */
    List<YyTzHd> getBillListWithPage(YyTzHd yyTzHd);

    /**
     * 获取报表分页信息
     * @param yyReport
     * @return
     */
    List<YyReport> getReportListWithPage(YyReport yyReport);

    /**
     * 报表导出
     * @param yyReport
     * @return
     */
    List<YyReport> exportReport(YyReport yyReport);

    /**
     * 账单导出
     * @param yyTzHd
     * @return
     */
    List<YyTzHd> exportData(YyTzHd yyTzHd);


    /**
     * 统计日报
     * @param calltype
     * @return
     */
    YyReport dayReport(String calltype);

    /**
     * 插入报表数据
     * @param yyReport
     */
    void insertReport(YyReport yyReport);

}
