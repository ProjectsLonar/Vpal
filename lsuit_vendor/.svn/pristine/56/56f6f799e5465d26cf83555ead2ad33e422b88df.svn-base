package com.lonar.vendor.vendorportal.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.controller.POReportService;
import com.lonar.vendor.vendorportal.controller.VendorBuyerDetails;
import com.lonar.vendor.vendorportal.dao.LtMastEmployeesDao;
import com.lonar.vendor.vendorportal.dao.LtPoHeadersDao;
import com.lonar.vendor.vendorportal.dao.LtVendCompanyDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.DashboardDetails;
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.LtPoHeaders;
import com.lonar.vendor.vendorportal.model.LtPoReport;
import com.lonar.vendor.vendorportal.model.LtVendCompany;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.repository.LtMastEmailtokenRepository;
import com.lonar.vendor.vendorportal.repository.LtPoHeadersRepository;

@Service
public class LtPoHeadersServiceImpl implements LtPoHeadersService, CodeMaster {

	@Autowired
	LtPoHeadersDao ltPoHeadersDao;

	@Autowired
	LtPoHeadersRepository ltPoHeadersRepository;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Autowired
	LtMastEmailtokenRepository ltMastEmailtokenRepository;

	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;

	@Autowired
	LtVendCompanyDao ltVendCompanyDao;

	
	@Override
	public Long getLtPoHeaderCount(LtPoHeaders input,Long companyId) throws ServiceException {
		return ltPoHeadersDao.getLtPoHeaderCount(input,companyId);
	}

	@Override
	public List<LtPoHeaders> getLtPoHeaderDataTable(LtPoHeaders input,Long companyId) throws ServiceException {
		if (input.getColumnNo() == 2 && input.getSort().equals("desc")) {
			input.setColumnNo(22);
		}
		if (input.getColumnNo() == 3 && input.getSort().equals("desc")) {
			input.setColumnNo(23);
		}
		if (input.getColumnNo() == 4 && input.getSort().equals("desc")) {
			input.setColumnNo(24);
		}
		if (input.getColumnNo() == 5 && input.getSort().equals("desc")) {
			input.setColumnNo(25);
		}
		if (input.getColumnNo() == 6 && input.getSort().equals("desc")) {
			input.setColumnNo(26);
		}
		if (input.getColumnNo() == 7 && input.getSort().equals("desc")) {
			input.setColumnNo(27);
		}
		if (input.getColumnNo() == 8 && input.getSort().equals("desc")) {
			input.setColumnNo(28);
		}
		if (input.getColumnNo() == 9 && input.getSort().equals("desc")) {
			input.setColumnNo(29);
		}
		if (input.getColumnNo() == 11 && input.getSort().equals("desc")) {
			input.setColumnNo(31);
		}
		if (input.getColumnNo() == 10 && input.getSort().equals("asc")) {
			input.setColumnNo(30);
		}
		return ltPoHeadersDao.getLtPoHeaderDataTable(input,companyId);
	}

	@Override
	public List<LtPoHeaders> getAllPoHeaders() throws ServiceException {
		return ltPoHeadersDao.getAllPoHeaders();
	}

	@Override
	public List<LtPoHeaders> getAllActivePoHeaders() throws ServiceException {
		return ltPoHeadersDao.getAllActivePoHeaders();
	}

	@Override
	public LtPoHeaders getPoHeaderById(Long poHeaderId) throws ServiceException {
		return ltPoHeadersDao.getPoHeaderById(poHeaderId);
	}

