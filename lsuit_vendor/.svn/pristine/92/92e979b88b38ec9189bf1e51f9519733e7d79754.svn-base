package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastEmailtoken;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastEmailtokenRepository;

@Repository
public class LtMastEmailtokenDaoImpl implements LtMastEmailtokenDao
{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	} 
	
	@Autowired
	LtMastEmailtokenRepository ltMastEmailtokenRepository;
	
	
	@Override
	public Long makeEntryInEmailToken(LtMastEmailtoken ltMastEmailtoken) throws ServiceException 
	{
		LtMastEmailtoken emailtoken =ltMastEmailtokenRepository.save(ltMastEmailtoken);
		return emailtoken.getEmailTokenId();
		
	}

	@Override
	public List<LtMastEmailtoken> findAllActive() throws ServiceException 
	{
		//String sqlQuery = env.getProperty("findAllActive");
		String query = "SELECT * FROM lt_mast_emailtoken e " + 
				" WHERE (e.EMAIL_STATUS = 'SENDING' OR e.EMAIL_STATUS = 'Fail to Send') " + 
				" AND (e.FAILURECOUNT IS NULL OR e.FAILURECOUNT <=5) ";
		
		List<LtMastEmailtoken> list=   jdbcTemplate.query(query, new Object[]{ }, 
				 new BeanPropertyRowMapper<LtMastEmailtoken>(LtMastEmailtoken.class)); 
		
		return list;
	}

	@Override
	public void updateStatus(Long emailTokenId, String status, Integer count) throws ServiceException {
		String sqlQuery = " UPDATE lt_mast_emailtoken SET EMAIL_STATUS= ?, FAILURECOUNT= ( nvl2(FAILURECOUNT,FAILURECOUNT + ?, 1) ) where EMAIL_TOKEN_ID = ? ";
		int res=jdbcTemplate.update(sqlQuery,status, count , emailTokenId );
		
	}

}
