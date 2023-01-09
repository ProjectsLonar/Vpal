package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastDepartments;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastDepartmentsRepository;

@Repository
@PropertySource(value = "classpath:queries/departmentMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastDepartmentsDaoImpl implements LtMastDepartmentsDao{

	@Autowired
	LtMastDepartmentsRepository	ltMastDepartmentsRepository;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Environment env;
	
	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 
	
	@Override
	public Long getCount(LtMastDepartments input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastDepartments");
		 
		 String code=null;
		   if(input.getDepartmentCode()!=null)
		   {code="%"+input.getDepartmentCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getDepartmentName()!=null)
		   {name="%"+input.getDepartmentName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getDepartmentDesc()!=null)
		   {desc="%"+input.getDepartmentDesc().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] {companyId, code,name,desc,status,input.getStDate(),input.getEnDate() }, String.class);
		return Long.parseLong(count);
	}

	@Override
	public List<LtMastDepartments> getDataTable(LtMastDepartments input, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastDepartmentsDatatableRecords");
		 
		 String code=null;
		   if(input.getDepartmentCode()!=null)
		   {code="%"+input.getDepartmentCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getDepartmentName()!=null)
		   {name="%"+input.getDepartmentName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getDepartmentDesc()!=null)
		   {desc="%"+input.getDepartmentDesc().toUpperCase()+"%";}
		   
		   String status=null;
		   if(input.getStatus()!=null) 
		   {status="%"+input.getStatus().toUpperCase()+"%";}
		   
			if(input.getStDate() == null || input.getStDate().trim().equals(""))
			{
				input.setStDate(null);
			}
			if(input.getEnDate() == null || input.getEnDate().trim().equals(""))
			{
				input.setEnDate(null);
			}
			List<LtMastDepartments> list = (List<LtMastDepartments>) 
					jdbcTemplate.query(query , new Object[]{companyId, code,name,desc,status,
							input.getStDate(),input.getEnDate(),
							
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							input.getColumnNo(),input.getColumnNo(),
							
							input.getStart()+input.getLength(),input.getStart()+1},
				 new  BeanPropertyRowMapper<LtMastDepartments>(LtMastDepartments.class));
				return list;
	}

	@Override
	public LtMastDepartments save(LtMastDepartments ltMastDepartments) throws ServiceException {
		return ltMastDepartmentsRepository.save(ltMastDepartments);
	}

	@Override
	public LtMastDepartments update(LtMastDepartments ltMastDepartments) throws ServiceException {
		return ltMastDepartmentsRepository.save(ltMastDepartments);
	}

	@Override
	public LtMastDepartments delete(Long id) throws ServiceException {
		if( ltMastDepartmentsRepository.exists(id) ) {
			ltMastDepartmentsRepository.delete(id);
			return null;
		}
		return ltMastDepartmentsRepository.findOne(id);
	}

	@Override
	public LtMastDepartments findById(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastDepartmentsById");
		LtMastDepartments list=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastDepartments>(LtMastDepartments.class));
		return list;
	}

	@Override
	public List<LtMastDepartments> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtMastDepartments");
		List<LtMastDepartments> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastDepartments>(LtMastDepartments.class)); 
		return list;
	}

	@Override
	public List<LtMastDepartments> getLikeName(String name, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastDepartmentsLikeName");
		List<LtMastDepartments> list=   jdbcTemplate.query(query, new Object[]{ "%"+name.toUpperCase()+"%", 
				"%"+name.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastDepartments>(LtMastDepartments.class)); 
		return list;
	}

	@Override
	public List<LtMastDepartments> getByCode(String departmentCode, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastDepartmentsByCode");
		List<LtMastDepartments> list=   jdbcTemplate.query(query, new Object[]{ departmentCode.toUpperCase(), 
			companyId}, 
		 new BeanPropertyRowMapper<LtMastDepartments>(LtMastDepartments.class)); 
		return list;
	}

	

	@Override
	public List<LtMastDepartments> getByName(String departmentName, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastDepartmentsByName");
		List<LtMastDepartments> list=   jdbcTemplate.query(query, new Object[]{ departmentName.toUpperCase(), 
			companyId}, 
		 new BeanPropertyRowMapper<LtMastDepartments>(LtMastDepartments.class)); 
		return list;
	}

}
