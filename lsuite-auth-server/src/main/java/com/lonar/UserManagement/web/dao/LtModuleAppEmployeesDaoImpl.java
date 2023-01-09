package com.lonar.UserManagement.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.UserManagement.web.model.LtMastModuleAppEmployees;

@Component

@PropertySource(value = "classpath:queries/approverModuleQueries.properties", ignoreResourceNotFound = true)
public  class LtModuleAppEmployeesDaoImpl implements LtModuleAppEmployeesDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;

	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	@Override
	public boolean save(LtMastModuleAppEmployees ltExpenseModuleAppEmployees) throws Exception 
	{
		String query = env.getProperty("saveEmployee");
		int res=jdbcTemplate.update(/*" INSERT INTO lt_expense_module_app_employees  "
				+ " (MODULE_APPROVAL_ID,EMPLOYEES_ID,START_DATE,END_DATE, CREATED_BY, CREATION_DATE, "
				+ " LAST_UPDATE_LOGIN,LAST_UPDATED_BY,APPROVAL_ROLE_ID,LAST_UPDATE_DATE ) "
     		+ " VALUES(?,?,?,?,?,?,?,?,?,?) "*/query,
     		ltExpenseModuleAppEmployees.getModuleApprovalId(),ltExpenseModuleAppEmployees.getEmployeesId(),
     		ltExpenseModuleAppEmployees.getStartDate(),ltExpenseModuleAppEmployees.getEndDate(),
     		ltExpenseModuleAppEmployees.getCreatedBy(),ltExpenseModuleAppEmployees.getCreationDate(),
     		ltExpenseModuleAppEmployees.getLastUpdateLogin(),ltExpenseModuleAppEmployees.getLastUpdatedBy(),
     		ltExpenseModuleAppEmployees.getApprovalRoleId(),ltExpenseModuleAppEmployees.getLastUpdateDate());
		
		if(res==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean update(LtMastModuleAppEmployees ltExpenseModuleAppEmployees) throws Exception 
	{
		String query = env.getProperty("updateEmployee");
		int res=jdbcTemplate.update(/*" UPDATE lt_expense_module_app_employees SET "
				+ "  MODULE_APPROVAL_ID=?,EMPLOYEES_ID=?,START_DATE=?,END_DATE=?,  "
				+ "  LAST_UPDATE_LOGIN=?,LAST_UPDATED_BY=?,APPROVAL_ROLE_ID=?,LAST_UPDATE_DATE=? "
				+ " WHERE MODULE_APP_EMPLOYEES_ID=? "*/query,
     		ltExpenseModuleAppEmployees.getModuleApprovalId(),ltExpenseModuleAppEmployees.getEmployeesId(),
     		ltExpenseModuleAppEmployees.getStartDate(),ltExpenseModuleAppEmployees.getEndDate(),
     		ltExpenseModuleAppEmployees.getLastUpdateLogin(),ltExpenseModuleAppEmployees.getLastUpdatedBy(),
     		ltExpenseModuleAppEmployees.getApprovalRoleId(),ltExpenseModuleAppEmployees.getLastUpdateDate(),
     		ltExpenseModuleAppEmployees.getModuleAppEmployeesId());
		
		if(res==1)
			return true;
		else
			return false;
	}
	@Override
	public boolean deleteByModuleApprovalId(Long moduleApprovalId) throws Exception 
	{
		String query = env.getProperty("deleteByModuleApprovalId");
		int res=0;
		//res=jdbcTemplate.update(" DELETE FROM lt_expense_module_app_emp WHERE MODULE_APPROVAL_ID = ? ",moduleApprovalId);
		 res=jdbcTemplate.update(query,moduleApprovalId);		
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public List<LtMastModuleAppEmployees> getByModuleApprovalId(Long moduleApprovalId) throws Exception 
	{
		String query = env.getProperty("getModuleAppEmployeesByModuleApprovalId");
		
		List<LtMastModuleAppEmployees> list=   jdbcTemplate.query(query, new Object[]{ moduleApprovalId }, 
				 new BeanPropertyRowMapper<LtMastModuleAppEmployees>(LtMastModuleAppEmployees.class)); 
		 
		if(list!=null)
		return list;
		else
			return null;
	}

	@Override
	public boolean checkForDuplicate(LtMastModuleAppEmployees ltExpenseModuleAppEmployees) throws Exception {
		String query = env.getProperty("checkForDuplicateEmployee");
		List<LtMastModuleAppEmployees> list=   jdbcTemplate.query(query, new Object[]{ ltExpenseModuleAppEmployees.getModuleApprovalId(),
				ltExpenseModuleAppEmployees.getEmployeesId()}, 
				 new BeanPropertyRowMapper<LtMastModuleAppEmployees>(LtMastModuleAppEmployees.class)); 
		 
		if(list.isEmpty() )
		return true;
		else
			return false;
	}

	@Override
	public boolean deleteEmployee(Long moduleAppEmployeesId,Long moduleId) throws Exception
	{
		String query = env.getProperty("deleteEmployee");
		int res=0;
		res=jdbcTemplate.update(query,moduleAppEmployeesId,moduleId);	
		if(res!=0)
			return true;
		else
			return false;
	}

	@Override
	public LtMastModuleAppEmployees getEmployeesBymoduleEmpId(Long moduleEmpId) throws Exception {
		String query = env.getProperty("getEmployeesBymoduleEmpId");
		
		List<LtMastModuleAppEmployees> list=   jdbcTemplate.query(query, new Object[]{ moduleEmpId }, 
				 new BeanPropertyRowMapper<LtMastModuleAppEmployees>(LtMastModuleAppEmployees.class)); 
		 
		if(!list.isEmpty())
		return list.get(0);
		else
			return null;
	}

}
