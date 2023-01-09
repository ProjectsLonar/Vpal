package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastGradeType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastGradeTypeRepository;

@Repository
@PropertySource(value = "classpath:queries/gradeTypeMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastGradeTypeDaoImpl implements LtMastGradeTypeDao {

	@Autowired
	LtMastGradeTypeRepository ltMastGradeTypeRepository;
	
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
	public Long getCount(LtMastGradeType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastGradeType");
		 
		 String code=null;
		   if(input.getGradeTypeCode()!=null)
		   {code="%"+input.getGradeTypeCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getGradeTypeName()!=null)
		   {name="%"+input.getGradeTypeName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getGradeTypeDesc()!=null)
		   {desc="%"+input.getGradeTypeDesc().toUpperCase()+"%";}
		   
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
	public List<LtMastGradeType> getDataTable(LtMastGradeType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastGradeTypeDatatableRecords");
		 
		 String code=null;
		   if(input.getGradeTypeCode()!=null)
		   {code="%"+input.getGradeTypeCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getGradeTypeName()!=null)
		   {name="%"+input.getGradeTypeName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getGradeTypeDesc()!=null)
		   {desc="%"+input.getGradeTypeDesc().toUpperCase()+"%";}
		   
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
			List<LtMastGradeType> list = (List<LtMastGradeType>) 
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
				 new  BeanPropertyRowMapper<LtMastGradeType>(LtMastGradeType.class));
				return list;
	}

	@Override
	public LtMastGradeType save(LtMastGradeType ltMastGradeType) throws ServiceException {
		return ltMastGradeTypeRepository.save(ltMastGradeType);
	}

	@Override
	public LtMastGradeType update(LtMastGradeType ltMastGradeType) throws ServiceException {
		return ltMastGradeTypeRepository.save(ltMastGradeType);
	}

	@Override
	public LtMastGradeType delete(Long id) throws ServiceException {
		if( ltMastGradeTypeRepository.exists(id) ) {
			ltMastGradeTypeRepository.delete(id);
			 return null;
		}
		return ltMastGradeTypeRepository.findOne(id);
	}

	@Override
	public LtMastGradeType findById(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastGradeTypeById");
		LtMastGradeType list=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastGradeType>(LtMastGradeType.class));
		return list;
	}

	@Override
	public List<LtMastGradeType> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtMastGradeType");
		List<LtMastGradeType> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastGradeType>(LtMastGradeType.class)); 
		return list;
	}

	@Override
	public List<LtMastGradeType> getLikeGradeName(String grade, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastGradeTypeLikegradeType");
		List<LtMastGradeType> list=   jdbcTemplate.query(query, new Object[]{ "%"+grade.toUpperCase()+"%", 
				"%"+grade.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastGradeType>(LtMastGradeType.class)); 
		return list;
	}

	@Override
	public List<LtMastGradeType> getByGradeCode(String gradeTypeCode, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastGradeTypeBygradeCode");
		List<LtMastGradeType> list=   jdbcTemplate.query(query, new Object[]{ gradeTypeCode.toUpperCase(), companyId}, 
		 new BeanPropertyRowMapper<LtMastGradeType>(LtMastGradeType.class)); 
		return list;
	}

	

	@Override
	public List<LtMastGradeType> getByGradeName(String gradeTypeName, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastGradeTypeBygradeName");
		List<LtMastGradeType> list=   jdbcTemplate.query(query, new Object[]{ gradeTypeName.toUpperCase(), companyId}, 
		 new BeanPropertyRowMapper<LtMastGradeType>(LtMastGradeType.class)); 
		return list;
	}

	@Override
	public List<LtMastGradeType> getAllActive(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllActiveLtMastGradeType");
		List<LtMastGradeType> list=   jdbcTemplate.query(query, new Object[]{companyId }, 
		 new BeanPropertyRowMapper<LtMastGradeType>(LtMastGradeType.class)); 
		return list;
	}

}
