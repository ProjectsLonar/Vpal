package com.lonar.vendor.vendorportal.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.vendor.vendorportal.model.LtMastSysVariableValues;
import com.lonar.vendor.vendorportal.model.ServiceException;

@Component
@PropertySource(value= "classpath:queries/systemVariableQueries.properties",ignoreResourceNotFound = true)
public class LtMastSysVariableValuesDaoImpl implements  LtMastSysVariableValuesDao
{
	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<LtMastSysVariableValues> getByVariableId(Long id) throws ServiceException 
	{
		String query = env.getProperty("getByVariableId");
			//String query = " SELECT * FROM LT_MAST_SYS_VARIABLE_VALUES s WHERE s.VARIABLE_ID = ? ";
			
			List<LtMastSysVariableValues> list=   jdbcTemplate.query(query, new Object[]{ id }, 
					 new BeanPropertyRowMapper<LtMastSysVariableValues>(LtMastSysVariableValues.class)); 
			 
			return list;
	}


	@Override
	public LtMastSysVariableValues getBySysVariableValuesId(Long id) throws ServiceException {
		String query = env.getProperty("getBySysVariableValuesId");
		
		List<LtMastSysVariableValues> list=   jdbcTemplate.query(query, new Object[]{ id }, 
				 new BeanPropertyRowMapper<LtMastSysVariableValues>(LtMastSysVariableValues.class)); 
		 if(!list.isEmpty())
		return list.get(0);
		 else return null;
	}

}
