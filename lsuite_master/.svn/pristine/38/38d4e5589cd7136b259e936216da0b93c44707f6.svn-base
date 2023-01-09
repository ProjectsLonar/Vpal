package com.lonar.vendor.vendorportal.reports;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastBranchesDao;
import com.lonar.vendor.vendorportal.dao.LtMastCostCentersDao;
import com.lonar.vendor.vendorportal.dao.LtMastDivisionsDao;
import com.lonar.vendor.vendorportal.dao.LtMastEmployeesDao;
import com.lonar.vendor.vendorportal.dao.LtMastGlAccountsDao;
import com.lonar.vendor.vendorportal.dao.LtMastProdSubCategoriesDao;
import com.lonar.vendor.vendorportal.dao.LtMastProductCategoriesDao;
import com.lonar.vendor.vendorportal.dao.LtMastProductsDao;
import com.lonar.vendor.vendorportal.dao.LtMastStatesDao;
import com.lonar.vendor.vendorportal.dao.LtMastTaxesDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastBranches;
import com.lonar.vendor.vendorportal.model.LtMastCostCenters;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.LtMastProdSubCategories;
import com.lonar.vendor.vendorportal.model.LtMastProductCategories;
import com.lonar.vendor.vendorportal.model.LtMastProducts;
import com.lonar.vendor.vendorportal.model.LtMastReportRequest;
import com.lonar.vendor.vendorportal.model.LtMastStates;
import com.lonar.vendor.vendorportal.model.LtMastTaxes;
import com.lonar.vendor.vendorportal.model.LtVendCompany;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.service.LtMastSysVariablesService;

@Service
public class LtMastExcelReportsServiceImpl implements LtMastExcelReportsService,CodeMaster{

	@Autowired
	LtMastProductsDao ltMastProductsDao;
	
	@Autowired
	LtMastExcelReportsDao ltMastExcelReportsDao;
	
	@Autowired
	LtMastCostCentersDao ltMastCostCentersDao;
	
	@Autowired
	LtMastBranchesDao ltMastBranchesDao;
	
	@Autowired
	LtMastTaxesDao ltMastTaxesDao;
	
	@Autowired
	LtMastDivisionsDao ltMastDivisionsDao;
	
	@Autowired
	LtMastGlAccountsDao ltMastGlAccountsDao;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	@Autowired
	LtMastStatesDao ltMastStatesDao;
	
	@Autowired
	LtMastProdSubCategoriesDao ltMastProdSubCategoriesDao;
	
	@Autowired
	LtMastProductCategoriesDao ltMastProductCategoriesDao;
	
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtMastReportRequestRepository ltMastReportRequestRepository;
	
	@Autowired
	LtVendCompanyDao ltVendCompanyDao;
	
