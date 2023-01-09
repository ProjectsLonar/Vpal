package com.lonar.vendor.vendorportal.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.vendor.vendorportal.model.LtMastSysVariableValues;
import com.lonar.vendor.vendorportal.model.LtMastSysVariables;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.model.SysVariableWithValues;


@Component
@PropertySource(value= "classpath:queries/systemVariableQueries.properties",ignoreResourceNotFound = true)
public class LtMastSysVariablesDaoImpl implements LtMastSysVariablesDao
{
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
	
	@Transactional
	@Override
	public List<SysVariableWithValues> getBySysVariableName(String name,Long companyId) throws ServiceException 
	{
		//String query = env.getProperty("getBySysVariableName");
		
		String query ="select lmsv.Variable_Code , lmsv.Variable_Name ,lmsvv.User_id , "
				+ " case when lmsvv.User_Value is null then  lmsv.system_Value "
				+ " ELSE lmsvv.User_Value END Value "
				+ " from lt_mast_sys_variables lmsv ,  lt_mast_sys_variable_values lmsvv  "
				+ " WHERE lmsv.variable_id=lmsvv.variable_Id "
				+ " AND( SYSDATE >=lmsv.start_date ) "
				+ " AND ((SYSDATE < lmsv.end_date) or (lmsv.end_date is null) ) "
				+ " AND (SYSDATE >=lmsvv.start_date )  "
				+ " AND ((SYSDATE < lmsvv.end_date ) or (lmsvv.end_date  is null) )	 "
				+ " AND lmsv.Variable_Name=? AND lmsv.COMPANY_ID = ? ";
		
		
		/*List<LtMastSysVariables> list=   jdbcTemplate.query(query, new Object[]{name.trim().toUpperCase()}, 
					 new BeanPropertyRowMapper<LtMastSysVariables>(LtMastSysVariables.class)); 
		 if(!list.isEmpty())
		 {
			 List<SysVariableWithValues> sysVariableWithValues = new ArrayList<SysVariableWithValues>();
				
				LtMastSysVariables ltMastSysVariables=new LtMastSysVariables();
				LtMastSysVariableValues ltMastSysVariableValues=new LtMastSysVariableValues();
			
				
				ltMastSysVariables.setVariableCode(list.get(0).getVariableCode());
				
				ltMastSysVariables.setVariableName(list.get(0).getVariableName());
				//ltMastSysVariableValues.setUserId(list.get(0).getu);
				ltMastSysVariableValues.setUserValue(list.get(0).getSystemValue());

				List<LtMastSysVariableValues> list1=new ArrayList<LtMastSysVariableValues>();
				list1.add(ltMastSysVariableValues);
				
				sysVariableWithValues.get(0).setLtMastSysVariables(ltMastSysVariables);
				sysVariableWithValues.get(0).setLtMastSysVariableValues(list1);
				
				return sysVariableWithValues;
		 }
		 
		 return null;*/
		return   jdbcTemplate.query(query,new Object[]{name.trim().toUpperCase(),companyId }, 
				 new RowMapper<SysVariableWithValues>()
		{
					@Override
					public SysVariableWithValues mapRow(ResultSet rs, int row) throws SQLException 
					{
						SysVariableWithValues sysVariableWithValues = new SysVariableWithValues();
						
						LtMastSysVariables ltMastSysVariables=new LtMastSysVariables();
						LtMastSysVariableValues ltMastSysVariableValues=new LtMastSysVariableValues();
					
						
						ltMastSysVariables.setVariableCode(rs.getString("VARIABLE_CODE"));
						
						ltMastSysVariables.setVariableName(rs.getString("VARIABLE_NAME"));
						ltMastSysVariableValues.setUserId(rs.getString("User_id"));
						ltMastSysVariableValues.setUserValue(rs.getString("Value"));
		
						List<LtMastSysVariableValues> list=new ArrayList<LtMastSysVariableValues>();
						list.add(ltMastSysVariableValues);
						
						sysVariableWithValues.setLtMastSysVariables(ltMastSysVariables);
						sysVariableWithValues.setLtMastSysVariableValues(list);
						
						return sysVariableWithValues;
					}
		});
	}
	
	
	
	@Override
	public LtMastSysVariables getByName(LtMastSysVariables ltMastSysVariables) throws ServiceException 
	{
		String query = env.getProperty("getLtMastSysVariablesByName");
		List<LtMastSysVariables> list=   jdbcTemplate.query(query, new Object[]{
				ltMastSysVariables.getVariableName().toUpperCase()}, 
					 new BeanPropertyRowMapper<LtMastSysVariables>(LtMastSysVariables.class)); 
		 if(list.size()>0)
		return list.get(0);
		 else
			 return null;
	}
	
