package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.CodeMaster;
import com.lonar.vendor.vendorportal.model.InvoiceApproval;
import com.lonar.vendor.vendorportal.model.VendorApproval;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/vendorInboxQueries.properties", ignoreResourceNotFound = true)
public class LtVendorInboxDaoImpl implements LtVendorInboxDao,CodeMaster {

	@Autowired
	private Environment env;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	} 
	
	@Override
	public Long getCount(String status1, String approvalId, VendorApproval input) throws ServiceException {
		String query = env.getProperty("getVendorCountInbox");
		
		
		String vendorName=null;
		if(input.getVendorName()!=null && !input.getVendorName().equals(""))
		{
			vendorName="%"+input.getVendorName().trim().toUpperCase()+"%";
		}
		String status2=null;
		if(input.getStatus()!=null && !input.getStatus().equals(""))
		{
			status2="%"+input.getStatus().trim().toUpperCase()+"%";
		}
		String initiatorName=null;
		if(input.getInitiatorName()!=null && !input.getInitiatorName().equals(""))
		{
			initiatorName="%"+input.getInitiatorName().trim().toUpperCase()+"%";
		}
		
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] { status1,APPROVED, approvalId,approvalId, vendorName,
						initiatorName,status2}, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<VendorApproval> getByStatus(String status1, String approvalId, VendorApproval input)
			throws ServiceException {
		String vendorName=null;
		if(input.getVendorName()!=null && !input.getVendorName().equals(""))
		{
			vendorName="%"+input.getVendorName().trim().toUpperCase()+"%";
		}
		String status2=null;
		if(input.getStatus()!=null && !input.getStatus().equals(""))
		{
			status2="%"+input.getStatus().trim().toUpperCase()+"%";
		}
		String initiatorName=null;
		if(input.getInitiatorName()!=null && !input.getInitiatorName().equals(""))
		{
			initiatorName="%"+input.getInitiatorName().trim().toUpperCase()+"%";
		}
		
		if(input.getSort()==null)
		{
			input.setSort("desc");
		}
		
		
		String query = env.getProperty("getVendorInbox");
		
		return (List<VendorApproval>) 
				jdbcTemplate.query(query , new Object[]{ status1,APPROVED, approvalId,approvalId, vendorName,
						initiatorName,status2,
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),	
						
						(input.getStart()+input.getLength()),input.getStart()+1  },
			 new  BeanPropertyRowMapper<VendorApproval>(VendorApproval.class));
	}

	@Override
	public List<VendorApproval> getVendorApprovalNotification(String status, Long empId) throws ServiceException {
	String query = env.getProperty("getNotification");
		
		return (List<VendorApproval>) 
				jdbcTemplate.query(query , new Object[]{ status,  empId ,empId,status,  empId ,empId,status,  empId ,empId},
			 new  BeanPropertyRowMapper<VendorApproval>(VendorApproval.class));
	}

	@Override
	public Long getInvoiceCount(String status1, String approvalId, InvoiceApproval input) throws ServiceException {
		String query = env.getProperty("getInvoiceCountInbox");
		
		String invoiceNum=null;
		if(input.getInvoiceNum()!=null && !input.getInvoiceNum().equals(""))
		{
			invoiceNum="%"+input.getInvoiceNum().trim().toUpperCase()+"%";
		}
		
		String status2=null;
		if(input.getStatus()!=null && !input.getStatus().equals(""))
		{
			status2="%"+input.getStatus().trim().toUpperCase()+"%";
		}
		String initiatorName=null;
		if(input.getInitiatorName()!=null && !input.getInitiatorName().equals(""))
		{
			initiatorName="%"+input.getInitiatorName().trim().toUpperCase()+"%";
		}else {
			initiatorName="%"+"%";
		}
		
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] { status1,INVOICE_APPROVED, approvalId,approvalId,status2, invoiceNum,
						  initiatorName}, String.class);

		return Long.parseLong(count);
	}

	@Override
	public List<InvoiceApproval> getInvoiceByStatus(String status1, String approvalId, InvoiceApproval input)
			throws ServiceException {
		String invoiceNum=null;
		if(input.getInvoiceNum()!=null && !input.getInvoiceNum().equals(""))
		{
			invoiceNum="%"+input.getInvoiceNum().trim().toUpperCase()+"%";
		}
		String status2=null;
		if(input.getStatus()!=null && !input.getStatus().equals(""))
		{
			status2="%"+input.getStatus().trim().toUpperCase()+"%";
		}
		String initiatorName=null;
		if(input.getInitiatorName()!=null && !input.getInitiatorName().equals(""))
		{
			initiatorName="%"+input.getInitiatorName().trim().toUpperCase()+"%";
		}else {
			initiatorName="%"+"%";
		}
		
		if(input.getSort()==null)
		{
			input.setSort("desc");
		}
		
		
		String query = env.getProperty("getInvoiceInbox");
		
		return (List<InvoiceApproval>) 
				jdbcTemplate.query(query , new Object[]{ status1,INVOICE_APPROVED, approvalId,approvalId,status2, invoiceNum,
						  initiatorName,
						input.getColumnNo(),input.getColumnNo(),	
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),
						input.getColumnNo(),input.getColumnNo(),	
						
						(input.getStart()+input.getLength()),input.getStart()+1  },
			 new  BeanPropertyRowMapper<InvoiceApproval>(InvoiceApproval.class));
	}

}