	@Override
	public Status save(LtPoHeaders ltPoHeaders) throws ServiceException {
		Status status = new Status();
		ltPoHeaders = ltPoHeadersRepository.save(ltPoHeaders);
		if (ltPoHeaders.getPoHeaderId() != null) {
			status = ltMastCommonMessageService.getCodeAndMessage(INSERT_SUCCESSFULLY);
			if (status.getMessage() == null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		} else {
			status = ltMastCommonMessageService.getCodeAndMessage(INSERT_FAIL);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		return status;
	}

	@Override
	public Status update(LtPoHeaders ltPoHeaders) throws ServiceException {
		Status status = new Status();
		ltPoHeaders = ltPoHeadersRepository.save(ltPoHeaders);
		if (ltPoHeaders.getPoHeaderId() != null) {
			status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if (status.getMessage() == null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		} else {
			status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		return status;
	}

	@Override
	public Long getLtPoHeaderCountByVendorId(LtPoHeaders input, Long venId) throws ServiceException {
		return ltPoHeadersDao.getLtPoHeaderCountByVendorId(input, venId);
	}

	@Override
	public List<LtPoHeaders> getLtPoHeadersDataTableByVendorId(LtPoHeaders input, Long venId) throws ServiceException {

		if (input.getColumnNo() == 1 && input.getSort().equals("asc")) {
			input.setColumnNo(21);
		}
		if (input.getColumnNo() == 2 && input.getSort().equals("desc")) {
			input.setColumnNo(22);
		}
		if (input.getColumnNo() == 3 && input.getSort().equals("desc")) {
			input.setColumnNo(23);
		}
		if (input.getColumnNo() == 4 && input.getSort().equals("desc")) {
			input.setColumnNo(24);
		}
		if (input.getColumnNo() == 5 && input.getSort().equals("desc")) {
			input.setColumnNo(25);
		}
		if (input.getColumnNo() == 6 && input.getSort().equals("desc")) {
			input.setColumnNo(26);
		}
		if (input.getColumnNo() == 7 && input.getSort().equals("desc")) {
			input.setColumnNo(27);
		}
		if (input.getColumnNo() == 8 && input.getSort().equals("desc")) {
			input.setColumnNo(28);
		}
		if (input.getColumnNo() == 9 && input.getSort().equals("asc")) {
			input.setColumnNo(29);
		}
		if (input.getColumnNo() == 10 && input.getSort().equals("asc")) {
			input.setColumnNo(30);
		}
		return ltPoHeadersDao.getLtPoHeadersDataTableByVendorId(input, venId);
	}

	@Override
	public DashboardDetails getAmountByVendorId(Long vendorId) throws ServiceException {
		return ltPoHeadersDao.getAmountByVendorId(vendorId);
	}

	@Override
	public List<DashboardDetails> getCountAndStatusByVendorId(Long vendorId) throws ServiceException {
		return ltPoHeadersDao.getCountAndStatusByVendorId(vendorId);
	}

	@Override
	public List<LtPoHeaders> getTopFivePoById(Long vendorId) throws ServiceException {
		return ltPoHeadersDao.getTopFivePoById(vendorId);
	}

	@Override
	public Status viewFile(String name) throws ServiceException {
		String filepath = "/LexaApplication/Upload/";
		Status status = new Status();
		String str = "C:/LexaApplication/Upload/";
		str = str.concat("/" + name + ".pdf");
		File f = new File(str);

		if (f.exists()) {
			status.setCode(1);
			status.setData(filepath + name + ".pdf");
			status.setMessage("File existed.");
		} else {
			status.setCode(1);
			status.setMessage("File not found!");
		}
		return status;
	}

	@Override
	public List<DashboardDetails> getStatusCountByBuyerId(Long buyerId, Long companyId) throws ServiceException {
		return ltPoHeadersDao.getStatusCountByBuyerId(buyerId, companyId);
	}

	@Override
	public List<VendorBuyerDetails> getVendorMsgByBuyerId(Long buyerId) throws ServiceException {
		return ltPoHeadersDao.getVendorMsgByBuyerId(buyerId);
	}

	@Override
	public List<Object> getQtrStatusCountByBuyerId(Long buyerId, Long year) throws ServiceException {
		List<DashboardDetails> list = ltPoHeadersDao.getQtrStatusCountByBuyerId(buyerId, year);

		List<Object> listOfQtr = new ArrayList<>();

		List<DashboardDetails> listQtr1 = new ArrayList<DashboardDetails>();
		List<DashboardDetails> listQtr2 = new ArrayList<DashboardDetails>();
		List<DashboardDetails> listQtr3 = new ArrayList<DashboardDetails>();
		List<DashboardDetails> listQtr4 = new ArrayList<DashboardDetails>();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			DashboardDetails dashboardDetails = (DashboardDetails) iterator.next();

			if (dashboardDetails.getQtr() != null && dashboardDetails.getQtr() == 1) {
				listQtr1.add(dashboardDetails);
			}

			if (dashboardDetails.getQtr() != null && dashboardDetails.getQtr() == 2) {
				listQtr2.add(dashboardDetails);
			}

			if (dashboardDetails.getQtr() != null && dashboardDetails.getQtr() == 3) {
				listQtr3.add(dashboardDetails);
			}

			if (dashboardDetails.getQtr() != null && dashboardDetails.getQtr() == 4) {
				listQtr4.add(dashboardDetails);
			}
		}
		listOfQtr.add(listQtr1);
		listOfQtr.add(listQtr2);
		listOfQtr.add(listQtr3);
		listOfQtr.add(listQtr4);

		return listOfQtr;
	}

	@Override
	public Status acknowldge(LtPoHeaders ltPoHeaders) throws ServiceException {
		Status status = new Status();
		if (ltPoHeadersDao.acknowldge(ltPoHeaders)) {

			sendAcknowledgeMail(ltPoHeaders);

			status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_SUCCESSFULLY);
			if (status.getMessage() == null) {
				status.setCode(SUCCESS);
				status.setMessage("Error in finding message! The action is completed successfully.");
			}
		} else {
			status = ltMastCommonMessageService.getCodeAndMessage(UPDATE_FAIL);
			if (status.getMessage() == null) {
				status.setCode(EXCEPTION);
				status.setMessage("Error in finding message! The action was unsuccessful");
			}
		}
		return status;
	}

	private void sendAcknowledgeMail(LtPoHeaders ltPoHeaders) throws ServiceException {

		LtPoHeaders ltPoHeader = ltPoHeadersDao.getPoHeaderById(ltPoHeaders.getPoHeaderId());
		LtMastEmailtoken ltP2pEmailtoken = new LtMastEmailtoken();
		ltP2pEmailtoken.setEmailTitle(" Acknolegment of PO Number-" + ltPoHeader.getPoNumber()+" by "+ltPoHeader.getVendorName());
		ltP2pEmailtoken.setEmailTemplate("ackMail");

		List<LtMastEmployees> employee = ltMastEmployeesDao.getByEmpIdForEmail(ltPoHeader.getBuyerId());
		if (!employee.isEmpty()) {
			ltP2pEmailtoken.setSendTo(employee.get(0).getOfficialEmail());
		}

		ltP2pEmailtoken.setEmailObject("poNumber=" + ltPoHeader.getAckMsg());
		ltP2pEmailtoken.setExpiredWithin(1296000L);
		ltP2pEmailtoken.setSendDate(new Date());

		ltP2pEmailtoken.setEmailUserId(ltPoHeader.getLastUpdateLogin());

		ltP2pEmailtoken.setEmailStatus("SENDING");
		ltP2pEmailtoken.setFailureCount(0L);
		ltP2pEmailtoken = ltMastEmailtokenRepository.save(ltP2pEmailtoken);

	}

	@Override
	public List<LtPoHeaders> getActivePoHeadersByPoNumber(Long companyId, Long userId, String poNumber)
			throws ServiceException {
		return ltPoHeadersDao.getActivePoHeadersByPoNumber(companyId, userId, poNumber);
	}

	@Override
	public Status createPOPDFReport(Long poHeaderId,long companyId) {
		Status status = new Status();
		String saveDirectory = null;
		String companyLogPath = null;
		try {
			SysVariableWithValues sysVariableWithValues = ltMastSysVariablesService
					.getBySysVariableName("PO_SUMMARY_PDF",companyId);
			if (sysVariableWithValues != null) {
				if (sysVariableWithValues.getLtMastSysVariableValues().get(0) != null) {
					saveDirectory = sysVariableWithValues.getLtMastSysVariableValues().get(0).getUserValue();

				} else {
					saveDirectory = sysVariableWithValues.getLtMastSysVariables().getSystemValue();
				}
			}
			/*
			 * SysVariableWithValues reportCompanyLogoSysVariable =
			 * ltMastSysVariablesService
			 * .getBySysVariableName("REPORT_COMPANY_LOGO",companyId); if
			 * (reportCompanyLogoSysVariable != null) { if
			 * (reportCompanyLogoSysVariable.getLtMastSysVariableValues().get(0) != null) {
			 * companyLogPath =
			 * reportCompanyLogoSysVariable.getLtMastSysVariableValues().get(0).getUserValue
			 * ();
			 * 
			 * } else { companyLogPath =
			 * reportCompanyLogoSysVariable.getLtMastSysVariables().getSystemValue(); }
			 * }else { ClassLoader classLoader = this.getClass().getClassLoader();
			 * companyLogPath = classLoader.getResource("Logo.jpg").getFile();
			 * //companyLogPath="D:\\akshay\\svn-vpal-grn\\lvendormaster\\Logo.jpg"; }
			 */
			
			LtVendCompany ltVendCompany = ltVendCompanyDao.getLtVendCompanyBycompanyId(companyId);
			
			SysVariableWithValues sysvar=
					ltMastSysVariablesService.getBySysVariableName("IMAGE_UPLOAD_FOLDER_PATH",companyId);
		
			if(sysvar!=null)
			{
				if(sysvar.getLtMastSysVariableValues().get(0)!=null)
				{
					companyLogPath=sysvar.getLtMastSysVariableValues().get(0).getUserValue();
				}
				else
				{
					companyLogPath=sysvar.getLtMastSysVariables().getSystemValue();
				}
			}	
			
			if(ltVendCompany!=null) {
				if(ltVendCompany.getLogoPath()!=null) {
					File file = new File(ltVendCompany.getLogoPath());
					//if(file.createNewFile())
					//{
					//}
					//companyLogPath =ltVendCompany.getLogoPath();
					companyLogPath = companyLogPath+file.getName();
					
				}else {
					 ClassLoader classLoader = this.getClass().getClassLoader();
					 companyLogPath = classLoader.getResource("Logo.jpg").getFile();
				}
			}
			
			POReportService poReportService = new POReportService();
			LtPoReport poReport = null ;
			
			List<LtPoReport> ltPoReportList=ltPoHeadersDao.createPOPDFReport(poHeaderId,companyId);
			if(ltPoReportList!=null &&!ltPoReportList.isEmpty()) {
				poReport=ltPoReportList.get(0);
				
				poReport.setReportGeneratedPath(saveDirectory);
				poReport.setReportCompanyLogoPath(companyLogPath);
				
				
				LtPoReport poReportRes = poReportService.createPOPDFReport(poReport);
				String path= poReportRes.getPdfPath();
				path=path.replaceAll("^[a-zA-Z]:", "");
				
				
				 
			}
			
//			for(LtPoReport poReportTemp:ltPoReportList) {
//			}
			
			status.setCode(200);
			status.setMessage("Report creted successfully");
			
			String path = null;
			SysVariableWithValues sysVariableWithValues1 = ltMastSysVariablesService
					.getBySysVariableName("FILE_OPEN_PATH",companyId);
			if (sysVariableWithValues1 != null) {
				if (sysVariableWithValues1.getLtMastSysVariableValues().get(0) != null) {
					path = sysVariableWithValues1.getLtMastSysVariableValues().get(0).getUserValue();

				} else {
					path = sysVariableWithValues1.getLtMastSysVariables().getSystemValue();
				}
			}
			try {
				path = path+poReport.getFileName();
				status.setData(path);
			}catch(Exception e) {
				status.setCode(500);
				status.setMessage("Record not found.");
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			status.setCode(EXCEPTION);
			status.setMessage("Exception while creating PO Report");
		}
		return status;
	}
}
