package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastProductType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastProductTypeRepository;

@Repository
@PropertySource(value = "classpath:queries/productTypeMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastProductTypeDaoImpl implements LtMastProductTypeDao{

	@Autowired
	LtMastProductTypeRepository ltMastProductTypeRepository;
	
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
	public Long getCount(LtMastProductType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastProductType");
		 
		   String code=null;
		   if(input.getProductTypeCode()!=null)
		   {code="%"+input.getProductTypeCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getProductTypeName()!=null)
		   {name="%"+input.getProductTypeName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getProductTypeDesc()!=null)
		   {desc="%"+input.getProductTypeDesc().toUpperCase()+"%";}
		   
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
	public List<LtMastProductType> getDataTable(LtMastProductType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastProductTypeDatatableRecords");
		 
		 String code=null;
		   if(input.getProductTypeCode()!=null)
		   {code="%"+input.getProductTypeCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getProductTypeName()!=null)
		   {name="%"+input.getProductTypeName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getProductTypeDesc()!=null)
		   {desc="%"+input.getProductTypeDesc().toUpperCase()+"%";}
		   
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
			List<LtMastProductType> list = (List<LtMastProductType>) 
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
				 new  BeanPropertyRowMapper<LtMastProductType>(LtMastProductType.class));
				return list;
	}

	@Override
	public LtMastProductType save(LtMastProductType ltMastProductType) throws ServiceException {
		return ltMastProductTypeRepository.save(ltMastProductType);
	}

	@Override
	public LtMastProductType update(LtMastProductType ltMastProductType) throws ServiceException {
		return ltMastProductTypeRepository.save(ltMastProductType);
	}

	@Override
	public LtMastProductType delete(Long id) throws ServiceException {
		if( ltMastProductTypeRepository.exists(id) ) {
			ltMastProductTypeRepository.delete(id);
			return null;
		}
		return new LtMastProductType();
	}

	@Override
	public LtMastProductType findById(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastProductTypeById");
		LtMastProductType ltMastProductType=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastProductType>(LtMastProductType.class));
		return ltMastProductType;
	}

	@Override
	public List<LtMastProductType> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtMastProductType");
		List<LtMastProductType> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastProductType>(LtMastProductType.class)); 
		return list;
	}

	@Override
	public List<LtMastProductType> getLikeProductType(String name, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastProductTypeLikeProTypenName");
		List<LtMastProductType> list=   jdbcTemplate.query(query, new Object[]{ "%"+name.toUpperCase()+"%", 
				"%"+name.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastProductType>(LtMastProductType.class)); 
		return list;
	}

	@Override
	public List<LtMastProductType> getByProductTypeName(String productTypeName, Long companyId)
			throws ServiceException {
		String query = env.getProperty("getLtMastProductTypeByProTypenName");
		List<LtMastProductType> list=   jdbcTemplate.query(query, new Object[]{ productTypeName.toUpperCase(), 
			companyId}, 
		 new BeanPropertyRowMapper<LtMastProductType>(LtMastProductType.class)); 
		return list;
	}

	@Override
	public List<LtMastProductType> getByProductTypeCode(String productTypeCode, Long companyId)
			throws ServiceException {
		String query = env.getProperty("getLtMastProductTypeByProTypenCode");
		List<LtMastProductType> list=   jdbcTemplate.query(query, new Object[]{ productTypeCode.toUpperCase(), 
			companyId}, 
		 new BeanPropertyRowMapper<LtMastProductType>(LtMastProductType.class)); 
		return list;
	}

	@Override
	public List<LtMastProductType> getAllActive(Long companyId) throws ServiceException {
		String query = env.getProperty("getAllActiveLtMastProductType");
		List<LtMastProductType> list=   jdbcTemplate.query(query, new Object[]{ companyId}, 
		 new BeanPropertyRowMapper<LtMastProductType>(LtMastProductType.class)); 
		return list;
	}

}
