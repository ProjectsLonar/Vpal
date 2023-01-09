package com.lonar.UserManagement.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.UserManagement.web.model.LtMastSysVariableValues;

@Component
@PropertySource(value= "classpath:systemVariableQueries.properties",ignoreResourceNotFound = true)
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
	public List<LtMastSysVariableValues> getByVariableId(Long id) throws Exception 
	{
		String query = env.getProperty("getByVariableId");
			//String query = " SELECT * FROM LT_MAST_SYS_VARIABLE_VALUES s WHERE s.VARIABLE_ID = ? ";
			
			List<LtMastSysVariableValues> list=   jdbcTemplate.query(query, new Object[]{ id }, 
					 new BeanPropertyRowMapper<LtMastSysVariableValues>(LtMastSysVariableValues.class)); 
			 
			return list;
	}

}