	List<String> colName =new ArrayList<String>();
	List<Object> objectList=new ArrayList<Object>();
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	@Override
	public Status createExcelReport(ReportParameters reportParameters) throws ServiceException, IOException {
		Status status = new Status();
		String saveDirectory=null;;
		List<LtMastMasterReportMap> colNameList = ltMastExcelReportsDao.getHeader(reportParameters.getMasterName());
		for(LtMastMasterReportMap ltMastMasterReportMap:colNameList) {
			colName.add(ltMastMasterReportMap.getReportColName());
		}
		 
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
		 
		if(reportParameters.getMasterName().equals("COSTCENTERS")) {
			List<LtMastCostCenters> excelData=new ArrayList<LtMastCostCenters>();
			 excelData =  ltMastCostCentersDao.getDataForReport(reportParameters);
			 
			 Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			 
			CostCenterThread costCenterThread = new CostCenterThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(costCenterThread);  
			t1.start(); 
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
			
		}else if(reportParameters.getMasterName().trim().equals("BRANCH")) {
			List<LtMastBranches> excelData=new ArrayList<LtMastBranches>();
			excelData =  ltMastBranchesDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			MultiThread multiThread = new MultiThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
			t1.start(); 
			
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getMasterName().trim().equals("EMPLOYEE")) {
			List<LtMastEmployees> excelData=new ArrayList<LtMastEmployees>();
			excelData =  ltMastEmployeesDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			EmployeeThread multiThread = new EmployeeThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
			t1.start(); 
			
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getMasterName().trim().equals("STATE")) {
			List<LtMastStates> excelData=new ArrayList<LtMastStates>();
			excelData =  ltMastStatesDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			StateThread multiThread = new StateThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
			t1.start(); 
			
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getMasterName().trim().equals("PRODUCT_CATEGORY")) {
			List<LtMastProductCategories> excelData=new ArrayList<LtMastProductCategories>();
			excelData =  ltMastProductCategoriesDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			ProductCategoryThread multiThread = new ProductCategoryThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
			t1.start(); 
			
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getMasterName().trim().equals("SUB_PRODUCT_CATEGORY")) {
			List<LtMastProdSubCategories> excelData=new ArrayList<LtMastProdSubCategories>();
			excelData =  ltMastProdSubCategoriesDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			SubProductCategoryThread multiThread = new SubProductCategoryThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
			t1.start(); 
			
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getMasterName().trim().equals("TAX")) {
			List<LtMastTaxes> excelData=new ArrayList<LtMastTaxes>();
			excelData =  ltMastTaxesDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			TaxMasterThread multiThread = new TaxMasterThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
			t1.start(); 
			
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getMasterName().trim().equals("GL_ACCOUNT")) {
			List<LtMastGlAccounts> excelData=new ArrayList<LtMastGlAccounts>();
			excelData =  ltMastGlAccountsDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			GlAccountThread multiThread = new GlAccountThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
			t1.start(); 
			
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getMasterName().trim().equals("DIVISION")) {
			List<DivisionSubDivision> excelData=new ArrayList<DivisionSubDivision>();
			excelData =  ltMastDivisionsDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			DivisionThread multiThread = new DivisionThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
			t1.start(); 
			
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getMasterName().trim().equals("PRODUCT")) {
			List<LtMastProducts> excelData=new ArrayList<LtMastProducts>();
			excelData =  ltMastProductsDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			ProductThread multiThread = new ProductThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
			t1.start(); 
			
			status.setMessage("Report exctracting! Request ID is "+requestId);
			status.setCode(SUCCESS);
			return status;
		}else if(reportParameters.getMasterName().trim().equals("COMPANY")) {
			List<LtVendCompany> excelData=new ArrayList<LtVendCompany>();
			excelData =  ltVendCompanyDao.getDataForReport(reportParameters);
			Long requestId = makeEntryForReport(saveDirectory,reportParameters);
			
			CompanyThread multiThread = new CompanyThread(requestId,colName,saveDirectory,excelData,ltMastReportRequestRepository);
			Thread t1 =new Thread(multiThread);  
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
		ltMastReportRequest.setRequestName(reportParameters.getMasterName());
		ltMastReportRequest.setRequestDate(new Date());
		ltMastReportRequest.setStatus("Inprogress");
		ltMastReportRequest.setSubmittedDate(new Date());
		ltMastReportRequest.setStartDate(new Date());
		ltMastReportRequest = ltMastReportRequestRepository.save(ltMastReportRequest);
		return ltMastReportRequest.getRequestId();
	}




	private String createExcel(List<String> colName, List<LtMastCostCenters> excelData) throws ServiceException, IOException {
		return null;
	
		}
	

	
	
	@Override
	public List<LtMastMasterReportMap> getHeader(String masterName) throws ServiceException {
		
		List<LtMastMasterReportMap> colName = ltMastExcelReportsDao.getHeader(masterName);
		return colName;

		
	}
	
	


	@Override
	public Long getCount(LtMastReportRequest input,Long companyId) throws ServiceException {
		return ltMastExcelReportsDao.getCount(input,companyId);
	}




	@Override
	public List<LtMastReportRequest> getReportRequestDataTableRecords(LtMastReportRequest input,Long companyId)
			throws ServiceException {
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{
			input.setColumnNo(11);
		}
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{
			input.setColumnNo(12);
		}
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{
			input.setColumnNo(13);
		}
		if(input.getColumnNo()==4 && input.getSort().equals("asc"))
		{
			input.setColumnNo(14);
		}
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{
			input.setColumnNo(15);
		}
		if(input.getColumnNo()==6 && input.getSort().equals("desc"))
		{
			input.setColumnNo(16);
		}
		if(input.getColumnNo()==7 && input.getSort().equals("desc"))
		{
			input.setColumnNo(17);
		}
		return ltMastExcelReportsDao.getReportRequestDataTableRecords(input,companyId);
	}

	
	
	

}
