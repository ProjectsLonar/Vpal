package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtInvoiceApprovalHistory;
import com.lonar.vendor.vendorportal.model.LtMastModuleApprovals;
import com.lonar.vendor.vendorportal.model.LtVendorApproval;
import com.lonar.vendor.vendorportal.model.LtVendorApprovalHistory;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/moduleApprovalQueries.properties", ignoreResourceNotFound = true)
public class LtMastModuleApprovalsDaoImpl implements LtMastModuleApprovalsDao{

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

	
	@Override
	public String checkforApprovals(Long vendorId) throws ServiceException 
	{
		String query = env.getProperty("checkforApprovalsForVendor");
		List<LtMastModuleApprovals> list=   jdbcTemplate.query(query, new Object[]{vendorId}, 
					 new BeanPropertyRowMapper<LtMastModuleApprovals>(LtMastModuleApprovals.class)); 
		
		if(list.isEmpty())
			return "null";
		else
		return "present";
	}


	@Override
	public boolean chkIsAprovedByAnyOne(LtVendorApprovalHistory approvalHistory) throws ServiceException
	{
		String query = env.getProperty("chkIsAprovedByAnyOne");
		
		List<LtMastModuleApprovals> ltExpModuleApprovalsList = jdbcTemplate.query(query,  new Object[] 
				{approvalHistory.getVendorApprovalId()},
				new BeanPropertyRowMapper<LtMastModuleApprovals> (LtMastModuleApprovals.class));
		
		boolean flag=false;
				
		if(!ltExpModuleApprovalsList.isEmpty() && ltExpModuleApprovalsList.size()>0)
		{
			 if(ltExpModuleApprovalsList.get(0).getApprovedByAnyone().equals("Y"))
			 { flag= true; }
		}
		else
		{	 flag= false; }
		return flag;
	}


	@Override
	public boolean chkInvoiceIsAprovedByAnyOne(LtInvoiceApprovalHistory approvalHistory) throws ServiceException {
		String query = env.getProperty("chkInvoiceIsAprovedByAnyOne");
		
		List<LtMastModuleApprovals> ltExpModuleApprovalsList = jdbcTemplate.query(query,  new Object[] 
				{approvalHistory.getInvoiceApprovalId()},
				new BeanPropertyRowMapper<LtMastModuleApprovals> (LtMastModuleApprovals.class));
		
		boolean flag=false;
				
		if(!ltExpModuleApprovalsList.isEmpty() && ltExpModuleApprovalsList.size()>0)
		{
			 if(ltExpModuleApprovalsList.get(0).getApprovedByAnyone().equals("Y"))
			 { flag= true; }
		}
		else
		{	 flag= false; }
		return flag;
	}

}
