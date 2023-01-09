package com.lonar.vendor.vendorportal.reports;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastVendorBanksDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsAddressDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.dao.LtVendorApprovalDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastVendorAddress;
import com.lonar.vendor.vendorportal.model.LtMastVendorBanks;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

@Service
public class LtVendorExcelReportsServiceImpl implements LtVendorExcelReportsService, CodeMaster{

	List<String> colName =new ArrayList<String>();
	List<Object> objectList=new ArrayList<Object>();
	
	@Autowired
	LtMastVendorsDao ltMastVendorsDao; 
	
	@Autowired
	LtMastVendorsAddressDao ltMastVendorsAddressDao;
	
	@Autowired
	LtMastVendorBanksDao ltMastVendorBanksDao;
	
	@Autowired
	LtVendorApprovalDao ltVendorApprovalDao;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastReportRequestRepository ltMastReportRequestRepository;
	
	@Override
	public Status createVendorExcelReport(ReportParameters reportParameters) throws ServiceException {
		Status status = new Status();
		String saveDirectory=null;;
		 
		 SysVariableWithValues sysVariableWithValues=
			ltMastSysVariablesService.getBySysVariableName("EXCEL_FILE_UPLOAD_FOLDER_PATH",reportParameters.getCompanyId());

		 if(sysVariableWithValues!=null)
		 {
			 if(sysVariableWithValues.getLtMastSysVariableValues().get(0)!=null)
			 {
				 saveDirectory=sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();
			 }
			 else
			 {
				 saveDirectory=sysVariableWithValues.getLtMastSysVariables().getSystemValue();
			 }
		 }
		 
		if(reportParameters.getReportName().equals("VENDOR_SUMMARY")) {
			List<LtMastVendors> excelData=new ArrayList<LtMastVendors>();
			 excelData =  ltMastVendorsDao.getDataForReport(reportParameters);
			 
			 Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			 
			VendorSummaryThread vendorSummaryThread = new VendorSummaryThread(requestId,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(vendorSummaryThread);  
			t1.start(); 
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
			
		}else if(reportParameters.getReportName().equals("VENDOR_ADDRESS")) {
			List<LtMastVendorAddress> excelData=new ArrayList<LtMastVendorAddress>();
			 excelData =  ltMastVendorsAddressDao.getDataForReport(reportParameters);
			 
			 Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			 
			VendorAddressSummaryThread vendorSummaryThread = new VendorAddressSummaryThread(requestId,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(vendorSummaryThread);  
			t1.start(); 
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
			
		}else if(reportParameters.getReportName().equals("VENDOR_BANK")) {
			List<LtMastVendorBanks> excelData=new ArrayList<LtMastVendorBanks>();
			 excelData =  ltMastVendorBanksDao.getDataForReport(reportParameters);
			 
			 Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			 
			 VendorBanksSummaryThread vendorSummaryThread = new VendorBanksSummaryThread(requestId,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(vendorSummaryThread);  
			t1.start(); 
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getReportName().equals("VENDOR_APPROVAL_SUMMARY")) {
			List<LtVendorApprovalSummary> excelData=new ArrayList<LtVendorApprovalSummary>();
			 excelData =  ltVendorApprovalDao.getDataForReport(reportParameters);
			 
			 Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			 
			 VendorApprovalSummaryThread vendorSummaryThread = new VendorApprovalSummaryThread(requestId,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(vendorSummaryThread);  
			t1.start(); 
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}
		
		return null;
	}
	
	private Long makeEntryForReport(String saveDirectory, ReportParameters reportParameters) 
	{
		LtMastReportRequest ltMastReportRequest = new LtMastReportRequest();
		ltMastReportRequest.setFilterData(reportParameters.toString());
		ltMastReportRequest.setUserId(reportParameters.getLastUpdateLogin());
		ltMastReportRequest.setRequestName(reportParameters.getReportName());
		ltMastReportRequest.setRequestDate(new Date());
		ltMastReportRequest.setStatus("Inprogress");
		ltMastReportRequest.setSubmittedDate(new Date());
		ltMastReportRequest.setStartDate(new Date());
		ltMastReportRequest = ltMastReportRequestRepository.save(ltMastReportRequest);
		return ltMastReportRequest.getRequestId();
	}

}
