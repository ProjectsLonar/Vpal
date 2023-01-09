package com.lonar.vendor.vendorportal.csvupload;

import java.util.List;

public interface LtMastSysRequestsService 
{

	Long getCount(LtMastSysRequests input) throws Exception;

	List<LtMastSysRequests> getLtMastSysRequestsDataTableRecords(LtMastSysRequests input) throws Exception;

	Long getLtMastSysRequestReportCount(LtMastSysRequestReport input, Long reqId) throws Exception;

	List<LtMastSysRequestReport> getLtMastSysRequestReportDataTableRecords(LtMastSysRequestReport input, Long reqId) throws Exception;

}
