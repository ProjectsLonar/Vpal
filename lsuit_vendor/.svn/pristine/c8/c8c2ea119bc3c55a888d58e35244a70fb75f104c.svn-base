package com.lonar.vendor.vendorportal.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtInvoiceApprovalDao;
import com.lonar.vendor.vendorportal.dao.LtInvoiceApprovalHistoryDao;
import com.lonar.vendor.vendorportal.dao.LtInvoiceHeadersDao;
import com.lonar.vendor.vendorportal.dao.LtMastEmailtokenDao;
import com.lonar.vendor.vendorportal.dao.LtMastEmployeesDao;
import com.lonar.vendor.vendorportal.dao.LtMastModuleApprovalsDao;
import com.lonar.vendor.vendorportal.dao.LtMastUsersDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.LtMastUsers;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class LtInvoiceApprovalServiceImpl implements LtInvoiceApprovalService,CodeMaster {
	
	@Autowired
	private Environment env;
	
	@Autowired
	LtInvoiceApprovalDao ltInvoiceApprovalDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastModuleApprovalsDao ltMastModuleApprovalsDao;
	
	@Autowired
	LtInvoiceApprovalHistoryDao invoiceApprovalHistoryDao;

	@Autowired
	LtInvoiceHeadersDao ltInvoiceHeadersDao;
	
	@Autowired
	LtMastUsersDao ltMastUsersDao;
	
	@Autowired
	LtMastEmailtokenDao ltMastEmailtokenDao;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	@Autowired
	LtMastVendorsDao ltMastVendorsDao;
	
	@Override
	public Status updateInvoiceStatusApproval(LtInvoiceApprovalHistory approvalHistory) throws ServiceException {
		Status status=new Status();
		DecimalFormat twoDForm = new DecimalFormat("0.00");
		approvalHistory.setLastUpdateDate(new Date());
		if(approvalHistory.getStatus().equals(INVOICE_APPROVED))
		{
			if(ltInvoiceApprovalDao.updateStatusApproval(approvalHistory) )
			{
				if(ltMastModuleApprovalsDao.chkInvoiceIsAprovedByAnyOne(approvalHistory))
				{
					if(ltInvoiceApprovalDao.updateAllStatusApproval(approvalHistory))
					{
						status=ltMastCommonMessageService.getCodeAndMessage(INV_APPROVED);
						if(status.getMessage()==null)
						{
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action was successful");
						}
					}
					else
					{
						status=ltMastCommonMessageService.getCodeAndMessage(INVOICE_APPROVAL_FAIL);
						if(status.getMessage()==null)
						{
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action was successful");
						}
					}
						
				}
			}else 
			{
				status=ltMastCommonMessageService.getCodeAndMessage(INVOICE_APPROVAL_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action was successful");
				}
			}
				
			status=ltMastCommonMessageService.getCodeAndMessage(INV_APPROVED);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
			}
		}
		
		else if(approvalHistory.getStatus().equals(INVOICE_FEEDBACK_AWAITED) )
		{
			if(ltInvoiceApprovalDao.updateStatusApproval(approvalHistory))
			{
				if(ltInvoiceApprovalDao.submitForApproval(null,approvalHistory.getInvoiceHeaderId(),approvalHistory.getStatus(),null,approvalHistory.getLastUpdateLogin())) {
				
				LtInvoiceHeaders ltInvoiceHeaders= ltInvoiceHeadersDao.getInvoiceById(approvalHistory.getInvoiceHeaderId());
				if(ltInvoiceHeaders !=null)
				{		
					//LtMastUsers ltMastUsers = ltMastUsersDao.getLtMastUsersByID(ltInvoiceHeaders.getCreatedBy()); //--commented on 26-9-19-akshay
					LtMastVendors ltMastVendors = ltMastVendorsDao.getVendorById(ltInvoiceHeaders.getVendorId());
					List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao.getByEmpIdForEmail(approvalHistory.getEmployeeId());
					LtMastEmailtoken ltMastEmailtoken=new LtMastEmailtoken();
					
					ltMastEmailtoken.setEmailObject(
							"#$#$invoiceNumber="+ltInvoiceHeaders.getInvoiceNum()+
							"#$#$name="+ltMastVendors.getVendorName()+
							"#$#$approverName="+ltMastEmployees.get(0).getEmpName()+
							"#$#$LoginURL="+env.getProperty("LOGIN_URL"));	
					ltMastEmailtoken.setSendTo(ltMastVendors.getPrimaryEmail());
					ltMastEmailtoken.setEmailStatus("SENDING");
					ltMastEmailtoken.setEmailTitle("Invoice Number : "+ltInvoiceHeaders.getInvoiceNum() +
							", Internal Invoice no : "+ltInvoiceHeaders.getInternalInvoiceNumber() + "has been sent for feedback.");
					
					ltMastEmailtoken.setEmailTemplate("invoiceFeedback");
					
					ltMastEmailtoken.setExpiredWithin(1296000L);
					ltMastEmailtoken.setSendDate(new Date());

					ltMastEmailtoken.setEmailStatus("SENDING");
					
					ltMastEmailtoken.setExpiredWithin(1296000L);
					ltMastEmailtoken.setSendDate(new Date());
					if(ltInvoiceHeaders.getBuyerId()!=null) {
						List<LtMastEmployees> buyer = ltMastEmployeesDao.getByEmpIdForEmail(ltInvoiceHeaders.getBuyerId());
					ltMastEmailtoken.setSendCc(buyer.get(0).getOfficialEmail()+","+ltMastEmployees.get(0).getOfficialEmail());
					}
					//ltMastEmployees = ltMastEmployeesDao.getByEmpIdForEmail(ltMastVendors.getInitiatorId());
					//ltMastEmailtoken.setSendCc(ltMastEmployees.get(0).getOfficialEmail());
					ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
					
					status=ltMastCommonMessageService.getCodeAndMessage(INV_FEEDBACK_AWAITED);
					if(status.getMessage()==null) 
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action was successful");
					}
					
			}
				String currentLevel=null;
				if(approvalHistory.getInvoiceApprovalId()!=null	)
				{
					currentLevel=ltInvoiceApprovalDao.getCurrLevelByInvoiceApprovalId(approvalHistory.getInvoiceApprovalId());
				}
				ltInvoiceApprovalDao.upDateStatus(approvalHistory.getInvoiceHeaderId(), NO_ACTION, currentLevel);	
			}	
		  }
		}
		else if(approvalHistory.getStatus().equals(INVOICE_REJECTED))
		{
			if(ltInvoiceApprovalDao.updateStatusApproval(approvalHistory)) 
			{
				if(ltInvoiceApprovalDao.submitForApproval(null,approvalHistory.getInvoiceHeaderId(),approvalHistory.getStatus(),null,approvalHistory.getLastUpdateLogin()))
				{
					LtInvoiceHeaders ltInvoiceHeaders= ltInvoiceHeadersDao.getInvoiceById(approvalHistory.getInvoiceHeaderId());
					//LtMastUsers ltMastUsers = ltMastUsersDao.getLtMastUsersByID(ltInvoiceHeaders.getCreatedBy()); //commented on 26-9-19-akshay
					LtMastVendors ltMastVendors = ltMastVendorsDao.getVendorById(ltInvoiceHeaders.getVendorId());
					if(ltMastVendors !=null)
					{
						List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao.getByEmpIdForEmail(approvalHistory.getEmployeeId());
							LtMastEmailtoken ltMastEmailtoken=new LtMastEmailtoken();
					
							/*if(ltMastUsers.getEmployeeName()==null) {
								ltMastUsers.setEmployeeName(ltMastUsers.getVendorName());
							}*/
							ltMastEmailtoken.setEmailObject(
									"#$#$invoiceNumber="+ltInvoiceHeaders.getInvoiceNum()+
									"#$#$name="+ltMastVendors.getVendorName()+
									"#$#$approverName="+ltMastEmployees.get(0).getEmpName()+
									"#$#$LoginURL="+env.getProperty("LOGIN_URL"));	
							ltMastEmailtoken.setSendTo(ltMastVendors.getPrimaryEmail());
							ltMastEmailtoken.setEmailStatus("SENDING");
							//ltMastEmailtoken.setEmailTitle("Vendor reject mail");
							ltMastEmailtoken.setEmailTitle("Invoice Number : "+ltInvoiceHeaders.getInvoiceNum() +
									", Internal Invoice no : "+ltInvoiceHeaders.getInternalInvoiceNumber() + "has been rejected");
							ltMastEmailtoken.setEmailTemplate("invoiceReject");
							
							ltMastEmailtoken.setExpiredWithin(1296000L);
							ltMastEmailtoken.setSendDate(new Date());
							if(ltInvoiceHeaders.getBuyerId()!=null) {
								List<LtMastEmployees> buyer = ltMastEmployeesDao.getByEmpIdForEmail(ltInvoiceHeaders.getBuyerId());
							ltMastEmailtoken.setSendCc(buyer.get(0).getOfficialEmail()+","+ltMastEmployees.get(0).getOfficialEmail());
							}
							ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
		
							status=ltMastCommonMessageService.getCodeAndMessage(INV_REJECTED);
							if(status.getMessage()==null)
							{
								status.setCode(SUCCESS);
								status.setMessage("Error in finding message! The action was successful");
							}
					}
					ltInvoiceApprovalDao.upDateStatus(approvalHistory.getInvoiceHeaderId(), NO_ACTION, null);	
			
				}
			}
		}
		
		invoiceApprovalHistoryDao.save(approvalHistory);
		return status;
	
	}

	@Override
	public InvoiceApproval getInvoiceApproval(Long invoiceId, Long apprId) throws ServiceException {
		return ltInvoiceApprovalDao.getInvoiceApproval(invoiceId,apprId);
	}
	

}
