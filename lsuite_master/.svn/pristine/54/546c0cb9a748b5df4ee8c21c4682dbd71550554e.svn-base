package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastPaymentTerms;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Repository
@PropertySource(value = "classpath:queries/paymentTermsQueries.properties", ignoreResourceNotFound = true)
public class LtMastPaymentTermsDaoImpl implements LtMastPaymentTermsDao{

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
	public List<LtMastPaymentTerms> getAllLtMastPaymentTerms() throws ServiceException {
		String query = env.getProperty("getAllLtMastPaymentTerms");
		List<LtMastPaymentTerms> list=   jdbcTemplate.query(query, new Object[]{ }, 
				 new BeanPropertyRowMapper<LtMastPaymentTerms>(LtMastPaymentTerms.class)); 
		return list;
	}

	@Override
	public List<LtMastPaymentTerms> findAllActive(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllActiveLtMastPaymentTerms");
		List<LtMastPaymentTerms> list=   jdbcTemplate.query(query, new Object[]{companyId }, 
				 new BeanPropertyRowMapper<LtMastPaymentTerms>(LtMastPaymentTerms.class)); 
		return list;
	}

	@Override
	public List<LtMastPaymentTerms> getAllActiveByPaytermId(Long id) throws ServiceException {
		String query = env.getProperty("getAllLtMastPaymentTerms");
		List<LtMastPaymentTerms> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtMastPaymentTerms>(LtMastPaymentTerms.class)); 
		return list;
	}

	@Override
	public LtMastPaymentTerms getByID(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastPaymentTermsById");
		List<LtMastPaymentTerms> list=   jdbcTemplate.query(query, new Object[]{id }, 
				 new BeanPropertyRowMapper<LtMastPaymentTerms>(LtMastPaymentTerms.class));
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

	@Override
	public Long getCount(Long companyId,LtMastPaymentTerms input) throws ServiceException {
		String query = env.getProperty("getCountLtMastPaymentTerms");
		 
		 String termName=null;
		   if(input.getTermName()!=null)
		   {termName="%"+input.getTermName().toUpperCase()+"%";}
		   
		   String days=null;
		   if(input.getNoDay()!=null)
		   {days="%"+Double.valueOf(input.getNoDay()).intValue()+"%";}
		   
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		   
			
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,termName,days,
						input.getStDate(),input.getEnDate()}, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastPaymentTerms> getDatatableRecords(Long companyId,LtMastPaymentTerms input) throws ServiceException {
		String query = env.getProperty("getLtMastPaymentTermsRecords");
		 
		 String termName=null;
		   if(input.getTermName()!=null && !input.getTermName().equals(""))
		   {termName="%"+input.getTermName().toUpperCase()+"%";}
		   
		  /* String expAmount=null;
		   if(input.getExpenseAmount()!=null)
		   {expAmount="%"+Double.valueOf(input.getExpenseAmount()).intValue()+"%";}*/
		   
		   String days=null;
		   if(input.getNoDay()!=null)
		   {days="%"+Double.valueOf(input.getNoDay()).intValue()+"%";}
		   
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		   
			List<LtMastPaymentTerms> list = (List<LtMastPaymentTerms>) 
					jdbcTemplate.query(query , new Object[]{companyId,termName,days,
							input.getStDate(),input.getEnDate(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastPaymentTerms>(LtMastPaymentTerms.class));
				return list;
	}

}
