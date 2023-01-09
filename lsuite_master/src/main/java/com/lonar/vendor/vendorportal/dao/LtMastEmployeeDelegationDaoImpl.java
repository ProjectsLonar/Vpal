package com.lonar.vendor.vendorportal.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.model.LtMastEmployeeDelegation;

@Component
@PropertySource(value = "classpath:queries/employeeDelegationQueries.properties", ignoreResourceNotFound = true)
public class LtMastEmployeeDelegationDaoImpl implements LtMastEmployeeDelegationDao {

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
	
	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByEmployeeId(Long employeeId) throws Exception {
		
		String query = env.getProperty("findByEmployeeId");
		List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
				 jdbcTemplate.query(query , new Object[]{ employeeId},
						 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
		
		return list;
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findEmployeeBetween(Long employeeId, Date startDate, Date endDate)
			throws Exception 
	{
		String query = env.getProperty("findEmployeeBetween");
		List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
				 jdbcTemplate.query(query , new Object[]{ employeeId,  endDate ,startDate},
						 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
		
		return list;
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findDelegationBetween(Long delegationId, Date startDate, Date endDate)
			throws Exception 
	{
			String query = env.getProperty("findDelegationBetween");
			List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
					 jdbcTemplate.query(query , new Object[]{ delegationId, startDate, endDate },
							 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
			
			return list;
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByDelegationId(Long delegationId) throws Exception
	{
		String query = env.getProperty("findByDelegationId");
	
			List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
			 jdbcTemplate.query(query , new Object[]{ delegationId },
					 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
	
			return list;
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findForDelegation(Long employeeId) throws Exception 
	{
		String query = env.getProperty("findForDelegation");
			
		List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
					 jdbcTemplate.query(query , new Object[]{ employeeId },
							 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
			
			return list;
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByEmployeeIdOrderByEmployeeDelegationId(Long employeeId) throws Exception 
	{
		String query = env.getProperty("findByEmployeeIdOrderByEmployeeDelegationId");
		
		List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
			 jdbcTemplate.query(query , new Object[]{ employeeId },
					 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
	
		return list;
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findByDelegationIdOrderByEmployeeDelegationId(Long delegationId)
			throws Exception 
	{
		String query = env.getProperty("findByDelegationIdOrderByEmployeeDelegationId");
		
		List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
			 jdbcTemplate.query(query , new Object[]{ delegationId },
					 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
	
		return list;
	}

	@Transactional
	@Override
	public List<LtMastEmployeeDelegation> findForEmployee(Long delegationId) throws Exception {
		
		String query = env.getProperty("findForEmployee");
	
		List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
			 jdbcTemplate.query(query , new Object[]{ delegationId },
					 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
	
		return list;
	}

	@Override
	public void updateDelegation(Long employeeId,Long delegationId) throws Exception 
	{
		//String query = env.getProperty("updateEmployeesPath");
		int res=0;
		res=jdbcTemplate.update(" UPDATE LT_EXPENSE_APPROVAL SET DELEGATION_ID =? "
				+ "  WHERE APPROVAL_ID =? ",delegationId,employeeId);
	}

	@Override
	public List<LtMastEmployeeDelegation> getByCreatedBy(Long userId) throws Exception {
		String query = env.getProperty("getByCreatedBy");
		
		List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
		 jdbcTemplate.query(query , new Object[]{ userId },
				 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));

		return list;
	}

	@Override
	public List<LtMastEmployeeDelegation> getThirdPartyEmployeeDelegationDataTable(LtMastEmployeeDelegation input)
			throws Exception {
		String query = env.getProperty("getThirdPartyEmployeeDelegationDataTable");
		
			String empName=null;
		   if(input.getEmployeeName()!=null && !input.getEmployeeName().equals(""))
		   {empName="%"+input.getEmployeeName().trim().toUpperCase()+"%";}
		   
		   String delName=null;
		   if(input.getDelegationName()!=null && !input.getDelegationName().equals(""))
		   {delName="%"+input.getDelegationName().trim().toUpperCase()+"%";}
		  
		   String delByName=null;
		   if(input.getDelegatedByName()!=null && !input.getDelegatedByName().equals(""))
		   {delByName="%"+input.getDelegatedByName().trim().toUpperCase()+"%";}
			
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
		   {input.setStDate(null);}
		   
		   if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		   {input.setEnDate(null);}
		   
		   if(input.getColumnNo()==0)
		   {
			   input.setColumnNo(8);
		   }
		List<LtMastEmployeeDelegation> list=   jdbcTemplate.query(query, new Object[]{delByName, delName,empName,
				input.getStDate(),input.getEnDate(),
				input.getColumnNo(),input.getColumnNo(),
				input.getColumnNo(),input.getColumnNo(),
				input.getColumnNo(),input.getColumnNo(),
				input.getColumnNo(),input.getColumnNo(),
				input.getColumnNo(),input.getColumnNo(),
				input.getColumnNo(),input.getColumnNo(),
				input.getStart()+input.getLength(),input.getStart()+1}, 
					 new BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class)); 
		 
		return list;
	}

	@Override
	public Long getThirdPartyCount(LtMastEmployeeDelegation input) throws Exception {
		String query = env.getProperty("getThirdPartyLtMastEmployeeDelegationCount");
		String empName=null;
		   if(input.getEmployeeName()!=null && !input.getEmployeeName().equals(""))
		   {empName="%"+input.getEmployeeName().trim().toUpperCase()+"%";}
		   
		   String delName=null;
		   if(input.getDelegationName()!=null && !input.getDelegationName().equals(""))
		   {delName="%"+input.getDelegationName().trim().toUpperCase()+"%";}
		  
		   String delByName=null;
		   if(input.getDelegatedByName()!=null && !input.getDelegatedByName().equals(""))
		   {delByName="%"+input.getDelegatedByName().trim().toUpperCase()+"%";}
			
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
		   {input.setStDate(null);}
		   
		   if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		   {input.setEnDate(null);}
		   
		   
		   String count  = (String)getJdbcTemplate().queryForObject(
					query, new Object[] {delByName,delName,empName,input.getStDate(),input.getEnDate()}, String.class);
		
			return Long.parseLong(count);
	}

	@Override
	public Long getCount(LtMastEmployeeDelegation input) throws Exception {
		String query = env.getProperty("getLtMastEmployeeDelegationCount");
		String empName=null;
		   if(input.getEmployeeName()!=null && !input.getEmployeeName().equals(""))
		   {empName="%"+input.getEmployeeName().trim().toUpperCase()+"%";}
		   
		   String delName=null;
		   if(input.getDelegationName()!=null && !input.getDelegationName().equals(""))
		   {delName="%"+input.getDelegationName().trim().toUpperCase()+"%";}
		  
		   String delByName=null;
		   if(input.getDelegatedByName()!=null && !input.getDelegatedByName().equals(""))
		   {delByName="%"+input.getDelegatedByName().trim().toUpperCase()+"%";}
			
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
		   {input.setStDate(null);}
		   
		   if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		   {input.setEnDate(null);}
		   
		   
		   String count  = (String)getJdbcTemplate().queryForObject(
					query, new Object[] {input.getEmployeeId(), empName,delName,input.getStDate(),input.getEnDate(),
							}, String.class);
		
			return Long.parseLong(count);
		
	}

	@Override
	public List<LtMastEmployeeDelegation> getEmployeeDelegationDataTable(LtMastEmployeeDelegation input)
			throws Exception {
		String query = env.getProperty("getEmployeeDelegationDataTable");
		
		String empName=null;
	   if(input.getEmployeeName()!=null && !input.getEmployeeName().equals(""))
	   {empName="%"+input.getEmployeeName().trim().toUpperCase()+"%";}
	   
	   String delName=null;
	   if(input.getDelegationName()!=null && !input.getDelegationName().equals(""))
	   {delName="%"+input.getDelegationName().trim().toUpperCase()+"%";}
	  
	 
		
	   if(input.getStDate() == null || input.getStDate().trim().equals(""))
	   {input.setStDate(null);}
	   
	   if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
	   {input.setEnDate(null);}
	   
	   if(input.getColumnNo()==0)
	   {
		   input.setColumnNo(8);
	   }
	List<LtMastEmployeeDelegation> list=   jdbcTemplate.query(query, new Object[]{input.getEmployeeId(), empName,delName,
			input.getStDate(),input.getEnDate(),
			
			input.getColumnNo(),input.getColumnNo(),
			input.getColumnNo(),input.getColumnNo(),
			input.getColumnNo(),input.getColumnNo(),
			input.getColumnNo(),input.getColumnNo(),
			input.getColumnNo(),input.getColumnNo(),
			input.getStart()+input.getLength(),input.getStart()+1}, 
				 new BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class)); 
	 
	return list;
	
	}

	@Override
	public LtMastEmployeeDelegation checkDelegateeAvailability(LtMastEmployeeDelegation ltMastEmployeeDelegation)
			throws Exception {
		String query = env.getProperty("checkDelegateeAvailability");
		
		List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
			 jdbcTemplate.query(query , new Object[]{ ltMastEmployeeDelegation.getDelegationId(),
					 ltMastEmployeeDelegation.getStartDate1(), ltMastEmployeeDelegation.getEndDate1(), 
					 ltMastEmployeeDelegation.getStartDate1(), ltMastEmployeeDelegation.getEndDate1()},
					 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public LtMastEmployeeDelegation checkEmpDelegation(LtMastEmployeeDelegation ltMastEmployeeDelegation)
			throws Exception {
		
		String query = env.getProperty("checkEmpDelegation");
		
		
		List<LtMastEmployeeDelegation> list = (List<LtMastEmployeeDelegation>) 
			 jdbcTemplate.query(query , new Object[]{ ltMastEmployeeDelegation.getEmployeeId(),
					 ltMastEmployeeDelegation.getStartDate1(), ltMastEmployeeDelegation.getEndDate1(),
					 ltMastEmployeeDelegation.getStartDate1(), ltMastEmployeeDelegation.getEndDate1(),
					 ltMastEmployeeDelegation.getEndDate1(), ltMastEmployeeDelegation.getEmployeeId(),ltMastEmployeeDelegation.getEmployeeId()},
					 new  BeanPropertyRowMapper<LtMastEmployeeDelegation>(LtMastEmployeeDelegation.class));
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

}
