package com.lonar.vendor.vendorportal.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lonar.vendor.vendorportal.dao.BroadcastDao;
import com.lonar.vendor.vendorportal.dao.LtInvoiceHeadersDao;
import com.lonar.vendor.vendorportal.dao.LtMastCommunicationTabDao;
import com.lonar.vendor.vendorportal.dao.LtMastEmailtokenDao;
import com.lonar.vendor.vendorportal.dao.LtMastEmployeesDao;
import com.lonar.vendor.vendorportal.dao.LtMastUsersDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.LtMastCommunicationTab;
import com.lonar.vendor.vendorportal.model.LtMastCommunicationTabDet;
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.LtMastUsers;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.SendBroadCastEmail;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;
import com.lonar.vendor.vendorportal.model.VendorApproval;
import com.lonar.vendor.vendorportal.repository.LtMastCommunicationTabDetRepository;
import com.lonar.vendor.vendorportal.repository.LtMastCommunicationTabRepository;
import com.lonar.vendor.vendorportal.repository.LtMastEmailtokenRepository;

@Service
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class LtMastEmailtokenServiceImpl implements LtMastEmailtokenService, CodeMaster {

	@Autowired
	LtMastEmailtokenDao ltMastEmailtokenDao;

	@Autowired
	LtMastUsersDao ltMastUsersDao;

	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;

	@Autowired
	LtMastVendorsDao ltMastVendorsDao;

	@Autowired
	BroadcastDao broadcastDao;

	@Autowired
	private Environment env;

	@Autowired
	LtMastEmailtokenRepository ltMastEmailtokenRepository;

	@Autowired
	LtInvoiceHeadersDao ltInvoiceHeadersDao;

	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;

	@Autowired
	LtMastCommunicationTabRepository ltMastCommunicationTabRepository;

	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;

	@Autowired
	LtMastCommunicationTabDetRepository ltMastCommunicationTabDetRepository;

	@Autowired
	LtMastCommunicationTabDao ltMastCommunicationTabDao;

	@Override
	public void makeEntryInEmailToken(List<VendorApproval> vendorApprovals, String emailTemplate,
			LtMastVendors ltMastVendors, String string) throws ServiceException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		//DecimalFormat twoDForm = new DecimalFormat("0.00");

		if(vendorApprovals!=null) {
		for (Iterator iterator = vendorApprovals.iterator(); iterator.hasNext();) {
			VendorApproval vendorApproval = (VendorApproval) iterator.next();
			if (vendorApproval.getApprovalId() != null) {
				if (emailTemplate.equals("vendorApprovalNotification")) {
					List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao
							.getByEmpIdForEmail(vendorApproval.getApprovalId().longValue());
					if (!ltMastEmployees.isEmpty() && ltMastEmployees.size() > 0) {
						for (Iterator iterator2 = ltMastEmployees.iterator(); iterator2.hasNext();) {
							ltMastVendors = ltMastVendorsDao.getVendorById(ltMastVendors.getVendorId());
							LtMastEmployees ltMastEmployees2 = (LtMastEmployees) iterator2.next();

							LtMastEmailtoken ltMastEmailtoken = new LtMastEmailtoken();
							ltMastEmailtoken.setSendTo(ltMastEmployees2.getOfficialEmail());
							ltMastEmailtoken.setEmailStatus("SENDING");
							ltMastEmailtoken
									.setEmailTitle("Pending for your approval " + ltMastVendors.getVendorName());
							ltMastEmailtoken.setEmailTemplate(emailTemplate);
							ltMastEmailtoken.setExpiredWithin(1296000L);
							ltMastEmailtoken.setSendDate(new Date());
							ltMastEmailtoken.setFailureCount(0L);
							String startDate = formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss")
									.parse(ltMastVendors.getStartDate().toString()));
							String endDate = null;
							if (ltMastVendors.getEndDate() != null) {
								endDate = formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss")
										.parse(ltMastVendors.getEndDate().toString()));
							} else {
								endDate = "-";
							}
							ltMastEmailtoken.setEmailObject("vendorName=" + ltMastVendors.getVendorName()
									+ "#$#$StartDate=" + startDate + "#$#$EndDate=" + endDate + "#$#$status="
									+ "pending" + "#$#$name=" + ltMastEmployees2.getEmpName() + "#$#$LoginURL="
									+ env.getProperty("LOGIN_URL"));

							Long emailtokenId = ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
						}
					}
				} else if (emailTemplate.equals("vendorApproval")) {
					StringBuffer sendCc = new StringBuffer();
					String companyName = null;
					List<VendorApproval> vendorApproversList = ltMastVendorsDao
							.getApprovalList(ltMastVendors.getVendorId(), null);
					if (vendorApproversList != null) {

						for (VendorApproval vendorApprovalEmp : vendorApproversList) {
							List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao
									.getByEmpIdForEmail(vendorApprovalEmp.getApprovalId().longValue());
							if (ltMastEmployees != null) {
								sendCc.append(ltMastEmployees.get(0).getOfficialEmail() + ",");
								companyName = ltMastEmployees.get(0).getCompanyName();
							}
						}
					}
					LtMastEmailtoken ltMastEmailtoken = new LtMastEmailtoken();
					ltMastEmailtoken.setSendTo(ltMastVendors.getRegistrationEmail());
					sendCc.append(ltMastVendors.getPrimaryEmail() + ",");
					ltMastEmailtoken.setEmailStatus("SENDING");
					ltMastEmailtoken.setEmailTitle(ltMastVendors.getVendorName() + " Approved");
					ltMastEmailtoken.setEmailTemplate(emailTemplate);
					ltMastEmailtoken.setExpiredWithin(1296000L);
					ltMastEmailtoken.setSendDate(new Date());
					ltMastEmailtoken.setFailureCount(0L);
					ltMastEmailtoken.setSendCc(sendCc + "");
					String startDate = formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss")
							.parse(ltMastVendors.getStartDate().toString()));
					String endDate = null;
					if (ltMastVendors.getEndDate() != null) {
						endDate = formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss")
								.parse(ltMastVendors.getEndDate().toString()));
					} else {
						endDate = "-";
					}
					ltMastEmailtoken.setEmailObject("vendorName=" + ltMastVendors.getVendorName() + "#$#$StartDate="
							+ startDate + "#$#$EndDate=" + endDate + "#$#$status=" + "pending" + "#$#$name="
							+ ltMastVendors.getVendorName() + "#$#$companyName=" + companyName + "#$#$LoginURL="
							+ env.getProperty("LOGIN_URL"));

					Long emailtokenId = ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
				}
			}

		}
		}else {

			if(emailTemplate.equals("vendorApproval")) {
				StringBuffer sendCc = new StringBuffer();
				String companyName = null;
				List<VendorApproval> vendorApproversList = ltMastVendorsDao
						.getApprovalList(ltMastVendors.getVendorId(), null);
				if (vendorApproversList != null) {

					for (VendorApproval vendorApprovalEmp : vendorApproversList) {
						List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao
								.getByEmpIdForEmail(vendorApprovalEmp.getApprovalId().longValue());
						if (ltMastEmployees != null) {
							sendCc.append(ltMastEmployees.get(0).getOfficialEmail() + ",");
							companyName = ltMastEmployees.get(0).getCompanyName();
						}
					}
				}
				LtMastEmailtoken ltMastEmailtoken = new LtMastEmailtoken();
				ltMastEmailtoken.setSendTo(ltMastVendors.getRegistrationEmail());
				sendCc.append(ltMastVendors.getPrimaryEmail() + ",");
				ltMastEmailtoken.setEmailStatus("SENDING");
				ltMastEmailtoken.setEmailTitle(ltMastVendors.getVendorName() + " Approved");
				ltMastEmailtoken.setEmailTemplate(emailTemplate);
				ltMastEmailtoken.setExpiredWithin(1296000L);
				ltMastEmailtoken.setSendDate(new Date());
				ltMastEmailtoken.setFailureCount(0L);
				ltMastEmailtoken.setSendCc(sendCc + "");
				String startDate = formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss")
						.parse(ltMastVendors.getStartDate().toString()));
				String endDate = null;
				if (ltMastVendors.getEndDate() != null) {
					endDate = formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss")
							.parse(ltMastVendors.getEndDate().toString()));
				} else {
					endDate = "-";
				}
				ltMastEmailtoken.setEmailObject("vendorName=" + ltMastVendors.getVendorName() + "#$#$StartDate="
						+ startDate + "#$#$EndDate=" + endDate + "#$#$status=" + "pending" + "#$#$name="
						+ ltMastVendors.getVendorName() + "#$#$companyName=" + companyName + "#$#$LoginURL="
						+ env.getProperty("LOGIN_URL"));

				Long emailtokenId = ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
			
			}
		}
	}

	@Override
	public List<LtMastEmailtoken> findAllActive() throws ServiceException {
		return ltMastEmailtokenDao.findAllActive();
	}

	@Override
	public void updateStatus(Long emailTokenId, String status, Integer count) throws ServiceException {
		ltMastEmailtokenDao.updateStatus(emailTokenId, status, count);

	}

	@Override
	public Status sendMail(SendBroadCastEmail emailList) throws ServiceException {
		Status status = new Status();
		LtMastEmailtoken ltMastEmailtoken = new LtMastEmailtoken();
		List<String> listEmail;

		if (emailList.getStatus().equals("all")) {
			listEmail = broadcastDao.getAllMailId();
		} else {
			listEmail = broadcastDao.getMailIdByStatus(emailList.getStatus());
		}
		for (String email : listEmail) {

			ltMastEmailtoken.setEmailStatus("SENDING");
			ltMastEmailtoken.setSendTo(email);
			// ltMastEmailtoken.setEmailTitle("Mail");

			ltMastEmailtoken.setEmailTemplate("mail");
			ltMastEmailtoken.setEmailTitle(emailList.getSubject());
			ltMastEmailtoken.setMessage(emailList.getMessage());
			ltMastEmailtoken.setEmailObject("message=" + ltMastEmailtoken.getMessage());
			ltMastEmailtoken.setFailureCount(0L);
			ltMastEmailtoken.setExpiredWithin(1296000L);
			ltMastEmailtoken.setSendDate(new Date());
			ltMastEmailtoken = ltMastEmailtokenRepository.save(ltMastEmailtoken);
			if (ltMastEmailtoken.getEmailTokenId() == null) {
				status.setMessage("Mail sending failed");
				return status;
			}

		}
		status.setMessage("Mail sent.");
		return status;

	}

	@Override
	public void makeInvoiceEntryInEmailToken(List<InvoiceApproval> invoiceApprovalsList, String emailTemplate,
			LtInvoiceHeaders ltInvoiceHeaders, String string) throws ServiceException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		DecimalFormat twoDForm = new DecimalFormat("0.00");
		for (Iterator iterator = invoiceApprovalsList.iterator(); iterator.hasNext();) {
			InvoiceApproval expenseApproval2 = (InvoiceApproval) iterator.next();
			if (expenseApproval2.getApprovalId() != null) {
				LtMastUsers ltMastUsers = null;
				LtMastEmailtoken ltMastEmailtoken = new LtMastEmailtoken();
				if (!emailTemplate.equals("invoiceApprovalNotification")) {
					ltMastUsers = ltMastUsersDao.getLtMastUsersByID(expenseApproval2.getApprovalId());

					List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao
							.getByEmpIdForEmail(ltInvoiceHeaders.getBuyerId());
					ltMastEmailtoken.setSendCc(ltMastEmployees.get(0).getOfficialEmail());

					ltMastEmailtoken.setSendTo(ltMastUsers.getEmail());
					ltMastEmailtoken.setEmailTitle(ltInvoiceHeaders.getInvoiceNum() + ","
							+ ltInvoiceHeaders.getInternalInvoiceNumber() + "  has been approved.");
					List<LtMastUsers> ltP2pUsers1 = ltMastUsersDao
							.findVendorByUserName(ltMastUsers.getUserName().toUpperCase());
					ltMastEmailtoken.setEmailObject("invoiceNumber=" + ltInvoiceHeaders.getInvoiceNum() + "#$#$amount="
							+ ltInvoiceHeaders.getInvoiceAmount() + "#$#$status=" + "pending" + "#$#$name="
							+ ltP2pUsers1.get(0).getEmployeeName() + "#$#$LoginURL=" + env.getProperty("LOGIN_URL"));

				} else {
					List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao
							.getByEmpIdForEmail(expenseApproval2.getApprovalId().longValue());
					if (!ltMastEmployees.isEmpty() && ltMastEmployees.size() > 0) {
						for (LtMastEmployees empObj : ltMastEmployees) {
							// ltMastUsers =
							// ltMastUsersDao.getLtMastUsersByID(expenseApproval2.getApprovalId());
							ltMastEmailtoken.setSendTo(empObj.getOfficialEmail());

							ltMastEmailtoken.setEmailTitle(ltInvoiceHeaders.getInvoiceNum() + ","
									+ ltInvoiceHeaders.getInternalInvoiceNumber() + "  Pending for your approval ");

							ltMastEmailtoken.setEmailObject("invoiceNumber=" + ltInvoiceHeaders.getInvoiceNum()
									+ "#$#$amount=" + ltInvoiceHeaders.getInvoiceAmount() + "#$#$status=" + "pending"
									+ "#$#$name=" + empObj.getEmpName() + "#$#$LoginURL="
									+ env.getProperty("LOGIN_URL"));
						}
					}
				}

				ltInvoiceHeaders = ltInvoiceHeadersDao.getInvoiceById(ltInvoiceHeaders.getInvoiceHeaderId());
				ltMastEmailtoken.setEmailStatus("SENDING");
				ltMastEmailtoken.setEmailTemplate(emailTemplate);
				ltMastEmailtoken.setExpiredWithin(1296000L);
				ltMastEmailtoken.setFailureCount(0L);
				ltMastEmailtoken.setSendDate(new Date());
				Long emailtokenId = ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);

			}
		}
	}

	@Override
	public Status sendBroadCastMessage(SendBroadCastEmail emailList) throws ServiceException {
		Status status = new Status();
		if (emailList.getSubject() == null || emailList.getMessage().equals(null)) {
			status.setCode(FAIL);
			status.setMessage("Please enter subject and message for the broadcast");
			return status;
		}
		List<LtMastVendors> vendorList = ltMastVendorsDao.getAllVendorInfoByCompany(emailList);
		try {
			 
			if (!vendorList.isEmpty()) {

				// creating and starting thread.
				BroadcastMessageThread ltMastEmailtokenThread = new BroadcastMessageThread(vendorList, emailList,
						ltMastCommunicationTabDao, ltMastCommunicationTabRepository, ltMastEmailtokenRepository,
						ltMastCommunicationTabDetRepository,env);
				ltMastEmailtokenThread.start();
				
				status.setCode(SUCCESS);
				status.setMessage("Broadcast message sent successfully");
			} else {
				status.setCode(FAIL);
				status.setMessage("No vendors found for the company");
			}

		} catch (Exception e) {
			e.printStackTrace();
			status.setCode(FAIL);
			status.setMessage("Something went wrong!!!!");
		}
		 
		return status;
	}

	@Override
	public Status sendBroadCastMsgAndEmail(String emailList, MultipartFile[] files) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		Status status = new Status();
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonInputObject = null;
		try {
			jsonInputObject =  (JSONObject) jsonparser.parse(emailList);
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SendBroadCastEmail  sendBroadCastEmail = new ObjectMapper().readValue(emailList,
				SendBroadCastEmail.class);
		 
		if(files.length>0) {
			
			String attachmentPath = saveFile(files,sendBroadCastEmail.getCompanyId());
			 
			sendBroadCastEmail.setAttachmentPath(attachmentPath);
		}
		if (sendBroadCastEmail.getSubject() == null || sendBroadCastEmail.getMessage().equals(null)) {
			status.setCode(FAIL);
			status.setMessage("Please enter subject and message for the broadcast");
			return status;
		}
		List<LtMastVendors> vendorList = ltMastVendorsDao.getAllVendorInfoByCompany(sendBroadCastEmail);
		try {
			if (!vendorList.isEmpty()) {

				// creating and starting thread.
				BroadcastMessageThread ltMastEmailtokenThread = new BroadcastMessageThread(vendorList, sendBroadCastEmail,
						ltMastCommunicationTabDao, ltMastCommunicationTabRepository, ltMastEmailtokenRepository,
						ltMastCommunicationTabDetRepository,env);
				ltMastEmailtokenThread.start();
				
				status.setCode(SUCCESS);
				status.setMessage("Broadcast message sent successfully");
			} else {
				status.setCode(FAIL);
				status.setMessage("No vendors found for the company");
			}

		} catch (Exception e) {
			e.printStackTrace();
			status.setCode(FAIL);
			status.setMessage("Something went wrong!!!!");
		}
		 
		return status;
		
	}

	private String saveFile(MultipartFile[] files, Long companyId) throws ServiceException {
		Status status=new Status();
		String fileName = null;
		String saveDirectory=null;
		SysVariableWithValues sysVariableWithValues=
				ltMastSysVariablesService.getBySysVariableName("FILE_UPLOAD_FOLDER_PATH",companyId);
		
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
		File dir = new File(saveDirectory);
		if (!dir.exists())
		{
			 
			dir.mkdirs();
			if(!dir.isDirectory())
			{
				 
				status=ltMastCommonMessageService.getCodeAndMessage(NO_DIRECTIVE_EXISTS);
				if(status.getMessage()==null)
				{
					status.setCode(EXCEPTION);
					status.setMessage("Error in finding message! The action was unsuccessful");
				}
			}
		}	
	
		 
		for(int i =0 ;i< files.length; i++)
		{
			try 
			{
				fileName = files[i].getOriginalFilename();
				byte[] bytes = files[i].getBytes();
				BufferedOutputStream buffStream = 
                    new BufferedOutputStream(new FileOutputStream(new File(saveDirectory + fileName)));
				buffStream.write(bytes);
				buffStream.close();
			 
			} 
			catch (Exception e)
			{
				 
				e.printStackTrace();
			}
		}
		return saveDirectory + fileName;
	}

}
