package com.mota.service.impl;

import com.mota.bean.YyReport;
import com.mota.bean.YyTzHd;
import com.mota.dao.BillDao;
import com.mota.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {


    @Autowired
    private BillDao billDao;

    @Override
    public List<YyTzHd> getBillListWithPage(YyTzHd yyTzHd) {
        return billDao.getBillListWithPage(yyTzHd);
    }

    @Override
    public List<YyTzHd> exportData(YyTzHd yyTzHd) {
        return billDao.exportData(yyTzHd);
    }

    @Override
    public YyReport dayReport(String calltype) {
        return billDao.dayReport(calltype);
    }

    @Override
    public void insertReport(YyReport yyReport) {
        billDao.insertReport(yyReport);
    }

    @Override
    public List<YyReport> getReportListWithPage(YyReport yyReport) {
        return billDao.getReportListWithPage(yyReport);
    }

    @Override
    public List<YyReport> exportReport(YyReport yyReport) {
        return billDao.exportReport(yyReport);
    }
}
