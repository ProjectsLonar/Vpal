package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.Approval;
import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.DashboardDetails;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceHeaders;
import com.lonar.vendor.vendorportal.model.LtInvoiceLines;
import com.lonar.vendor.vendorportal.model.LtMastEmployeeDelegation;
import com.lonar.vendor.vendorportal.model.LtMastModuleApprovals;
import com.lonar.vendor.vendorportal.model.LtPoLines;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.Status;
import com.lonar.vendor.vendorportal.repository.LtInvoiceHeadersRepository;
import com.lonar.vendor.vendorportal.repository.LtInvoiceLinesRepository;

@Repository
@PropertySource(value = "classpath:queries/invoiceHeaderQueries.properties", ignoreResourceNotFound = true)
public class LtInvoiceHeadersDaoImpl implements LtInvoiceHeadersDao,CodeMaster{

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	@Autowired
	LtInvoiceHeadersRepository ltInvoiceHeadersRepository ;
	
	@Autowired
	LtInvoiceLinesRepository ltInvoiceLinesRepository;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	@Autowired
	LtMastEmployeeDelegationDao ltMastEmployeeDelegationDao;
	
	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Long getLtInvoiceHeadersCount(LtInvoiceHeaders input,Long companyId) throws ServiceException
	{
		String query = env.getProperty("getLtInvoiceHeadersCount");
		 
		String typeLookupCode=null;
		   if(input.getInvoiceType()!=null && !input.getInvoiceType().equals(""))
		   {typeLookupCode="%"+input.getInvoiceType().trim().toUpperCase() + "%";}
		   
		   String invoiceNumber=null;
		   if(input.getInvoiceNum()!=null && !input.getInvoiceNum().equals(""))
		   {invoiceNumber="%"+input.getInvoiceNum().trim().toUpperCase()+"%";}
		   
		   
			if(input.getiDate() == null || input.getiDate().trim().equals(""))
			{
				input.setiDate(null);
			}
			
		   String desc=null;
		   if(input.getDescription()!=null &&  !input.getDescription().equals("")) 
		   {desc="%"+input.getDescription().trim().trim().toUpperCase()+"%";}
		   
		   String iAmount=null;
		   if(input.getInvoiceAmount()!=null)
		   {iAmount="%"+Double.valueOf(input.getInvoiceAmount()).intValue()+"%";}
			
		   String intInvoiceNumber=null;
		   if(input.getInternalInvoiceNumber()!=null && !input.getInternalInvoiceNumber().equals(""))
		   {intInvoiceNumber="%"+input.getInternalInvoiceNumber().trim().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null &&  !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   
		   String poNumber=null;
		   if(input.getPoNumber()!=null &&  !input.getPoNumber().equals("")) 
		   {poNumber="%"+input.getPoNumber().trim().toUpperCase()+"%";}
		   
		   String pAmount=null;
		   if(input.getAmountPaid()!=null)
		   {pAmount="%"+Double.valueOf(input.getAmountPaid()).intValue()+"%";}
		  
		   
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,input.getBuyerId(),input.getBuyerId(),typeLookupCode,intInvoiceNumber, 
						invoiceNumber,input.getiDate(),desc,iAmount,pAmount,status,poNumber}, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtInvoiceHeaders> getLtInvoiceHeadersDataTable(LtInvoiceHeaders input,Long companyId) throws ServiceException 
	{
		String query = env.getProperty("getLtInvoiceHeadersDataTable");
		
		String typeLookupCode=null;
		   if(input.getInvoiceType()!=null && !input.getInvoiceType().equals(""))
		   {typeLookupCode="%"+input.getInvoiceType().trim().toUpperCase() + "%";}
		   
		   String intInvoiceNumber=null;
		   if(input.getInternalInvoiceNumber()!=null && !input.getInternalInvoiceNumber().equals(""))
		   {intInvoiceNumber="%"+input.getInternalInvoiceNumber().trim().toUpperCase()+"%";}
		   
		   String invoiceNumber=null;
		   if(input.getInvoiceNum()!=null && !input.getInvoiceNum().equals(""))
		   {invoiceNumber="%"+input.getInvoiceNum().trim().toUpperCase()+"%";}
		   
		   
			if(input.getiDate() == null || input.getiDate().trim().equals(""))
			{
				input.setiDate(null);
			}
			
		   String desc=null;
		   if(input.getDescription()!=null &&  !input.getDescription().equals("")) 
		   {desc="%"+input.getDescription().trim().trim().toUpperCase()+"%";}
		   
		   String iAmount=null;
		   if(input.getInvoiceAmount()!=null)
		   {iAmount="%"+Double.valueOf(input.getInvoiceAmount()).intValue()+"%";}
			
		   
		   
		   String status=null;
		   if(input.getStatus()!=null &&  !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   

		   String pAmount=null;
		   if(input.getAmountPaid()!=null)
		   {pAmount="%"+Double.valueOf(input.getAmountPaid()).intValue()+"%";}
			
		   String poNumber=null;
		   if(input.getPoNumber()!=null &&  !input.getPoNumber().equals("")) 
		   {poNumber="%"+input.getPoNumber().trim().toUpperCase()+"%";}
		   
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(1);
			}
			
			
			List<LtInvoiceHeaders> list = (List<LtInvoiceHeaders>) 
					jdbcTemplate.query(query , new Object[]{companyId,input.getBuyerId(),input.getBuyerId(),
							typeLookupCode,intInvoiceNumber,invoiceNumber,input.getiDate(),desc,iAmount,pAmount,status,poNumber,
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtInvoiceHeaders>(LtInvoiceHeaders.class));
				return list;
	}

	@Override
	public Long getLtInvoiceHeadersCountByVendorId(LtInvoiceHeaders input, Long venId) throws ServiceException{
		String query = env.getProperty("getLtInvoiceHeadersCountByVendorId");
		 
		String typeLookupCode=null;
		   if(input.getInvoiceType()!=null && !input.getInvoiceType().equals(""))
		   {typeLookupCode="%"+input.getInvoiceType().trim().toUpperCase() + "%";}
		   
		   String intInvoiceNumber=null;
		   if(input.getInternalInvoiceNumber()!=null && !input.getInternalInvoiceNumber().equals(""))
		   {intInvoiceNumber="%"+input.getInternalInvoiceNumber().trim().toUpperCase()+"%";}
		   
		   String invoiceNumber=null;
		   if(input.getInvoiceNum()!=null && !input.getInvoiceNum().equals(""))
		   {invoiceNumber="%"+input.getInvoiceNum().trim().toUpperCase()+"%";}
		   
		   
			if(input.getiDate() == null || input.getiDate().trim().equals(""))
			{
				input.setiDate(null);
			}
			
		   String desc=null;
		   if(input.getDescription()!=null &&  !input.getDescription().equals("")) 
		   {desc="%"+input.getDescription().trim().trim().toUpperCase()+"%";}
		   
		   String iAmount=null;
		   if(input.getInvoiceAmount()!=null)
		   {iAmount="%"+Double.valueOf(input.getInvoiceAmount()).intValue()+"%";}
			
		   
		   
		   String status=null;
		   if(input.getStatus()!=null &&  !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   

		   String pAmount=null;
		   if(input.getAmountPaid()!=null)
		   {pAmount="%"+Double.valueOf(input.getAmountPaid()).intValue()+"%";}
		  
		   
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {venId,typeLookupCode,intInvoiceNumber,invoiceNumber,input.getiDate(),desc,iAmount,pAmount,
						status}, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<LtInvoiceHeaders> getLtInvoiceHeadersDataTableByVendorId(LtInvoiceHeaders input, Long venId) throws ServiceException {
		String query = env.getProperty("getLtInvoiceHeadersDataTableByVendorId");
		
		String typeLookupCode=null;
		   if(input.getInvoiceType()!=null && !input.getInvoiceType().equals(""))
		   {typeLookupCode="%"+input.getInvoiceType().trim().toUpperCase() + "%";}
		   
		   String intInvoiceNumber=null;
		   if(input.getInternalInvoiceNumber()!=null && !input.getInternalInvoiceNumber().equals(""))
		   {intInvoiceNumber="%"+input.getInternalInvoiceNumber().trim().toUpperCase()+"%";}
		   
		   String invoiceNumber=null;
		   if(input.getInvoiceNum()!=null && !input.getInvoiceNum().equals(""))
		   {invoiceNumber="%"+input.getInvoiceNum().trim().toUpperCase()+"%";}
		   
		   
			if(input.getiDate() == null || input.getiDate().trim().equals(""))
			{
				input.setiDate(null);
			}
			
		   String desc=null;
		   if(input.getDescription()!=null &&  !input.getDescription().equals("")) 
		   {desc="%"+input.getDescription().trim().trim().toUpperCase()+"%";}
		   
		   String iAmount=null;
		   if(input.getInvoiceAmount()!=null)
		   {iAmount="%"+Double.valueOf(input.getInvoiceAmount()).intValue()+"%";}
			
		   
		   
		   String status=null;
		   if(input.getStatus()!=null &&  !input.getStatus().equals("")) 
		   {status="%"+input.getStatus().trim().toUpperCase()+"%";}
		   

		   String pAmount=null;
		   if(input.getAmountPaid()!=null)
		   {pAmount="%"+Double.valueOf(input.getAmountPaid()).intValue()+"%";}
			
			if(input.getColumnNo()==0)
			{
				input.setColumnNo(1);
			}
			
			
			List<LtInvoiceHeaders> list = (List<LtInvoiceHeaders>) 
					jdbcTemplate.query(query , new Object[]{venId,typeLookupCode,intInvoiceNumber,invoiceNumber,input.getiDate(),
							desc,iAmount,pAmount,status,
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtInvoiceHeaders>(LtInvoiceHeaders.class));
				return list;
	}

	@Override
	public List<DashboardDetails> getCountAndStatusByVendorId(Long vendorId) throws ServiceException {
		String query = env.getProperty("getCountAndStatusByVendorId");
		List<DashboardDetails> list=   jdbcTemplate.query(query, new Object[]{ vendorId }, 
				 new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class)); 
		
		 return list;
	}

	@Override
	public List<LtInvoiceHeaders> getAllInvoice() throws ServiceException {
		String query = env.getProperty("getAllInvoice");
		List<LtInvoiceHeaders> list=   jdbcTemplate.query(query, new Object[]{  }, 
				 new BeanPropertyRowMapper<LtInvoiceHeaders>(LtInvoiceHeaders.class)); 
		
		 return list;
	}

	@Override
	public List<LtInvoiceHeaders> getAllInvoiceByInitiator(Long initiatorId) throws ServiceException {
		String query = env.getProperty("getAllInvoiceByInitiator");
		List<LtInvoiceHeaders> list=   jdbcTemplate.query(query, new Object[]{initiatorId  }, 
				 new BeanPropertyRowMapper<LtInvoiceHeaders>(LtInvoiceHeaders.class)); 
		
		 return list;
	}

	@Override
	public LtInvoiceHeaders getInvoiceById(Long id) throws ServiceException {
		String query = env.getProperty("getInvoiceById");
		List<LtInvoiceHeaders> list=   jdbcTemplate.query(query, new Object[]{id  }, 
				 new BeanPropertyRowMapper<LtInvoiceHeaders>(LtInvoiceHeaders.class)); 
		if(list.isEmpty())
			return null;
		else
		 return list.get(0);
	}
	
	@Override
	public Long save(LtInvoiceHeaders ltInvoiceHeaders) throws ServiceException {
		if(ltInvoiceHeaders.getInvoiceHeaderId()!=null) {
		String internalInvoiceNum =  (String) em.createNativeQuery(
			        "SELECT LT_VPAL_COMMON_PKG.get_internal_invoice_number(:p_invoice_header_id) FROM DUAL"
			    )
			    .setParameter("p_invoice_header_id", ltInvoiceHeaders.getInvoiceHeaderId())
			    .getSingleResult();
	    		  
		ltInvoiceHeaders.setInternalInvoiceNumber(internalInvoiceNum);
		}
		
		ltInvoiceHeaders = ltInvoiceHeadersRepository.save(ltInvoiceHeaders);
		if(ltInvoiceHeaders.getInvoiceHeaderId()!=null) {
			
			return ltInvoiceHeaders.getInvoiceHeaderId();
		}
			
		else
		return null;
	}

	@Override
	public boolean update(LtInvoiceHeaders ltInvoiceHeaders) throws ServiceException {
		ltInvoiceHeaders = ltInvoiceHeadersRepository.save(ltInvoiceHeaders);
		if(ltInvoiceHeaders.getInvoiceHeaderId()!=null) {
			
			return true;
		}
		else
		return false;
	}

	@Override
	public LtInvoiceHeaders getByInvoiceNumber(String invoiceNum) throws ServiceException {
		String query = env.getProperty("getByInvoiceNumber");
		List<LtInvoiceHeaders> list=   jdbcTemplate.query(query, new Object[]{invoiceNum.toUpperCase()  }, 
				 new BeanPropertyRowMapper<LtInvoiceHeaders>(LtInvoiceHeaders.class)); 
		if(list.isEmpty())
			return null;
		else
		 return list.get(0);
	}

	@Override
	public List<LtInvoiceHeaders> getInprocessInvoiceList(String inprogressStr) throws ServiceException {
		String query = " SELECT  inv.*, apr.APPROVAL_LEVEL  " + 
				" FROM LT_INVOICE_HEADERS inv, LT_INVOICE_APPROVAL apr " + 
				" WHERE apr.INVOICE_HEADER_ID = inv.INVOICE_HEADER_ID" + 
				" AND inv.Status= 'INVOICE_INPROCESS' " + 
				" AND ((apr.APPROVAL_LEVEL = apr.CURRENT_APPROVAL_LEVEL AND apr.STATUS = 'INVOICE_APPROVED') " + 
				" OR (apr.CURRENT_APPROVAL_LEVEL IS NULL AND apr.STATUS = 'NO_ACTION') " + 
				" OR  (apr.APPROVAL_LEVEL = apr.CURRENT_APPROVAL_LEVEL AND apr.STATUS = 'NO_ACTION'))";
		List<LtInvoiceHeaders> list=   jdbcTemplate.query(query, new Object[]{  }, 
			 new BeanPropertyRowMapper<LtInvoiceHeaders>(LtInvoiceHeaders.class)); 
		return list;
	}

	@Override
	public InvoiceApproval getApprovalLevel(Long invoiceHeaderId) throws ServiceException {
		//String query = env.getProperty("getApprovalLevel");
		
		String query = "select   MIN( APPROVAL_LEVEL) as MIN_LEVEL,  CURRENT_APPROVAL_LEVEL ,MODULE_APPROVAL_ID " + 
				" from LT_INVOICE_APPROVAL where INVOICE_HEADER_ID = ? " + 
				" group by APPROVAL_LEVEL,  CURRENT_APPROVAL_LEVEL ,MODULE_APPROVAL_ID order by MIN_LEVEL";
		
		List<InvoiceApproval> invoiceApprovalList = jdbcTemplate.query(query, new Object[] {invoiceHeaderId},
				
				new RowMapper<InvoiceApproval>() {
					public InvoiceApproval mapRow(ResultSet rs, int arg1) throws SQLException {

						InvoiceApproval invoiceApproval = new InvoiceApproval();

						invoiceApproval.setApprovalLevel(rs.getString("MIN_LEVEL"));
						invoiceApproval.setCurrentApprovalLevel(rs.getString("CURRENT_APPROVAL_LEVEL"));
						invoiceApproval.setModuleApprovalId(rs.getLong("MODULE_APPROVAL_ID"));
						
						
						return invoiceApproval;
					}
				});
		if(invoiceApprovalList.size()>0)
			return invoiceApprovalList.get(0); 
		else 
			return null;
	}

	@Override
	public List<InvoiceApproval> getApprovalList(Long invoiceHeaderId, String currentApprovalLevel)
			throws ServiceException {
		
		String query = " SELECT a.*,'N' as APPROVED_BY_ANYONE " + 
				" FROM LT_INVOICE_APPROVAL a left outer join lt_mast_module_approvals b " + 
				" on a.MODULE_APPROVAL_ID=b.MODULE_APPROVAL_ID  " + 
				" WHERE a.INVOICE_HEADER_ID = ? AND a.APPROVAL_LEVEL = nvl(?,a.APPROVAL_LEVEL) ORDER BY a.APPROVAL_LEVEL ASC ";
		List<InvoiceApproval> list=   jdbcTemplate.query(query, new Object[]{ invoiceHeaderId,currentApprovalLevel}, 
				 new BeanPropertyRowMapper<InvoiceApproval>(InvoiceApproval.class));
			return list;
	}

	@Override
	public String getNextApprovalLevel(Long invoiceHeaderId, String currentApprovalLavel) throws ServiceException {
		String query = "select MIN (APPROVAL_LEVEL) AS  CURRENT_APPROVAL_LEVEL " + 
				" from LT_INVOICE_APPROVAL where INVOICE_HEADER_ID = ? AND APPROVAL_LEVEL > ? AND STATUS <> ? ";
		
		String nextlavel  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] { invoiceHeaderId, currentApprovalLavel,INVOICE_APPROVED}, String.class);

		return nextlavel;
	}

	@Override
	public boolean submitForApproval(Date date, Long invoiceHeaderId, String status, Object object)
			throws ServiceException {
		String query ="UPDATE LT_INVOICE_HEADERS SET Status = ? , Last_update_date =? WHERE INVOICE_HEADER_ID = ? ";
		
		int res=jdbcTemplate.update(query,status ,new Date(), invoiceHeaderId);
		
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public boolean upDateStatus(Long invoiceHeaderId, String status, String currentApprovalLavel)
			throws ServiceException {
		int res=0;
		if(currentApprovalLavel!=null)
		{
			//String query = env.getProperty("upDateStatus1");
			String query = " UPDATE LT_INVOICE_APPROVAL SET STATUS=?,LAST_UPDATE_DATE=? " + 
					" WHERE INVOICE_HEADER_ID=? AND APPROVAL_LEVEL =? AND STATUS <> ? ";
			 res=jdbcTemplate.update(query,
				        status,new Date(),invoiceHeaderId,currentApprovalLavel,"APPROVED");
		}
		else
		{
			//String query = env.getProperty("upDateStatus2");
			String query =" UPDATE LT_INVOICE_APPROVAL SET " + 
					"STATUS=? ,LAST_UPDATE_DATE= ?, CURRENT_APPROVAL_LEVEL=? WHERE INVOICE_HEADER_ID=?";
			
			res=jdbcTemplate.update(query,
			        status,new Date(),currentApprovalLavel,invoiceHeaderId);
		}
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public void updateCurrentApprovalLevel(Long invoiceHeaderId, String currentApprovalLavel) throws ServiceException {
		//String query = env.getProperty("updateCurrentApprovalLevel");
		String query = "UPDATE LT_INVOICE_APPROVAL SET " + 
				"CURRENT_APPROVAL_LEVEL = ?  WHERE INVOICE_HEADER_ID=? ";
		
		int res=jdbcTemplate.update(query,
				currentApprovalLavel, invoiceHeaderId );
	}

	@Override
	public String checkforApprovals(Long invoiceHeaderId) throws ServiceException {
		String query = " SELECT ma.*  "
				+" FROM LT_MAST_MODULE_APPROVALS ma "
				+" WHERE ma.DIVISION_ID = "
				+"  (SELECT e.DIVISION_ID FROM LT_MAST_EMPLOYEES e,LT_INVOICE_HEADERS inv WHERE e.EMPLOYEE_ID = inv.buyer_id and inv.INVOICE_HEADER_ID = ? ) ";
				 
		List<LtMastModuleApprovals> list=   jdbcTemplate.query(query, new Object[]{invoiceHeaderId}, 
					 new BeanPropertyRowMapper<LtMastModuleApprovals>(LtMastModuleApprovals.class)); 
		
		if(list.isEmpty())
			return "null";
		else
		return "present";
	}

	@Override
	public Status invoiceSubmitForApproval(Date date, Long invoiceHeaderId, String status, Object object)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean chkForApprovers(Long invoiceHeaderId) throws ServiceException {
		// TODO Auto-generated method stub
		String query = " SELECT ea.*, "
				+" nvl2 (  ea.DELEGATION_ID,  "
				+" (  ( cmv.VALUE_NAME||' '|| em.FIRST_NAME|| ' '||em.LAST_NAME||' '||'('|| em.EMPLOYEE_NUMBER|| ')' )  "
				+" ||   " 
				+" ( ' ('|| ( cmvv.VALUE_NAME||' '|| emm.FIRST_NAME|| ' '||emm.LAST_NAME||' '||'('|| emm.EMPLOYEE_NUMBER|| ')' ) ||')' ) ), "
				+" ( cmv.VALUE_NAME||' '|| em.FIRST_NAME|| ' '||em.LAST_NAME||' '||'('|| em.EMPLOYEE_NUMBER|| ')' ) "
				+" )  AS approval_Name ,  "
				+" CASE ea.MODULE_APPROVAL_ID  "
				+" WHEN 0 THEN 'Invitor' "
				+" ELSE ema.approval_role_name END as approval_level_name "
				+" FROM "
				+" lt_Invoice_Approval ea, "
				+" lt_mast_employees em ,"
				+" LT_MAST_COMN_MASTER_VALUES cmv,  "
				+" LT_MAST_COMN_MASTER_VALUES cmvv, "
				+" lt_mast_module_approvals ema , "
				+" lt_mast_employees emm  "
				+" where ea.APPROVAL_ID=em.EMPLOYEE_ID(+) "
				+" and ea.DELEGATION_ID = emm.EMPLOYEE_ID(+)  "
				+" and em.TITLE = cmv.value_code(+)  "
				+" and emm.TITLE = cmvv.value_code(+) "
				+" and ea.APPROVAL_LEVEL = ema.APPROVAL_LEVEL(+)  "
				+" and ea.MODULE_APPROVAL_ID = ema.MODULE_APPROVAL_ID(+)  "
				+" and ea.INVOICE_HEADER_ID = ? order by ea.APPROVAL_LEVEL ";

		List<InvoiceApproval> invoiceApprovalList = jdbcTemplate.query(query, new Object[] {invoiceHeaderId},
				new RowMapper<InvoiceApproval>() {
					public InvoiceApproval mapRow(ResultSet rs, int arg1) throws SQLException {

						InvoiceApproval invoiceApproval = new InvoiceApproval();
						
						invoiceApproval.setInvoiceApprovalId(rs.getLong("INVOICE_APPROVAL_ID"));
						invoiceApproval.setModuleApprovalId(rs.getLong("MODULE_APPROVAL_ID"));
						invoiceApproval.setApprovalId(rs.getLong("APPROVAL_ID"));
						invoiceApproval.setApprovalLevel(rs.getString("APPROVAL_LEVEL"));
						invoiceApproval.setCurrentApprovalLevel(rs.getString("CURRENT_APPROVAL_LEVEL"));
						
						invoiceApproval.setInvoiceHeaderId(rs.getLong("INVOICE_HEADER_ID"));
						
						return invoiceApproval;
					}
				});
		
		
		if(invoiceApprovalList.size() > 0){
			return true;
		}else
			return false;
	}

	@Transactional
	@Override
	public boolean loadApprovers(LtInvoiceHeaders ltInvoiceHeaders) throws ServiceException {
		
		List<InvoiceApproval> invoiceApprovalsList = getApprovalList(ltInvoiceHeaders.getInvoiceHeaderId(),null);
		if(invoiceApprovalsList.isEmpty()) {
		 String query = " SELECT a.module_app_employees_id,a.employees_id,b.approval_level,b.module, "
					+ " a.MODULE_APPROVAL_ID ,a.START_DATE,a.END_DATE  "
					+ " FROM lt_mast_module_app_emp a,lt_mast_module_approvals b "
					+ " WHERE a.MODULE_APPROVAL_ID=b.MODULE_APPROVAL_ID "
					+ " AND DIVISION_ID= ? "
					+ " AND MODULE= 'INVOICE'  "
					+ " AND STATUS= 'DRAFT' "
					+ " AND ( a.START_DATE <= SYSDATE AND (a.END_DATE is null or a.END_DATE > SYSDATE) ) ";
			
			List<Approval> approvalList=   jdbcTemplate.query(query, new Object[]{ ltInvoiceHeaders.getDivisionId()}, 
				 new BeanPropertyRowMapper<Approval>(Approval.class)); 
		 
			//List<LtMastEmployees>  empList=ltMastEmployeesDao.getByEmpId(ltInvoiceHeaders.getBuyerId());
			
				Approval superviserApproval = new Approval();
				superviserApproval.setEmployeesId(ltInvoiceHeaders.getBuyerId());
				superviserApproval.setApprovalLevel("00");
				superviserApproval.setModuleApprovalId(00L);
			
				approvalList.add(superviserApproval);
			
			boolean flag=false;
		if(approvalList.size()>0)
		{
			for(Approval approvalObj:approvalList)
			{
				Approval approval=approvalObj;
				List<LtMastEmployeeDelegation> ltMastEmployeeDelegation = ltMastEmployeeDelegationDao
						.findForDelegation(approvalObj.getEmployeesId());
				if(ltMastEmployeeDelegation!= null && ltMastEmployeeDelegation.size()>0)
				{
					approval.setDelegationId(ltMastEmployeeDelegation.get(0).getDelegationId());
				}
				
				int res=0;
				if(approval.getEmployeesId()!=null && approval.getModuleApprovalId()!=null && approval.getApprovalLevel()!=null)
				{
					res=jdbcTemplate.update(" INSERT INTO lt_invoice_approval "
							+ " ( INVOICE_APPROVAL_ID,MODULE_APPROVAL_ID,APPROVAL_ID,APPROVAL_LEVEL,CURRENT_APPROVAL_LEVEL,DELEGATION_ID, "
							+ " INVOICE_HEADER_ID, STATUS,START_DATE,END_DATE, CREATED_BY,CREATION_DATE,LAST_UPDATE_LOGIN,"
							+ " LAST_UPDATED_BY,LAST_UPDATE_DATE ,MODULE_APP_EMPLOYEES_ID)  "
			 		+ " VALUES(LT_VENDOR_APPROVAL_S.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ",
			 		approval.getModuleApprovalId(),approval.getEmployeesId(),approval.getApprovalLevel(),
			 		null,approval.getDelegationId(),ltInvoiceHeaders.getInvoiceHeaderId(),NO_ACTION,new Date(),
			 		null,ltInvoiceHeaders.getCreatedBy(),new Date(),
			 		ltInvoiceHeaders.getLastUpdateLogin(),ltInvoiceHeaders.getLastUpdatedBy(),
			 		new Date(),approval.getModuleAppEmployeesId());
					if(res!=0)
						flag=true;
				}
				
			}
		}
		
		return flag;
		}else {
			boolean flag=false;
			invoiceApprovalsList.get(0).setApprovalId(ltInvoiceHeaders.getBuyerId());
			//for(InvoiceApproval invoiceApproval : invoiceApprovalsList ) {
				int res=0;
				res=jdbcTemplate.update(" UPDATE lt_invoice_approval SET APPROVAL_ID = ?,LAST_UPDATE_DATE = ? "
						+ "  WHERE INVOICE_APPROVAL_ID = ? AND APPROVAL_LEVEL = ? ",
						invoiceApprovalsList.get(0).getApprovalId(),new Date(),invoiceApprovalsList.get(0).getInvoiceApprovalId(),"00");
				if(res!=0) {
					return flag=true;
				}
			//}
			return flag;
		}
	}

	@Override
	public LtInvoiceHeaders getInvoiceStatusById(Long invoiceHeaderId) throws ServiceException {
		
		Status status = new Status();
		String query = " select STATUS, CREATED_BY from LT_INVOICE_HEADERS where INVOICE_HEADER_ID = ? ";
		
		List<LtInvoiceHeaders> itInvoiceHeadersList = jdbcTemplate.query(query, new Object[] {invoiceHeaderId},
				new RowMapper<LtInvoiceHeaders>() {
					public LtInvoiceHeaders mapRow(ResultSet rs, int arg1) throws SQLException {

						LtInvoiceHeaders invoiceHeaders = new LtInvoiceHeaders();
						
						invoiceHeaders.setStatus(rs.getString("STATUS"));
						invoiceHeaders.setCreatedBy(rs.getLong("CREATED_BY"));
						
						return invoiceHeaders;
					}
				});
		
		
		if(itInvoiceHeadersList.size() > 0){
			return itInvoiceHeadersList.get(0);
		}else {
			return null;
		}
		
		
	}

	@Override
	public boolean checkStatusIsPending(Long invoiceHeaderId, Long approvalId) throws ServiceException {
		String query = " select * from LT_INVOICE_APPROVAL "
				 		+" where INVOICE_HEADER_ID = ? "
						 +" AND (APPROVAL_ID = ? OR DELEGATION_ID = ? ) "
						 +" AND APPROVAL_LEVEL = CURRENT_APPROVAL_LEVEL "
						 +" AND STATUS = 'PENDING' ";
				 
		List<InvoiceApproval> list=   jdbcTemplate.query(query, new Object[]{invoiceHeaderId, approvalId,approvalId}, 
					 new BeanPropertyRowMapper<InvoiceApproval>(InvoiceApproval.class)); 
		
		if(list.size() > 0)
			return true;
		else
		return false;
	}

	@Override
	public LtInvoiceHeaders getByInvNumVendAndAddr(String invoiceNum, Long vendorId, Long vendorAddId)
			throws ServiceException {
		String query = env.getProperty("getByInvNumVendAndAddr");
		List<LtInvoiceHeaders> list=   jdbcTemplate.query(query, new Object[]{invoiceNum.toUpperCase(),vendorId, vendorAddId }, 
				 new BeanPropertyRowMapper<LtInvoiceHeaders>(LtInvoiceHeaders.class)); 
		if(list.isEmpty())
			return null;
		else
		 return list.get(0);
	}

	@Override
	public boolean delete(Long invoiceHeaderId) throws ServiceException {
		String query = env.getProperty("deleteInvoiceHeaderById");
		
		int res=jdbcTemplate.update(query, invoiceHeaderId);
		
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<DashboardDetails> getInvoiceAmtByUserId(Long userId) throws ServiceException {
		String query = env.getProperty("getInvoiceAmtByUserId");
		List<DashboardDetails> list=   jdbcTemplate.query(query, new Object[]{ userId }, 
				 new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class)); 
		
		 return list;
	}

	@Override
	public Status callInvoiceValidationProc(Long invoiceHeaderId) throws ServiceException {
		Status status = new Status();
		StoredProcedureQuery query = em
			    .createStoredProcedureQuery("lt_vpal_invoice_validation_pkg.validate_invoice")
			    .registerStoredProcedureParameter(1, Long.class, 
				         ParameterMode.IN)
			    .registerStoredProcedureParameter(2, String.class, 
			         ParameterMode.OUT)
		        .registerStoredProcedureParameter(3, String.class, 
		         ParameterMode.OUT)
			    .setParameter(1, invoiceHeaderId);
			query.execute();

			if(query.getOutputParameterValue(2).toString().trim().equals("ERROR")){
				status.setCode(FAIL);
				status.setMessage(query.getOutputParameterValue(3).toString().trim());
			}
			else if(query.getOutputParameterValue(2).toString().trim().equals("SUCCESS")){
				status.setCode(SUCCESS);
				status.setMessage(query.getOutputParameterValue(3).toString().trim());
				
			}
			return status;
	}

	@Override
	public void loadLines(LtInvoiceHeaders ltInvoiceHeaders) {
		
		//String query = env.getProperty("getByInvNumVendAndAddr");
		String query =" SELECT * FROM LT_PO_LINES WHERE PO_HEADER_ID = ? ";
		List<LtPoLines> poLinelist=   jdbcTemplate.query(query, new Object[]{ltInvoiceHeaders.getPoHeaderId()}, 
				 new BeanPropertyRowMapper<LtPoLines>(LtPoLines.class)); 
		
		if(!poLinelist.isEmpty()) {
			for(LtPoLines ltPoLine : poLinelist) {
				LtInvoiceLines ltInvoiceLines = new LtInvoiceLines();
				ltInvoiceLines.setInvoiceHeaderId(ltInvoiceHeaders.getInvoiceHeaderId());
				ltInvoiceLines.setPoHeaderId(ltInvoiceHeaders.getPoHeaderId());
				ltInvoiceLines.setPoLineId(ltPoLine.getPoLineId());
				ltInvoiceLines.setLineType(ltPoLine.getLineType());
				ltInvoiceLines.setCategoryId(ltPoLine.getCategoryId());
				//ltInvoiceLines.setSubCategoryId(ltPoLine.gets);
				ltInvoiceLines.setProductId(ltPoLine.getProductId());
				ltInvoiceLines.setDescription(ltPoLine.getProductDescription());
			//	ltInvoiceLines.setUom(ltPoLine.get);
				ltInvoiceLines.setCreationDate(new Date());
				ltInvoiceLines.setLastUpdateDate(new Date());
				ltInvoiceLines.setCreatedBy(ltInvoiceHeaders.getLastUpdateLogin());
				ltInvoiceLines.setLastUpdatedBy(ltInvoiceHeaders.getLastUpdateLogin());
				ltInvoiceLines.setLastUpdatedBy(ltInvoiceHeaders.getLastUpdateLogin());
				ltInvoiceLines.setLastUpdateLogin(ltInvoiceHeaders.getLastUpdateLogin());
				
				ltInvoiceLines = ltInvoiceLinesRepository.save(ltInvoiceLines);
			}
		}
		
		
		
	}

	

}
