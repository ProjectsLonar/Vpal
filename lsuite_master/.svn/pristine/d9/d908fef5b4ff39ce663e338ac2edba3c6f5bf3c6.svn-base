package com.lonar.vendor.vendorportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.vendor.vendorportal.model.LtMastTaxType;
import com.lonar.vendor.vendorportal.model.ServiceException;
import com.lonar.vendor.vendorportal.repository.LtMastTaxTypeRepository;

@Repository
@PropertySource(value = "classpath:queries/taxTypeMasterQueries.properties", ignoreResourceNotFound = true)
public class LtMastTaxTypeDaoImpl implements LtMastTaxTypeDao{

	@Autowired
	LtMastTaxTypeRepository ltMastTaxTypeRepository;
	
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
	public Long getCount(LtMastTaxType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getCountLtMastTaxType");
		 
		   String code=null;
		   if(input.getTaxTypeCode()!=null)
		   {code="%"+input.getTaxTypeCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getTaxTypeName()!=null)
		   {name="%"+input.getTaxTypeName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getTaxTypeDesc()!=null)
		   {desc="%"+input.getTaxTypeDesc().toUpperCase()+"%";}
		   
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
	public List<LtMastTaxType> getDataTable(LtMastTaxType input, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastTaxTypeDatatableRecords");
		 
		  String code=null;
		   if(input.getTaxTypeCode()!=null)
		   {code="%"+input.getTaxTypeCode().toUpperCase()+"%";}
		   
		   String name=null;
		   if(input.getTaxTypeName()!=null)
		   {name="%"+input.getTaxTypeName().toUpperCase()+"%";}
		   
		   String desc=null;
		   if(input.getTaxTypeDesc()!=null)
		   {desc="%"+input.getTaxTypeDesc().toUpperCase()+"%";}
		   
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
			List<LtMastTaxType> list = (List<LtMastTaxType>) 
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
				 new  BeanPropertyRowMapper<LtMastTaxType>(LtMastTaxType.class));
				return list;
	}

	@Override
	public LtMastTaxType save(LtMastTaxType ltMastTaxType) throws ServiceException {
		return ltMastTaxTypeRepository.save(ltMastTaxType);
	}

	@Override
	public LtMastTaxType update(LtMastTaxType ltMastTaxType) throws ServiceException {
		return ltMastTaxTypeRepository.save(ltMastTaxType);
	}

	@Override
	public LtMastTaxType delete(Long id) throws ServiceException {
		if( ltMastTaxTypeRepository.exists(id) ) {
			ltMastTaxTypeRepository.delete(id);
			return null;
		}
		return new LtMastTaxType();
	}

	@Override
	public LtMastTaxType findById(Long id) throws ServiceException {
		String query = env.getProperty("findLtMastTaxTypeById");
		LtMastTaxType ltMastTaxType=   jdbcTemplate.queryForObject(query, new Object[]{id }, 
				new BeanPropertyRowMapper<LtMastTaxType>(LtMastTaxType.class));
		return ltMastTaxType;
	}

	@Override
	public List<LtMastTaxType> getAll() throws ServiceException {
		String query = env.getProperty("getAllLtMastTaxType");
		List<LtMastTaxType> list=   jdbcTemplate.query(query, new Object[]{ }, 
		 new BeanPropertyRowMapper<LtMastTaxType>(LtMastTaxType.class)); 
		return list;
	}

	@Override
	public List<LtMastTaxType> getLikeTaxName(String name, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastTaxTypeLikeTaxTypenName");
		List<LtMastTaxType> list=   jdbcTemplate.query(query, new Object[]{ "%"+name.toUpperCase()+"%", 
				"%"+name.toUpperCase()+"%",companyId}, 
		 new BeanPropertyRowMapper<LtMastTaxType>(LtMastTaxType.class)); 
		return list;
	}

	@Override
	public List<LtMastTaxType> getByTaxTypeName(String taxTypeName, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastTaxTypeByTaxTypenName");
		List<LtMastTaxType> list=   jdbcTemplate.query(query, new Object[]{ taxTypeName.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastTaxType>(LtMastTaxType.class)); 
		return list;
	}

	@Override
	public List<LtMastTaxType> getByTaxTypeCode(String taxTypeCode, Long companyId) throws ServiceException {
		String query = env.getProperty("getLtMastTaxTypeByTaxTypenCode");
		List<LtMastTaxType> list=   jdbcTemplate.query(query, new Object[]{ taxTypeCode.toUpperCase(), 
				companyId}, 
		 new BeanPropertyRowMapper<LtMastTaxType>(LtMastTaxType.class)); 
		return list;
	}

}
