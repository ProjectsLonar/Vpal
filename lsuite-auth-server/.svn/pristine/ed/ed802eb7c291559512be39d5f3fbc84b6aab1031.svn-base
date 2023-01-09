package com.lonar.UserManagement.web.service;


import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lonar.UserManagement.web.dao.LtMastEmailtokenDao;
import com.lonar.UserManagement.web.model.CodeMaster;
import com.lonar.UserManagement.web.model.LtMastEmailtoken;

@Service
@PropertySource(value = "classpath:serverurl.properties", ignoreResourceNotFound = true)
public class LtMastEmailtokenServiceImpl implements LtMastEmailtokenService,CodeMaster {
	
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	LtMastEmailtokenDao ltMastEmailtokenDao;
	
	/*@Autowired
	LtExpExpenseHeadersDao ltExpExpenseHeadersDao;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;

	@Autowired
	LtMastSysVariablesService ltMastSysVariablesService;
	
	@Autowired
	LtExpExpenseLinesDao ltExpExpenseLinesDao;
	
	@Autowired
	LtExpExpenseHeadersService ltExpExpenseHeadersService;
	
	@Autowired
	LtMastExpenseTypeService ltMastExpenseTypeService;*/
	
	
	@Transactional
	@Override
	public List<LtMastEmailtoken> findByEmailtokenid(Long emailtokenid) throws Exception{
		return ltMastEmailtokenDao.findByEmailtokenid(emailtokenid);
	}

	@Transactional
	@Override
	public List<LtMastEmailtoken> findByTokenid(String tokenid) throws Exception{
		return ltMastEmailtokenDao.findByTokenid(tokenid);
	}

	@Transactional
	@Override
	public List<LtMastEmailtoken> findAllActive() throws Exception{
		return ltMastEmailtokenDao.findAllActive();
	}