	@Override
	public LtMastSysVariables getByCode(LtMastSysVariables ltMastSysVariables) throws ServiceException 
	{
		String query = env.getProperty("getLtMastSysVariablesByCode");
		List<LtMastSysVariables> list=   jdbcTemplate.query(query, new Object[]{
				ltMastSysVariables.getVariableCode().toUpperCase()}, 
					 new BeanPropertyRowMapper<LtMastSysVariables>(LtMastSysVariables.class)); 
		
		 if(list.size()>0)
		return list.get(0);
		 else
			 return null;
	}

	@Override
	public Long getCount(LtMastSysVariables input) throws Exception 
	{
		String query = env.getProperty("getLtMastSysVariablesCount");
		
		String variableCode = null;
		if(input.getVariableCode()!=null && !input.getVariableCode().equals(""))
		{ variableCode="%"+input.getVariableCode().toUpperCase()+"%";}
		 
		 String variableName = null;
		 if(input.getVariableName()!=null && !input.getVariableName().equals(""))
		 { variableName="%"+input.getVariableName().toUpperCase()+"%";}
		   
		 String sysValue=null;
		 if(input.getSystemValue()!=null && !input.getSystemValue().equals(""))
		 {sysValue="%"+input.getSystemValue().toUpperCase()+"%";}
		   
			
		   if(input.getStDate() == null || input.getStDate().trim().equals(""))
		   {input.setStDate(null);}
		   
		   if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
		   {input.setEnDate(null);}
		   
		   String count  = (String)getJdbcTemplate().queryForObject(
					query, new Object[] {variableCode,variableName,sysValue,
							input.getStDate(),input.getEnDate()}, String.class);
		
			return Long.parseLong(count);
	}

	@Override
	public List<LtMastSysVariables> getDatatableRecords(LtMastSysVariables input) throws Exception 
	{
			String query = env.getProperty("getLtMastSysVariablesDataTableRecords");
		
			String variableCode = null;
			if(input.getVariableCode()!=null && !input.getVariableCode().equals(""))
			{ variableCode="%"+input.getVariableCode().toUpperCase()+"%";}
			 
			 String variableName = null;
			 if(input.getVariableName()!=null && !input.getVariableName().equals(""))
			 { variableName="%"+input.getVariableName().toUpperCase()+"%";}
			   
			 String sysValue=null;
			 if(input.getSystemValue()!=null && !input.getSystemValue().equals(""))
			 {sysValue="%"+input.getSystemValue().toUpperCase()+"%";}
			   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{input.setStDate(null);}
			   
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{input.setEnDate(null);}
		
		   if(input.getColumnNo()==0)
		   {
			   input.setColumnNo(8);
		   }
		   
		   return jdbcTemplate.query(query, new Object[] { variableCode,variableName,sysValue,
					input.getStDate(),input.getEnDate(),
					
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					input.getColumnNo(),input.getColumnNo(),
					
					input.getStart()+input.getLength(),input.getStart()+1},

			new RowMapper<LtMastSysVariables>() {
				@Override
				public LtMastSysVariables mapRow(ResultSet rs, int row) throws SQLException {
					LtMastSysVariables ltMastSysVariables = new LtMastSysVariables();
					ltMastSysVariables.setVariableId(rs.getLong("VARIABLE_ID"));
					ltMastSysVariables.setVariableCode(rs.getString("VARIABLE_CODE"));
					ltMastSysVariables.setVariableName(rs.getString("VARIABLE_NAME"));
					ltMastSysVariables.setSystemValue(rs.getString("SYSTEM_VALUE"));
					ltMastSysVariables.setStartDate(rs.getDate("START_DATE"));
					ltMastSysVariables.setEndDate(rs.getDate("END_DATE"));
					return ltMastSysVariables;
					
				}
		   	});
	}

	@Override
	public List<LtMastSysVariables> getSysvariableProperties() throws ServiceException {
		String query = env.getProperty("getSysvariableProperties");
		List<LtMastSysVariables> list=   jdbcTemplate.query(query, new Object[]{}, 
					 new BeanPropertyRowMapper<LtMastSysVariables>(LtMastSysVariables.class)); 
		
		return list;
	}
	

}
