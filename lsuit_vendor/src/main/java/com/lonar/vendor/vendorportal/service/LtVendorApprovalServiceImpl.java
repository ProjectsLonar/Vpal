package com.lonar.vendor.vendorportal.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.dao.LtMastEmailtokenDao;
import com.lonar.vendor.vendorportal.dao.LtMastEmployeesDao;
import com.lonar.vendor.vendorportal.dao.LtMastModuleApprovalsDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.dao.LtVendorApprovalDao;
import com.lonar.vendor.vendorportal.dao.LtVendorApprovalHistoryDao;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.LtMastEmployees;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.LtVendorApproval;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;

@Service
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class LtVendorApprovalServiceImpl implements LtVendorApprovalService,CodeMaster{

	@Autowired
	private Environment env;
	
	@Autowired
	LtVendorApprovalHistoryDao ltVendorApprovalHistoryDao;
	
	@Autowired
	LtVendorApprovalDao ltVendorApprovalDao;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	@Autowired
	LtMastVendorsDao ltMastVendorsDao;
	
	@Autowired
	LtMastEmailtokenDao ltMastEmailtokenDao;
	
	@Autowired
	LtMastCommonMessageService ltMastCommonMessageService;
	
	@Autowired
	LtMastModuleApprovalsDao ltMastModuleApprovalsDao;
	
	@Override
	public Status updateStatusApproval(LtVendorApprovalHistory approvalHistory) throws ServiceException {
		Status status=new Status();
		DecimalFormat twoDForm = new DecimalFormat("0.00");
		approvalHistory.setLastUpdateDate(new Date());
		if(approvalHistory.getStatus().equals(APPROVED))
		{
			//LtMastVendors ltMastVendors=getdetails(approvalHistory.getVendorId());
			if(ltVendorApprovalDao.updateStatusApproval(approvalHistory) )
			{
				if(ltMastModuleApprovalsDao.chkIsAprovedByAnyOne(approvalHistory))
				{
					if(ltVendorApprovalDao.updateAllStatusApproval(approvalHistory))
					{
						status=ltMastCommonMessageService.getCodeAndMessage(VENDOR_APPROVED);
						if(status.getMessage()==null)
						{
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action was successful");
						}
					}
					else
					{
						status=ltMastCommonMessageService.getCodeAndMessage(VENDOR_APPROVAL_FAIL);
						if(status.getMessage()==null)
						{
							status.setCode(SUCCESS);
							status.setMessage("Error in finding message! The action was successful");
						}
					}
						
				}
			}else 
			{
				status=ltMastCommonMessageService.getCodeAndMessage(VENDOR_APPROVAL_FAIL);
				if(status.getMessage()==null)
				{
					status.setCode(SUCCESS);
					status.setMessage("Error in finding message! The action was successful");
				}
			}
				
			status=ltMastCommonMessageService.getCodeAndMessage(VENDOR_APPROVED);
			if(status.getMessage()==null)
			{
				status.setCode(SUCCESS);
			}
		}
		else if(approvalHistory.getStatus().equals(FEEDBACK_AWAITED) )
		{
			if(ltVendorApprovalDao.updateStatusApproval(approvalHistory))
			{
				ltVendorApprovalDao.submitForApproval(null,approvalHistory.getVendorId(),approvalHistory.getStatus(),null);
				
				LtMastVendors ltMastVendors= ltMastVendorsDao.getVendorById(approvalHistory.getVendorId());
				if(ltMastVendors !=null)
				{		
					List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao.getByEmpIdForEmail(approvalHistory.getEmployeeId());
					LtMastEmailtoken ltMastEmailtoken=new LtMastEmailtoken();
					
					ltMastEmailtoken.setEmailObject(
							"#$#$vendorName="+ltMastVendors.getVendorName()+" ( "+ltMastVendors.getVendorCode()+" )"+
							"#$#$approverName="+ltMastEmployees.get(0).getEmpName()+
							"#$#$name="+ltMastVendors.getVendorName()+
							"#$#$LoginURL="+env.getProperty("LOGIN_URL"));	
					ltMastEmailtoken.setSendTo(ltMastVendors.getRegistrationEmail());
					ltMastEmailtoken.setEmailStatus("SENDING");
					ltMastEmailtoken.setEmailTitle("Request to register for "+ltMastVendors.getVendorName()+" ( "+ltMastVendors.getVendorCode()+" )"+
					" has been sent for your feedback");
					
					ltMastEmailtoken.setEmailTemplate("vendorFeedback");
					
					ltMastEmailtoken.setExpiredWithin(1296000L);
					ltMastEmailtoken.setSendDate(new Date());
					
					ltMastEmailtoken.setEmailStatus("SENDING");
				
					ltMastEmailtoken.setEmailTemplate("vendorFeedback");
					ltMastEmailtoken.setExpiredWithin(1296000L);
					ltMastEmailtoken.setSendDate(new Date());
					ltMastEmployees = ltMastEmployeesDao.getByEmpIdForEmail(ltMastVendors.getInitiatorId());
					ltMastEmailtoken.setSendCc(ltMastEmployees.get(0).getOfficialEmail());
					ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
					
					status=ltMastCommonMessageService.getCodeAndMessage(VENDOR_SENT_FOR_FEEDBACK);
					if(status.getMessage()==null) 
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action was successful");
					}
					
			}
				String currentLevel=null;
				if(approvalHistory.getVendorApprovalId()!=null	)
				{
					currentLevel=ltVendorApprovalDao.getCurrLevelByVendorApprovalId(approvalHistory.getVendorApprovalId());
				}
				ltMastVendorsDao.upDateStatus(approvalHistory.getVendorId(), NO_ACTION, currentLevel);	
		  }
		}
		else if(approvalHistory.getStatus().equals(REJECTED))
		{
			if(ltVendorApprovalDao.updateStatusApproval(approvalHistory)) 
			{
				if(ltVendorApprovalDao.submitForApproval(null,approvalHistory.getVendorId(),approvalHistory.getStatus(),null))
				{
					LtMastVendors ltMastVendors= ltMastVendorsDao.getVendorById(approvalHistory.getVendorId());
					if(ltMastVendors !=null)
					{
						List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao.getByEmpIdForEmail(approvalHistory.getEmployeeId());
							LtMastEmailtoken ltMastEmailtoken=new LtMastEmailtoken();
					
							ltMastEmailtoken.setEmailObject(
									"#$#$vendorName="+ltMastVendors.getVendorName()+" ( "+ltMastVendors.getVendorCode()+" )"+
									"#$#$approverName="+ltMastEmployees.get(0).getEmpName()+
									"#$#$name="+ltMastVendors.getVendorName()+
									"#$#$LoginURL="+env.getProperty("LOGIN_URL"));	
							ltMastEmailtoken.setSendTo(ltMastVendors.getRegistrationEmail());
							ltMastEmailtoken.setEmailStatus("SENDING");
							//ltMastEmailtoken.setEmailTitle("Vendor reject mail");
							ltMastEmailtoken.setEmailTitle("Request to register for "+ltMastVendors.getVendorName()+" ( "+ltMastVendors.getVendorCode()+" )"+
									" has been rejected");
							ltMastEmailtoken.setEmailTemplate("vendorReject");
							
							ltMastEmailtoken.setExpiredWithin(1296000L);
							ltMastEmailtoken.setSendDate(new Date());
							ltMastEmployees = ltMastEmployeesDao.getByEmpIdForEmail(ltMastVendors.getInitiatorId());
							ltMastEmailtoken.setSendCc(ltMastEmployees.get(0).getOfficialEmail());
							ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
		
							status=ltMastCommonMessageService.getCodeAndMessage(VENDOR_REJECTED);
							if(status.getMessage()==null)
							{
								status.setCode(SUCCESS);
								status.setMessage("Error in finding message! The action was successful");
							}
					}
					ltMastVendorsDao.upDateStatus(approvalHistory.getVendorId(), NO_ACTION, null);
			
				}
			}
		}
		else if(approvalHistory.getStatus().equals(WITHDRAW))
		{
			if(ltVendorApprovalDao.updateVendorStatusApproval(approvalHistory)) 
			{
				approvalHistory.setStatus(WITHDRAW);
			
				if(ltVendorApprovalDao.submitForApproval(null,approvalHistory.getVendorId(),approvalHistory.getStatus(),null))
				{
					LtMastVendors ltMastVendors= ltMastVendorsDao.getVendorById(approvalHistory.getVendorId());
					if(ltMastVendors !=null)
					{
							String empName = null;
							LtMastEmailtoken ltMastEmailtoken=new LtMastEmailtoken();
							if(approvalHistory.getEmployeeId()!=null) {
							List<LtMastEmployees> ltMastEmployees = ltMastEmployeesDao.getByEmpIdForEmail(approvalHistory.getEmployeeId());
							empName  = ltMastEmployees.get(0).getEmpName(); 
							}else {
								empName = ltMastVendors.getVendorName()+" ( "+ltMastVendors.getVendorCode()+" )";
								approvalHistory.setUserType("VENDOR");
							}
							ltMastEmailtoken.setEmailObject(
									"#$#$vendorName="+ltMastVendors.getVendorName()+" ( "+ltMastVendors.getVendorCode()+" )"+
									"#$#$approverName="+empName+
									"#$#$name="+ltMastVendors.getVendorName()+
									"#$#$LoginURL="+env.getProperty("LOGIN_URL"));	
							ltMastEmailtoken.setSendTo(ltMastVendors.getRegistrationEmail());
							ltMastEmailtoken.setEmailStatus("SENDING");
							//ltMastEmailtoken.setEmailTitle("Vendor reject mail");
							ltMastEmailtoken.setEmailTitle("Request to register for "+ltMastVendors.getVendorName()+" ( "+ltMastVendors.getVendorCode()+" )"+
									" has been withdraw.");
							//ltMastEmailtoken.setEmailTitle("EXPENSE SELF REJECTION MAIL");
							ltMastEmailtoken.setEmailTemplate("vendorWithdraw");
	
							ltMastEmailtoken.setExpiredWithin(1296000L);
							ltMastEmailtoken.setSendDate(new Date());
						
						
							ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
							//----------------------------- maill to pending approval-----------
							List<LtVendorApproval> ltExpenseApprovalList = 
									ltVendorApprovalDao.chkCurrentApprover(approvalHistory.getVendorId());
							if(!ltExpenseApprovalList.isEmpty()){
								for(LtVendorApproval ltExpenseApproval : ltExpenseApprovalList){
									LtMastEmployees ltMastEmployees1 = ltMastEmployeesDao.getLtMastEmployeesByID(ltExpenseApproval.getApprovalId());
									ltMastEmailtoken.setEmailTokenId(null);
									ltMastEmailtoken.setSendTo(ltMastEmployees1.getOfficialEmail());
									ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
								}
							}
					status=ltMastCommonMessageService.getCodeAndMessage(VENDOR_WITHDRAW);
					if(status.getMessage()==null)
					{
						status.setCode(SUCCESS);
						status.setMessage("Error in finding message! The action was successful");
					}
					ltMastVendorsDao.upDateStatus(approvalHistory.getVendorId(), NO_ACTION, null);
				}
			}
		} 
		}
		ltVendorApprovalHistoryDao.save(approvalHistory);
		return status;
	
	}

	@Override
	public LtVendorApproval getVendorApproval(Long vendorId, Long appId) throws ServiceException {
		LtVendorApproval ltVendorApproval= ltVendorApprovalDao.getVendorApproval(vendorId, appId);
		return ltVendorApproval;
	}

	@Override
	public List<LtVendorApproval> getVendorApprovalByVendorId(Long vendorId) throws ServiceException {
		// TODO Auto-generated method stub
		return ltVendorApprovalDao.getVendorApprovalByVendorId(vendorId);
	}

	@Override
	public List<LtVendorApproval> getInvoiceApprovalByInvoiceId(Long invoiceId) throws ServiceException {
		// TODO Auto-generated method stub
		return ltVendorApprovalDao.getInvoiceApprovalByInvoiceId(invoiceId);
	}

	/*//@Transactional
	public LtMastVendors getdetails(Long expenseHeaderId) throws Exception
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		
		LtMastVendors ltMastVendors=ltExpExpenseHeadersDao.findOne(expenseHeaderId);
		
		ltMastVendors.setStDate(formatter.format(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss").parse(ltMastVendors.getStartDate().toString())));
		String endDate = null;
		if(ltMastVendors.getEndDate()!=null)
		{
			endDate =formatter.format(
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss").parse(ltMastVendors.getEndDate().toString()));
		}
		else
		{
			endDate="-";
		}
		ltMastVendors.setEnDate(endDate);	
		
		
		List<LtMastEmployees> employeesList=ltMastEmployeesDao.
				getEmployeeDetailsByUserID(ltExpExpenseHeaders.getEmployeeId());
		
		if(!employeesList.isEmpty())
		{
			ltMastVendors.setEmail(employeesList.get(0).getOfficialEmail());
			//ltExpExpenseHeaders.setDivisionName(employeesList.get(0).getDivisionName());
			//ltExpExpenseHeaders.setLocationName(employeesList.get(0).getLocationName());
			//ltExpExpenseHeaders.setCostCenterName(employeesList.get(0).getCostCenterName());
			//ltExpExpenseHeaders.setEmployeeName(employeesList.get(0).getTitle()+" "+employeesList.get(0).getFirstName()+" "+employeesList.get(0).getLastName());
		}
	
		
		return ltMastVendors;
	}*/
}