	/*@Transactional
	@Override
	public void makeEntryInEmailToken(List<ExpenseApproval> expenseApproval,String emailTemplate,LtExpExpenseHeaders ltExpExpenseHeader,String type) throws Exception 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		DecimalFormat twoDForm = new DecimalFormat("0.00");
		
		for (Iterator iterator = expenseApproval.iterator(); iterator.hasNext();) 
		{
			ExpenseApproval expenseApproval2 = (ExpenseApproval) iterator.next();
			if(expenseApproval2.getApprovalId()!=null)
			{
				//if( !expenseApproval2.getStatus().equals(APPROVED))
				//{
					List<LtMastEmployees> ltMastEmployees=ltMastEmployeesDao.getByEmpIdForEmail(expenseApproval2.getApprovalId()
						.longValue());
					if(!ltMastEmployees.isEmpty() && ltMastEmployees.size()>0)
					{
						for (Iterator iterator2 = ltMastEmployees.iterator(); iterator2.hasNext();)
						{
							//ltExpExpenseHeader=ltExpExpenseHeadersService.findOne(ltExpExpenseHeader.getExpHeaderId());
							
						ltExpExpenseHeader=ltExpExpenseHeadersDao.findEmpDetails(ltExpExpenseHeader.getExpHeaderId());
							
						LtMastEmployees ltMastEmployees2 = (LtMastEmployees) iterator2.next();
						LtMastEmailtoken ltMastEmailtoken=new LtMastEmailtoken();
						
						
						List<LtExpEmailTokenlLine> emailTokenLines=new ArrayList<LtExpEmailTokenlLine>();
						List<LtExpExpenseLines> expenseLines=ltExpExpenseLinesDao.getByExpenseHeaderId(ltExpExpenseHeader.getExpHeaderId());
						List<String> expenseLineEmail = new ArrayList<>();
						
						for(LtExpExpenseLines ltExpExpenseLines:expenseLines)
						{
							LtMastExpenseTypes ltMastExpenseType = ltMastExpenseTypeService.getExpenseTypeById(ltExpExpenseLines.getExpenseTypeId());
							if(ltMastExpenseType!=null)
							{
								ltExpExpenseLines.setExpenseTypeCode(ltMastExpenseType.getExpenseNature()+"("+ltMastExpenseType.getExpenseType()+")");
							}
							if(ltExpExpenseLines!=null){
							//expenseLineEmail.add(ltExpExpenseLines.getLineNo().toString());
							//expenseLineEmail.add(ltExpExpenseLines.getExpenseType());sagar
							//expenseLineEmail.add(ltExpExpenseLines.getReceiptAmount().toString());
							expenseLineEmail.add(ltExpExpenseLines.getJustification());
							}
							LtExpEmailTokenlLine ltExpEmailTokenlLine=new LtExpEmailTokenlLine();
							ltExpEmailTokenlLine.setEmailLineObject("lineNo="+ltExpExpenseLines.getLineNo()+"#$#$expenseType="+ltExpExpenseLines.getExpenseTypeId()
							+"#$#$receiptAmount="+ltExpExpenseLines.getReceiptAmount()+"#$#$purpose="+ltExpExpenseLines.getPurpose());
							//ltExpEmailTokenlLine.setEmailTokenId(emailtokenId);
							
							emailTokenLines.add(ltExpEmailTokenlLine);
							expenseLineEmail.add("lineNo="+ltExpExpenseLines.getLineNo()+"#$#$expenseType="+ltExpExpenseLines.getExpenseType()
							+"#$#$receiptAmount="+ltExpExpenseLines.getReceiptAmount()+"#$#$purpose="+ltExpExpenseLines.getPurpose());
						
						}
						
						ltMastEmailtoken.setSendTo(ltMastEmployees2.getOfficialEmail());
						ltMastEmailtoken.setEmailStatus("SENDING");
						if(type.equals(null) || !type.equals("REMINDER")){
						ltMastEmailtoken.setEmailTitle("Expense approval of "+ltExpExpenseHeader.getEmployeeName()
						+" for "+ltExpExpenseHeader.getExpenseNumber());
						}else{
							ltMastEmailtoken.setEmailTitle("REMINDER: Expense approval of "+ltExpExpenseHeader.getEmployeeName()
							+" for "+ltExpExpenseHeader.getExpenseNumber());
						}
						ltMastEmailtoken.setEmailTemplate(emailTemplate);
						ltMastEmailtoken.setExpiredWithin(1296000L);
						ltMastEmailtoken.setSendDate(new Date());
						
						String submissionDate =formatter.format(
								new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss").parse(ltExpExpenseHeader.getExpenseSubmissionDate().toString()));
						String startDate =formatter.format(
								new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss").parse(ltExpExpenseHeader.getStartDate().toString()));
						String endDate = null;
						if(ltExpExpenseHeader.getEndDate()!=null) {
							endDate =formatter.format(
									new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss").parse(ltExpExpenseHeader.getEndDate().toString()));
						}
						else{
							endDate="-";
						}
						
						ltMastEmailtoken.setEmailObject("ExpNo="+ltExpExpenseHeader.getExpenseNumber()+
								"#$#$SubmissionDate="+submissionDate+
								"#$#$Amount="+twoDForm.format(ltExpExpenseHeader.getExpenseAmount())+
								"#$#$EmpName="+ltExpExpenseHeader.getEmployeeName()+
								"#$#$DivName="+ltExpExpenseHeader.getDivisionName()+
								"#$#$CostCen="+ltExpExpenseHeader.getCostCenterName()+
								"#$#$LocationName="+ltExpExpenseHeader.getLocationName()+
								"#$#$Purpose="+ltExpExpenseHeader.getPurpose()+
								"#$#$StartDate="+startDate+
								"#$#$EndDate="+endDate+
								"#$#$LoginURL="+env.getProperty("LOGIN_URL")+
								"#$#$listDetails="+expenseLineEmail);

					
						Long emailtokenId=ltMastEmailtokenDao.makeEntryInEmailToken(ltMastEmailtoken);
						for (Iterator iterator3 = emailTokenLines.iterator(); iterator3.hasNext();) {
							LtExpEmailTokenlLine ltExpExpenseLines = (LtExpEmailTokenlLine) iterator3.next();
							ltExpExpenseLines.setEmailTokenId(emailtokenId);
						}
						
						ltMastEmailtokenDao.batchInsertLine(emailTokenLines);
						
						}
					}
				//}
				
			}
			
		}
		
	}*/

	@Transactional
	@Override
	public void updateStatus(Long tokenId, String status, Integer count) throws Exception {
		ltMastEmailtokenDao.updateStatus(tokenId, status, count);
	}
	
	
	@Transactional
	@Override
	public List<LtMastEmailtoken> getDataTable(LtMastEmailtoken input) throws Exception 
	{
		if(input.getColumnNo()==1 && input.getSort().equals("desc"))
		{ input.setColumnNo(11); }
		if(input.getColumnNo()==2 && input.getSort().equals("desc"))
		{ input.setColumnNo(12); }
		if(input.getColumnNo()==3 && input.getSort().equals("desc"))
		{ input.setColumnNo(13); }
		if(input.getColumnNo()==4 && input.getSort().equals("desc"))
		{ input.setColumnNo(14); }
		if(input.getColumnNo()==5 && input.getSort().equals("desc"))
		{ input.setColumnNo(15); }
		List<LtMastEmailtoken> list= ltMastEmailtokenDao.getDataTable(input);
		
		return list;
	}
	
	@Transactional
	@Override
	public Long getCount(LtMastEmailtoken input) throws Exception {
		// TODO Auto-generated method stub
		return ltMastEmailtokenDao.getCount(input);
	}

	@Override
	public LtMastEmailtoken getLtMastEmailtokenById(String emailtokenid) {
		// TODO Auto-generated method stub
		return ltMastEmailtokenDao.getLtMastEmailtokenById(emailtokenid);
	}

}
