package com.mota.dao;

import com.mota.bean.YyReport;
import com.mota.bean.YyTzHd;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDao {

    List<YyTzHd> getBillListWithPage(YyTzHd yyTzHd);

    List<YyTzHd> exportData(YyTzHd yyTzHd);

    YyReport dayReport(@Param("calltype")String calltype);

    void insertReport(YyReport yyReport);

    List<YyReport> getReportListWithPage(YyReport yyReport);

    List<YyReport> exportReport(YyReport yyReport);

}