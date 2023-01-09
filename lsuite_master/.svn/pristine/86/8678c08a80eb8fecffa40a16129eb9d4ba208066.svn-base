package com.lonar.vendor.vendorportal.reports;

import java.io.IOException;
import java.util.List;

import com.lonar.vendor.vendorportal.model.LtMastReportRequest;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

public interface LtMastExcelReportsService {

	Status createExcelReport(ReportParameters reportParameters) throws ServiceException,IOException;
	
	List<LtMastMasterReportMap> getHeader(String masterName) throws ServiceException;

	Long getCount(LtMastReportRequest input, Long companyId) throws ServiceException;

	List<LtMastReportRequest> getReportRequestDataTableRecords(LtMastReportRequest input, Long companyId) throws ServiceException;

}
