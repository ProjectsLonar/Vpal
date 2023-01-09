package com.lonar.vendor.vendorportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/invoiceApprovalQueries.properties", ignoreResourceNotFound = true)
public class LtInvoiceApprovalDaoImpl implements LtInvoiceApprovalDao{

	@Autowired
	private Environment env;

	@PersistenceContext(name = "em")
	private EntityManager em;
	
	@Autowired
	LtMastEmployeesDao ltMastEmployeesDao;
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	} 
	
	
	@Override
	public boolean updateStatusApproval(LtInvoiceApprovalHistory approvalHistory) throws ServiceException {
		int res=0;	
		if(approvalHistory.getEmployeeId()!=null ) 
		{
			String query = " UPDATE LT_INVOICE_APPROVAL "
			+" SET  Status= ? , LAST_UPDATE_DATE = ?,LAST_UPDATED_BY=? " 
			+" WHERE INVOICE_HEADER_ID = ?  AND (APPROVAL_ID = ? OR DELEGATION_ID = ?) ";
			
			res = jdbcTemplate.update(query,
					approvalHistory.getStatus(),new Date(),approvalHistory.getInvoiceApprovalId(),
					approvalHistory.getInvoiceHeaderId(), approvalHistory.getEmployeeId(),approvalHistory.getEmployeeId());
		}
			
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateAllStatusApproval(LtInvoiceApprovalHistory approvalHistory) throws ServiceException {
		//String query = env.getProperty("updateAllStatusApproval");
		
		String query = "UPDATE LT_INVOICE_APPROVAL "
		+" SET  Status= ? ,LAST_UPDATE_DATE=?,LAST_UPDATED_BY=? "
		+" WHERE INVOICE_HEADER_ID = ?  AND CURRENT_APPROVAL_LEVEL =  APPROVAL_LEVEL ";
		
		int res=0;	
			res = jdbcTemplate.update(query,
						approvalHistory.getStatus(),new Date(),approvalHistory.getInvoiceApprovalId(),
						approvalHistory.getInvoiceHeaderId());
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<InvoiceApproval> chkInvoiceEmpApproval(Long employeeId, Long invoiceId) throws ServiceException {
		String query =   " SELECT * FROM LT_INVOICE_APPROVAL inv  "+
				" WHERE inv.APPROVAL_ID = ? and inv.INVOICE_HEADER_ID = ?  and inv.STATUS = ? ";

		List<InvoiceApproval> invoiceApprovalList = jdbcTemplate.query(query, new Object[]
				{employeeId,invoiceId,"APPROVED"},
				new RowMapper<InvoiceApproval>() {
					public InvoiceApproval mapRow(ResultSet rs, int arg1) throws SQLException {

						InvoiceApproval invoiceApproval = new InvoiceApproval();
						
						invoiceApproval.setInvoiceApprovalId(rs.getLong("INVOICE_APPROVAL_ID"));
						
						return invoiceApproval;
					}
				});
	
		return invoiceApprovalList;
	}

	@Override
	public boolean submitForApproval(Date submissionDate, Long invoiceHeaderId, String status, Date approvedDate,Long lastLogin)
			throws ServiceException {
		int res=0;
		if(submissionDate!=null)
		{
			String query = env.getProperty("submitInvoiceForApproval1");
			res=jdbcTemplate.update(query,status,new Date(),lastLogin,invoiceHeaderId);
			
		}
		else
		{
			String query = env.getProperty("submitInvoiceForApproval2");
			 res=jdbcTemplate.update(query,status,new Date(),lastLogin,invoiceHeaderId);
		}
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public String getCurrLevelByInvoiceApprovalId(Long invoiceApprovalId) throws ServiceException {
		String query = env.getProperty("getCurrLevelByInvoiceApprovalId");
		
		String nextlavel  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] { invoiceApprovalId}, String.class);

		return nextlavel;
	}

	@Override
	public boolean upDateStatus(Long invoiceHeaderId, String status, String currentApprovalLevel) throws ServiceException {
		int res=0;
		
		if(currentApprovalLevel!=null)
		{
			String query = env.getProperty("upDateInvoiceStatus1");
			 res=jdbcTemplate.update(query,
				        status,new Date(),invoiceHeaderId,currentApprovalLevel,"APPROVED");
		}
		else
		{
			String query = env.getProperty("upDateInvoiceStatus2");
			res=jdbcTemplate.update(query,
			        status,new Date(),currentApprovalLevel,invoiceHeaderId);
		}
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public InvoiceApproval getInvoiceApproval(Long invoiceId, Long apprId) throws ServiceException {
		String query = env.getProperty("getInvoiceApprovalByInvoiceIdAndApproverId");
		List<InvoiceApproval> list=   jdbcTemplate.query(query, new Object[]{ invoiceId,apprId }, 
				 new BeanPropertyRowMapper<InvoiceApproval>(InvoiceApproval.class)); 
		if(list.isEmpty())
			return null;
		else 
		 return list.get(0);
	}

}
