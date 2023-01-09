package com.lonar.vendor.vendorportal.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.sql.DataSource;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lonar.vendor.vendorportal.dao.LtInvoiceHeadersDao;
import com.lonar.vendor.vendorportal.dao.LtMastUsersDao;
import com.lonar.vendor.vendorportal.dao.LtMastVendorsDao;
import com.lonar.vendor.vendorportal.dao.LtVendorApprovalDao;
import com.lonar.vendor.vendorportal.model.BusinessException;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.LtMastVendors;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.Mail;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.VendorApproval;
import com.lonar.vendor.vendorportal.repository.LtMastEmailtokenRepository;
import com.lonar.vendor.vendorportal.service.LtMastEmailtokenService;
import com.lonar.vendor.vendorportal.service.LtVendorApprovalHistoryService;
import com.lonar.vendor.vendorportal.service.LtVendorApprovalService;

@Component
@EnableScheduling
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class ScheduledTasks implements CodeMaster{

	@Autowired
	LtMastEmailtokenService ltMastEmailtokenService;
	
	@Autowired
	LtMastEmailtokenRepository ltMastEmailtokenRepository;
	
	@Autowired
	LtMastVendorsDao ltMastVendorsDao ;
	
	@Autowired
	LtVendorApprovalDao ltExpenseApprovalDao;
	
	@Autowired
	LtVendorApprovalHistoryService ltVendorApprovalHistoryService;
	
	@Autowired
	LtInvoiceHeadersDao ltInvoiceHeadersDao;

	@Autowired
	LtMastUsersDao ltMastUsersDao;
	
	@Autowired
	Mailer mailer;
	
	@Autowired
	LtVendorApprovalService ltVendorApprovalService;
	
	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() throws ServiceException {
    	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    	
		vendorChronJob();
		
		invoiceChronJob();
		 
		sendMail();
    }

    private void invoiceChronJob() {
    	
    	try {
    		//get list of inprocess vendor
    		List<LtInvoiceHeaders> inprocessListOfInvoice = ltInvoiceHeadersDao.getInprocessInvoiceList(INVOICE_INPROGRESS);	
    		
			String currentApprovalLavel = null ;
			List<InvoiceApproval> invoiceApprovalsList = null;
			
    		for (Iterator iterator = inprocessListOfInvoice.iterator(); iterator.hasNext();) {
				LtInvoiceHeaders ltInvoiceHeaders = (LtInvoiceHeaders) iterator.next();
				
				InvoiceApproval approvalLavel =  ltInvoiceHeadersDao.getApprovalLevel(ltInvoiceHeaders.getInvoiceHeaderId());
				
				if(approvalLavel != null){
					if( approvalLavel.getCurrentApprovalLevel() != null &&  !approvalLavel.getCurrentApprovalLevel().trim().equals("")){ 
						 currentApprovalLavel = approvalLavel.getCurrentApprovalLevel();
						 invoiceApprovalsList = ltInvoiceHeadersDao.getApprovalList(ltInvoiceHeaders.getInvoiceHeaderId(), approvalLavel.getCurrentApprovalLevel());
					}
					else { 
						currentApprovalLavel = approvalLavel.getApprovalLevel();
						invoiceApprovalsList = ltInvoiceHeadersDao.getApprovalList(ltInvoiceHeaders.getInvoiceHeaderId(), approvalLavel.getApprovalLevel());
					}
				}
				
				boolean isApproved = false;
				boolean isNoAction = false;
				
				for (InvoiceApproval invoiceApproval : invoiceApprovalsList) {
					
					if(invoiceApproval.getStatus().equals(NO_ACTION)) {	
						isNoAction = true;
						break;
					}else if(invoiceApproval.getStatus().equals(INVOICE_APPROVED) && 
							( invoiceApproval.getApprovedByAnyone() != null && invoiceApproval.getApprovedByAnyone().equals("N"))){
						isApproved = true;						
					} else if( !invoiceApproval.getStatus().equals(INVOICE_APPROVED) && 
							( invoiceApproval.getApprovedByAnyone() != null && invoiceApproval.getApprovedByAnyone().equals("N") )){
						isApproved = false;
						break;
					}
					else if (invoiceApproval.getStatus().equals(INVOICE_APPROVED) &&
							( invoiceApproval.getApprovedByAnyone() == null || invoiceApproval.getApprovedByAnyone().equals("Y"))){
						isApproved = true;						
						break;
					}
				} 
				
				
				
				if(isNoAction || isApproved ){
					
					if(isApproved) {
						currentApprovalLavel = ltInvoiceHeadersDao.getNextApprovalLevel(ltInvoiceHeaders.getInvoiceHeaderId() , currentApprovalLavel);
						
						if(currentApprovalLavel != null && !currentApprovalLavel.trim().equals("") ){		
							//ltExpExpenseHeadersService.updateCurrentApprovalLevel(ltExpExpenseHeader.getExpHeaderId(), currentApprovalLavel);
							invoiceApprovalsList = ltInvoiceHeadersDao.getApprovalList(ltInvoiceHeaders.getInvoiceHeaderId(), currentApprovalLavel);
						}else {
					
							if(ltInvoiceHeadersDao.submitForApproval(new Date(),
									ltInvoiceHeaders.getInvoiceHeaderId(), INVOICE_APPROVED, new Date())) {
						
								List<InvoiceApproval> approvalsList = new ArrayList<InvoiceApproval>();
								InvoiceApproval invoice = new InvoiceApproval();
								invoice.setApprovalId(ltInvoiceHeaders.getCreatedBy());
								invoice.setLastUpdateDate(new Date());
							//invoiceApprovalsList.get(0).setApprovalId(ltInvoiceHeaders.getInitiatorId());
							//invoiceApprovalsList.get(0).setApprovalId(ltInvoiceHeaders.getCreatedBy());
							//invoiceApprovalsList.get(0).setLastUpdateDate(new Date());
								approvalsList.add(invoice);
							
							/////Remaining 
							saveInvoiceEmailTokan(approvalsList,"invoiceApproval",ltInvoiceHeaders); 
							}
							
							//ltExpenseApprovalDao.callProceduere(ltExpExpenseHeader);
						}
					}  
					
					if(currentApprovalLavel != null && !currentApprovalLavel.trim().equals("") )
					{	
						ltInvoiceHeadersDao.upDateStatus(ltInvoiceHeaders.getInvoiceHeaderId(), PENDING, currentApprovalLavel);
						ltInvoiceHeadersDao.updateCurrentApprovalLevel(ltInvoiceHeaders.getInvoiceHeaderId(), currentApprovalLavel);
								
						//--------------------------chk for delegation here
						InvoiceApproval obj = new InvoiceApproval();
						for(InvoiceApproval invoiceApproval : invoiceApprovalsList)
						{
							if(invoiceApproval.getDelegationId()!=null)
							{
								obj.setApprovalId(invoiceApproval.getDelegationId());
								obj.setApprovalLevel(invoiceApproval.getApprovalLevel());
								obj.setApprovedByAnyone(invoiceApproval.getApprovedByAnyone());
								obj.setCurrentApprovalLevel(invoiceApproval.getCurrentApprovalLevel());
								obj.setInvoiceHeaderId(invoiceApproval.getInvoiceHeaderId());
								obj.setModuleApprovalId(invoiceApproval.getModuleApprovalId());
								obj.setStatus(invoiceApproval.getStatus());
							}
							
						}
						if(obj!=null && obj.getInvoiceHeaderId()!=null)
						{ invoiceApprovalsList.add(obj); }
		
						//---------------------SAVE HISTORY-----------------------------
						saveInvoiceApprovalHistoryData(invoiceApprovalsList, PENDING);
						saveInvoiceEmailTokan(invoiceApprovalsList,"invoiceApprovalNotification",ltInvoiceHeaders); 
					}
					
				} 
				
				
			}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	private void saveInvoiceEmailTokan(List<InvoiceApproval> invoiceApprovalsList, String emailTemplate,
			LtInvoiceHeaders ltInvoiceHeaders) 
	{
		try
		{
			ltMastEmailtokenService.makeInvoiceEntryInEmailToken(invoiceApprovalsList,emailTemplate,ltInvoiceHeaders,"MAIL");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private void vendorChronJob() 
	{
		 //JobExecutionContext ctx throws JobExecutionException
		//SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	
		try {
			List<LtMastVendors> vendorInprocessList = ltMastVendorsDao.getInprocessVendorList(INPROGRESS);	
		
			String currentApprovalLavel = null ;
			List<VendorApproval> expenseApprovals = null;
			for ( LtMastVendors ltMastVendors :  vendorInprocessList ) 
			{ 
				//-------------load approval levels against header id
			
				VendorApproval approvalLavel =  ltMastVendorsDao.getApprovalLevel(ltMastVendors.getVendorId());
				
				if(approvalLavel != null){
				if( approvalLavel.getCurrentApprovalLevel() != null &&  !approvalLavel.getCurrentApprovalLevel().trim().equals("")){ 
					 currentApprovalLavel = approvalLavel.getCurrentApprovalLevel();
					 expenseApprovals = ltMastVendorsDao.getApprovalList(ltMastVendors.getVendorId(), approvalLavel.getCurrentApprovalLevel());
				}
				else { 
					currentApprovalLavel = approvalLavel.getApprovalLevel();
					expenseApprovals = ltMastVendorsDao.getApprovalList(ltMastVendors.getVendorId(), approvalLavel.getApprovalLevel());
				}
				}
				boolean isApproved = false;
				boolean isNoAction = false;
			
				for (VendorApproval vendorApproval : expenseApprovals) {
					
					if(vendorApproval.getStatus().equals(NO_ACTION)) {	
						isNoAction = true;
						break;
					}else if(vendorApproval.getStatus().equals(APPROVED) && 
							( vendorApproval.getApprovedByAnyone() != null && vendorApproval.getApprovedByAnyone().equals("N"))){
						isApproved = true;						
					} else if( !vendorApproval.getStatus().equals(APPROVED) && 
							( vendorApproval.getApprovedByAnyone() != null && vendorApproval.getApprovedByAnyone().equals("N") )){
						isApproved = false;
						break;
					}
					else if (vendorApproval.getStatus().equals(APPROVED) &&
							( vendorApproval.getApprovedByAnyone() == null || vendorApproval.getApprovedByAnyone().equals("Y"))){
						isApproved = true;						
						break;
					}
				} 
			if(isNoAction || isApproved ){
			
					if(isApproved) {
					//	ltMastVendorsDao.upDateStatus(ltMastVendors.getVendorId(), APPROVED, currentApprovalLavel);//-27-8-19-akshay --21-9-19-akshay-comment
						currentApprovalLavel = ltMastVendorsDao.getNextApprovalLevel(ltMastVendors.getVendorId() , currentApprovalLavel);
						
						if(currentApprovalLavel != null && !currentApprovalLavel.trim().equals("") ){		
							//ltExpExpenseHeadersService.updateCurrentApprovalLevel(ltExpExpenseHeader.getExpHeaderId(), currentApprovalLavel);
							expenseApprovals = ltMastVendorsDao.getApprovalList(ltMastVendors.getVendorId(), currentApprovalLavel);
						}else {
					
							ltMastVendorsDao.submitForApproval(new Date(),
									ltMastVendors.getVendorId(), "VENDOR_ACTIVE", new Date());
						
							expenseApprovals.get(0).setApprovalId(ltMastVendors.getInitiatorId());
							expenseApprovals.get(0).setLastUpdateDate(new Date());
							saveEmailTokan(null,"vendorApproval",ltMastVendors); //--set to null by akshay on 26-9-19
							
							
							//ltExpenseApprovalDao.callProceduere(ltExpExpenseHeader);
						}
					}  
					
					if(currentApprovalLavel != null && !currentApprovalLavel.trim().equals("") )
					{	
						ltMastVendorsDao.upDateStatus(ltMastVendors.getVendorId(), PENDING, currentApprovalLavel);
						ltMastVendorsDao.updateCurrentApprovalLevel(ltMastVendors.getVendorId(), currentApprovalLavel);
								
						//--------------------------chk for delegation here
						VendorApproval obj = new VendorApproval();
						for(VendorApproval expApproval : expenseApprovals)
						{
							if(expApproval.getDelegationId()!=null)
							{
								obj.setApprovalId(expApproval.getDelegationId());
								obj.setApprovalLevel(expApproval.getApprovalLevel());
								obj.setApprovedByAnyone(expApproval.getApprovedByAnyone());
								obj.setCurrentApprovalLevel(expApproval.getCurrentApprovalLevel());
								obj.setVendorId(expApproval.getVendorId());
								obj.setModuleApprovalId(expApproval.getModuleApprovalId());
								obj.setStatus(expApproval.getStatus());
							}
							
						}
						if(obj!=null && obj.getVendorId()!=null)
						{ expenseApprovals.add(obj); }
		
						//---------------------------------------------------
						saveApprovalHistoryData(expenseApprovals, PENDING);
						
						saveEmailTokan(expenseApprovals,"vendorApprovalNotification",ltMastVendors); 
						
					}
					
					//---------------------- for the self approval ---------------------------
					/*for(VendorApproval expApproval:expenseApprovals)
					{
						
						if(ltMastVendors.getInitiatorId().equals(expApproval.getApprovalId())
								&& currentApprovalLavel != null)
						{
							LtVendorApprovalHistory approvalHistory= new LtVendorApprovalHistory();
							
							approvalHistory.setLastUpdateDate(new Date());
							approvalHistory.setVendorId(ltMastVendors.getVendorId());
							approvalHistory.setEmployeeId(ltMastVendors.getInitiatorId());
							approvalHistory.setStatus(APPROVED);
							ltVendorApprovalService.updateStatusApproval(approvalHistory);	
						}
					}*/
					//---------------------end for the self approval--------------------------
				} 
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void saveInvoiceApprovalHistoryData(List<InvoiceApproval> invoiceApprovalList ,String status) throws Exception
	{
		for(InvoiceApproval invoiceApproval:invoiceApprovalList)
		{
			LtInvoiceApprovalHistory ltInvoiceApprovalHistory = new LtInvoiceApprovalHistory();
			
			ltInvoiceApprovalHistory.setStatus(status);
			ltInvoiceApprovalHistory.setInvoiceHeaderId(invoiceApproval.getInvoiceHeaderId());
			ltInvoiceApprovalHistory.setInvoiceApprovalId(invoiceApproval.getInvoiceApprovalId());
			ltInvoiceApprovalHistory.setEmployeeId(invoiceApproval.getApprovalId());
			ltInvoiceApprovalHistory.setLastUpdateDate(invoiceApproval.getLastUpdateDate());
			
		try
		{
			ltVendorApprovalHistoryService.saveInvoiceApprovalHistory(ltInvoiceApprovalHistory);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}
	
	private void saveApprovalHistoryData(List<VendorApproval> expenseApprovalsList,String status) throws Exception
	{
		for(VendorApproval expenseApproval:expenseApprovalsList)
		{
			LtVendorApprovalHistory ltExpenseApprovalHistory=new LtVendorApprovalHistory();
			
			ltExpenseApprovalHistory.setStatus(status);
			ltExpenseApprovalHistory.setVendorId(expenseApproval.getVendorId());
			ltExpenseApprovalHistory.setVendorApprovalId(expenseApproval.getVendorApprovalId());
			ltExpenseApprovalHistory.setEmployeeId(expenseApproval.getApprovalId());
			ltExpenseApprovalHistory.setVendorId(expenseApproval.getVendorId());
			ltExpenseApprovalHistory.setLastUpdateDate(expenseApproval.getLastUpdateDate());
			
		try
		{
			ltVendorApprovalHistoryService.saveApprovalHistory(ltExpenseApprovalHistory);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}
	
	private void saveEmailTokan(List<VendorApproval> expenseApprovals,String emailTemplate,LtMastVendors ltMastVendors)
	{
		try
		{
			ltMastEmailtokenService.makeEntryInEmailToken(expenseApprovals,emailTemplate,ltMastVendors,"MAIL");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	private void sendMail() throws ServiceException
	{
		List<LtMastEmailtoken> ltMastEmailtokenList = ltMastEmailtokenService.findAllActive();
		for (LtMastEmailtoken ltMastEmailtoken2 : ltMastEmailtokenList)
		{
		try {
			Mail mail = new Mail();
			mail.setMailFrom(new InternetAddress(env.getProperty("email.username")));
			//mail.setMailFrom(new InternetAddress(ltMastEmailtoken2.getEmailObject()));
			mail.setMailTo(ltMastEmailtoken2.getSendTo());
			mail.setMailSubject(ltMastEmailtoken2.getEmailTitle());
			mail.setTemplateName(ltMastEmailtoken2.getEmailTemplate() + ".vm");
			mail.setMailCc(ltMastEmailtoken2.getSendCc());
			 
			mail.setAttachment(ltMastEmailtoken2.getAttachmentPath());
			
			VelocityContext velocityContext = new VelocityContext();

			String emailObject[]=null;
			if(ltMastEmailtoken2.getEmailObject()!=null)
			{
				 emailObject = ltMastEmailtoken2.getEmailObject().split("\\#\\$\\#\\$");
			}
							
			if(emailObject!=null)
			{
				
				String tempKey = null;
				for (String stringEmail : emailObject) 
				{
					
					if(stringEmail != null && stringEmail.contains("="))
					{
						tempKey = stringEmail.split("=")[0].toString();
						if (stringEmail.split("=")[0].toString().equals("action_url")
							&& !ltMastEmailtoken2.getEmailTemplate().equals("vendorInvite")) {
						velocityContext.put(stringEmail.split("=")[0].toString(),
								stringEmail.split("=")[1].toString() + "=" + ltMastEmailtoken2.getTokenId());
					}

					else if (stringEmail.split("=")[0].toString().equals("message")){
						velocityContext.put(stringEmail.split("=")[0].toString(), ltMastEmailtoken2.getMessage());
					}
					else{
						velocityContext.put(stringEmail.split("=")[0].toString(), stringEmail.split("=")[1].toString());
					}
				}else if(tempKey !=null) {
					 Object value = velocityContext.get(tempKey);
					 if(value != null){
						 velocityContext.put(tempKey, value.toString() +", "+ stringEmail); 
					 }
				}
			}
			}	
			
			int result = mailer.sendMail(mail, velocityContext);
			if(result==1){
				ltMastEmailtokenService.updateStatus( ltMastEmailtoken2.getEmailTokenId(), "Send", 0);
				}else{
					ltMastEmailtokenService.updateStatus( ltMastEmailtoken2.getEmailTokenId(), "Fail to Send", 1);
				}
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			if (ltMastEmailtokenRepository.exists(ltMastEmailtoken2.getEmailTokenId())) {
				ltMastEmailtoken2 = ltMastEmailtokenRepository.findOne(ltMastEmailtoken2.getEmailTokenId());
				ltMastEmailtoken2.setEmailStatus("Fail to Send");

				if (ltMastEmailtoken2.getFailureCount() != null)
					ltMastEmailtoken2.setFailureCount(ltMastEmailtoken2.getFailureCount() + 1L);
				else
					ltMastEmailtoken2.setFailureCount(1L);
				ltMastEmailtokenRepository.save(ltMastEmailtoken2);
			}
			//ex.printStackTrace();
			throw new BusinessException(INTERNAL_SERVER_ERROR, null, ex);	
		}
	}
		
	}
}