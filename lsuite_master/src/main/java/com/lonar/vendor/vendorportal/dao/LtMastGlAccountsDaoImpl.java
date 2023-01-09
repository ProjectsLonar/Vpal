package com.lonar.vendor.vendorportal.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastGlAccounts;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.reports.ReportParameters;

@Component
@PropertySource(value = "classpath:queries/glAccountsMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastGlAccountsDaoImpl implements LtMastGlAccountsDao {


	@Autowired
	private Environment env;
	
	@PersistenceContext(name = "em")
	private EntityManager em;

	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<LtMastGlAccounts> findByAccountCode(String accountCode,Long companyId) throws ServiceException{
		String query = env.getProperty("findByAccountCode");
		List<LtMastGlAccounts> list = (List<LtMastGlAccounts>) 
				 jdbcTemplate.query(query , new Object[]{accountCode.toUpperCase().trim() ,companyId},
						 new  BeanPropertyRowMapper<LtMastGlAccounts>(LtMastGlAccounts.class));
		return list;
	}

	@Override
	public List<LtMastGlAccounts> findByAccountName(String accountName,Long companyId) throws ServiceException{
		String query = env.getProperty("findByAccountName");
		List<LtMastGlAccounts> list = (List<LtMastGlAccounts>) 
				 jdbcTemplate.query(query , new Object[]{accountName.toUpperCase(),companyId },
						 new  BeanPropertyRowMapper<LtMastGlAccounts>(LtMastGlAccounts.class));
		return list;
	}

	@Override
	public List<LtMastGlAccounts> findAllActive(Long companyId) throws ServiceException{
		String query = env.getProperty("findAllActiveGlAccounts");
		List<LtMastGlAccounts> list = (List<LtMastGlAccounts>) 
				 jdbcTemplate.query(query , new Object[]{ companyId},
						 new  BeanPropertyRowMapper<LtMastGlAccounts>(LtMastGlAccounts.class));
		return list;
	}

	@Override
	public List<LtMastGlAccounts> findActiveLikeAccountName(String accountName,Long companyId) throws ServiceException{
		String query = env.getProperty("findActiveGlAccountsLikeAccountName");
		
		List<LtMastGlAccounts> reportList =  jdbcTemplate.query(query, new Object[]{ "%"+accountName+"%",companyId }, 
				 new RowMapper<LtMastGlAccounts>() {
			 			public LtMastGlAccounts mapRow(ResultSet rs, int row) throws SQLException {
			 				LtMastGlAccounts glAccount = new LtMastGlAccounts();
			 				 glAccount.setGlAccountId(rs.getLong("GL_ACCOUNT_ID"));
			 				 glAccount.setAccountCode(rs.getString("ACCOUNT_CODE"));
			 				 glAccount.setAccountName(rs.getString("ACCOUNT_NAME"));
							return glAccount;
						}
		  });
		return reportList;
	}

	@Override
	public List<LtMastGlAccounts> findLikeAccountName(String accountName,Long companyId) throws ServiceException{
		String query = env.getProperty("findGlAccountsLikeAccountName");
		List<LtMastGlAccounts> list = (List<LtMastGlAccounts>) 
				 jdbcTemplate.query(query , new Object[]{"%"+accountName.toUpperCase()+"%" ,companyId},
						 new  BeanPropertyRowMapper<LtMastGlAccounts>(LtMastGlAccounts.class));
		return list;
	}

	@Override
	public List<LtMastGlAccounts> findAll(Long companyId) throws ServiceException {
		String query = env.getProperty("findAllLtMastGlAccounts");
		List<LtMastGlAccounts> list = (List<LtMastGlAccounts>) 
				 jdbcTemplate.query(query , new Object[]{companyId },
						 new  BeanPropertyRowMapper<LtMastGlAccounts>(LtMastGlAccounts.class));
		return list;
	}

	@Override
	public LtMastGlAccounts getLtMastGlAccountsByID(Long id) throws ServiceException {
		String query = env.getProperty("getLtMastGlAccountsByID");
		List<LtMastGlAccounts> list = (List<LtMastGlAccounts>) 
				 jdbcTemplate.query(query , new Object[]{ id},
						 new  BeanPropertyRowMapper<LtMastGlAccounts>(LtMastGlAccounts.class));
		return list.get(0);
	}

	@Override
	public Long getCount(Long companyId,LtMastGlAccounts input) throws ServiceException {
		String query = env.getProperty("getCountGlAccounts");
		 
		   String accCode=null;
		   if(input.getAccountCode()!=null)
		   {accCode="%"+input.getAccountCode().toUpperCase()+"%";}
		   
		   String accName=null;
		   if(input.getAccountName()!=null)
		   {accName="%"+input.getAccountName().toUpperCase()+"%";}
		   
		   String accType=null;
		   if(input.getAccountType()!=null)
		   {accType="%"+input.getAccountType().toUpperCase()+"%";}
		   
		  
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId,accCode,accName,accType,
						input.getStDate(),input.getEnDate() }, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastGlAccounts> getDatatableRecords(Long companyId,LtMastGlAccounts input) throws ServiceException {
		String query = env.getProperty("getGlAccountsDatatableRecords");
		 
		 String accCode=null;
		   if(input.getAccountCode()!=null)
		   {accCode="%"+input.getAccountCode().toUpperCase()+"%";}
		   
		   String accName=null;
		   if(input.getAccountName()!=null)
		   {accName="%"+input.getAccountName().toUpperCase()+"%";}
		   
		   String accType=null;
		   if(input.getAccountType()!=null)
		   {accType="%"+input.getAccountType().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			
			
			List<LtMastGlAccounts> list = (List<LtMastGlAccounts>) 
					jdbcTemplate.query(query , new Object[]{companyId,accCode,accName,accType,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastGlAccounts>(LtMastGlAccounts.class));
				return list;
	}

	@Override
	public List<LtMastGlAccounts> getDataForReport(ReportParameters reportParameters) throws ServiceException {
		String query = env.getProperty("getLtMastGlAccountsDataForReport");
		List<LtMastGlAccounts> list = (List<LtMastGlAccounts>) 
				 jdbcTemplate.query(query , new Object[]{reportParameters.getStatus().toUpperCase(),
							reportParameters.getStartDate(),reportParameters.getEndDate() ,reportParameters.getCompanyId()},
						 new  BeanPropertyRowMapper<LtMastGlAccounts>(LtMastGlAccounts.class));
		return list;
	}

	

}
