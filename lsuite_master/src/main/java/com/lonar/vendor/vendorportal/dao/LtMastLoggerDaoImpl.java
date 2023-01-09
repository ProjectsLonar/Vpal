package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastLogger;
import com.lonar.vendor.vendorportal.model.LtMastProdSubcatPayterms;

@Component
@PropertySource(value = "classpath:queries/loggerQueries.properties", ignoreResourceNotFound = true)
public class LtMastLoggerDaoImpl implements LtMastLoggerDao{

	@Autowired
	private Environment env;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	} 
	
	@Override
	public Long getCount(LtMastLogger input) throws Exception {
		String query = env.getProperty("getCountLtMastLogger");
		 
		 String loggerId=null;
		   if(input.getLoggerId()!=null)
		   {loggerId="%"+input.getLoggerId()+"%";}
		   
		   String className=null;
		   if(input.getClassName()!=null)
		   {className="%"+input.getClassName().toUpperCase()+"%";}
		   
		   String exceptionCause=null;
		   if(input.getExceptionCause()!=null)
		   {exceptionCause="%"+input.getExceptionCause().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			
			 String message=null;
			   if(input.getMessage()!=null)
			   {message="%"+input.getMessage().toUpperCase()+"%";}
	
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {loggerId,className,message,exceptionCause,input.getStDate()}, String.class);

		
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastLogger> getLoggerRecords(LtMastLogger input) throws Exception {
		String query = env.getProperty("getLoggerRecords");
		 
		   String loggerId=null;
		   if(input.getLoggerId()!=null)
		   {loggerId="%"+input.getLoggerId()+"%";}
		   
		   String className=null;
		   if(input.getClassName()!=null)
		   {className="%"+input.getClassName().toUpperCase()+"%";}
		   
		   String exceptionCause=null;
		   if(input.getExceptionCause()!=null)
		   {exceptionCause="%"+input.getExceptionCause().toUpperCase()+"%";}
		   
		   String message=null;
		   if(input.getMessage()!=null)
		   {message="%"+input.getMessage().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			
			if(input.getColumnNo()==0) {
				input.setColumnNo(4);
			}
			List<LtMastLogger> list = (List<LtMastLogger>) 
					jdbcTemplate.query(query , new Object[]{loggerId,className, message,exceptionCause,
							input.getStDate(),							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastLogger>(LtMastLogger.class));
				return list;
	}

	@Override
	public LtMastLogger getByID(Long id) throws Exception {
		String query = env.getProperty("getLtMastLoggerByID");
		
		List<LtMastLogger> list=   jdbcTemplate.query(query, new Object[]{ id}, 
		 new BeanPropertyRowMapper<LtMastLogger>(LtMastLogger.class)); 
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

}
