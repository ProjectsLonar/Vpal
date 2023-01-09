package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastPersonType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastPersonTypeRepository;

@Repository
@PropertySource(value = "classpath:queries/personTypeMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastPersonTypeDaoImpl implements LtMastPersonTypeDao{

	@Autowired
	LtMastPersonTypeRepository ltMastPersonTypeRepository;
	
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
	public Long getCount(LtMastPersonType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastPersonType");
		 
		 String code=null;
		   if(input.getPersonTypeCode()!=null)
		   {code="%"+input.getPersonTypeCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getPersonTypeName()!=null)
		   {name="%"+input.getPersonTypeName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getPersonTypeDesc()!=null)
		   {desc="%"+input.getPersonTypeDesc().toUpperCase()+"%";}
		   
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
	public List<LtMastPersonType> getDataTable(LtMastPersonType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastPersonTypeDatatableRecords");
		 
		String code=null;
		   if(input.getPersonTypeCode()!=null)
		   {code="%"+input.getPersonTypeCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getPersonTypeName()!=null)
		   {name="%"+input.getPersonTypeName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getPersonTypeDesc()!=null)
		   {desc="%"+input.getPersonTypeDesc().toUpperCase()+"%";}
		   
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
			List<LtMastPersonType> list = (List<LtMastPersonType>) 
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
				 new  BeanPropertyRowMapper<LtMastPersonType>(LtMastPersonType.class));
				return list;
	}

	@Override
	public LtMastPersonType save(LtMastPersonType ltMastPersonType) throws ServiceException {
		return ltMastPersonTypeRepository.save(ltMastPersonType);
	}

	@Override
	public LtMastPersonType update(LtMastPersonType ltMastPersonType) throws ServiceException {
		return ltMastPersonTypeRepository.save(ltMastPersonType);
	}

	@Override
	public LtMastPersonType delete(Long id) throws ServiceException {
		if( ltMastPersonTypeRepository.exists(id) ) {
			ltMastPersonTypeRepository.delete(id);
			 return null;
		}
		return ltMastPersonTypeRepository.findOne(id);
	}

	@Override
	public LtMastPersonType findById(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastPersonTypeById");
		LtMastPersonType list=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastPersonType>(LtMastPersonType.class));
		return list;
	}

	@Override
	public List<LtMastPersonType> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtMastPersonType");
		List<LtMastPersonType> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastPersonType>(LtMastPersonType.class)); 
		return list;
	}

	@Override
	public List<LtMastPersonType> getLikePersonTypeName(String personType, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastPersonTypeLikePersonType");
		List<LtMastPersonType> list=   jdbcTemplate.query(query, new Object[]{ "%"+personType.toUpperCase()+"%", 
				"%"+personType.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastPersonType>(LtMastPersonType.class)); 
		return list;
	}

	@Override
	public List<LtMastPersonType> getByPersonTypeName(String personTypeName, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastPersonTypeByName");
		List<LtMastPersonType> list=   jdbcTemplate.query(query, new Object[]{ personTypeName.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastPersonType>(LtMastPersonType.class)); 
		return list;
	}

	@Override
	public List<LtMastPersonType> getByPersonTypeCode(String personTypeCode, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastPersonTypeByCode");
		List<LtMastPersonType> list=   jdbcTemplate.query(query, new Object[]{ personTypeCode.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastPersonType>(LtMastPersonType.class)); 
		return list;
	}

	@Override
	public List<LtMastPersonType> getAllActive(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllActiveLtMastPersonType");
		List<LtMastPersonType> list=   jdbcTemplate.query(query, new Object[]{companyId}, 
		 new BeanPropertyRowMapper<LtMastPersonType>(LtMastPersonType.class)); 
		return list;
	}

}
