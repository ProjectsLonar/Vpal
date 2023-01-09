package com.lonar.vendor.vendorportal.reports;

import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastReportRequest;
import com.lonar.vendor.vendorportal.model.ServiceException;

public interface LtMastExcelReportsDao {

	List<LtMastMasterReportMap> getHeader(String masterName) throws ServiceException;

	Long getCount(LtMastReportRequest input, Long companyId) throws ServiceException;

	List<LtMastReportRequest> getReportRequestDataTableRecords(LtMastReportRequest input, Long companyId) throws ServiceException;

}
